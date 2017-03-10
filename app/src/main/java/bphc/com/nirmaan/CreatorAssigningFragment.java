package bphc.com.nirmaan;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog;

import java.util.ArrayList;
import java.util.Date;

import bphc.com.nirmaan.object.VolunteerList;
import bphc.com.nirmaan.service.ApiManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class CreatorAssigningFragment extends Fragment {

    AutoCompleteTextView studentSelect;
    Spinner class_select,subject_select,topic_select;
    TextView dateandtime;
    ArrayAdapter<String> volunteerAdapter;
    ArrayList<String> names;
    SingleDateAndTimePickerDialog.Builder picker;

    public CreatorAssigningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creator_assigning, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        studentSelect = (AutoCompleteTextView) view.findViewById(R.id.search_volunteer);
        class_select = (Spinner) view.findViewById(R.id.class_spinner);
        subject_select = (Spinner) view.findViewById(R.id.subject_spinner);
        subject_select = (Spinner) view.findViewById(R.id.subject_spinner);
        dateandtime = (TextView) view.findViewById(R.id.input_date_time);

        dateandtime.setInputType(InputType.TYPE_NULL);

        names = new ArrayList<>();

        picker = new SingleDateAndTimePickerDialog.Builder(getActivity())
                //.bottomSheet()
                .curved()
                .minutesStep(15)
                .title("Scroll to change")
                .listener(new SingleDateAndTimePickerDialog.Listener() {
                    @Override
                    public void onDateSelected(Date date) {
                        dateandtime.setText(date.toString());
                    }
                });

        dateandtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picker.display();
            }
        });

        studentSelect.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.e("names",charSequence.toString());

                if(volunteerAdapter!=null) {
                    volunteerAdapter.clear();
                }

                Call<VolunteerList> volunteerListCall = ApiManager.getInstance().getService()
                        .getVolunteers("nirmaan", "supersix", charSequence.toString());

                volunteerListCall.enqueue(new Callback<VolunteerList>() {
                    @Override
                    public void onResponse(Call<VolunteerList> call, Response<VolunteerList> response) {
                        for(int i=0;i<response.body().getVolunteers().size();i++){
                            names.add(i,response.body().getVolunteers().get(i).getName());
                            Log.e("names",names.get(i));
                        }
                        volunteerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, names);
                        studentSelect.setAdapter(volunteerAdapter);
                        volunteerAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<VolunteerList> call, Throwable t) {
                        Toast.makeText(getActivity(),"Check Internet Connection",Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
