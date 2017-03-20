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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.florent37.singledateandtimepicker.dialog.SingleDateAndTimePickerDialog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bphc.com.nirmaan.object.Subjects;
import bphc.com.nirmaan.object.Topic;
import bphc.com.nirmaan.object.TopicList;
import bphc.com.nirmaan.object.VolunteerList;
import bphc.com.nirmaan.service.ApiManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreatorAssigningFragment extends Fragment {

    AutoCompleteTextView volunteerSelect;
    Spinner class_select,subject_select,topic_select;
    TextView dateandtime;
    long selectedTime =0;
    ArrayAdapter<String> classAdapter;
    ArrayAdapter<String> volunteerAdapter;
    ArrayList<String> names=null,classes=null,subjects=null,topics=null;
    SingleDateAndTimePickerDialog.Builder picker;
    ArrayAdapter<String> subjectsAdapter = null,topicsAdapter = null;
    String vol_id =null,selectedClass="",selectedSubject="",selectedTopic="";
    List<Topic> topicList = null;
    Button assign;

    public CreatorAssigningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        names = new ArrayList<>();
        subjects = new ArrayList<>();
        subjects.add("Select a class for subjects:");
        topics =new ArrayList<>();
        topics.add("Select a subject for topics:");
        classes = new ArrayList<>();
        classes.add(0,"Select a class :");
        classes.add(1,"1");
        classes.add(2,"2");
        classes.add(3,"3");
        classes.add(4,"4");
        classes.add(5,"5");
        classes.add(6,"6");
        classes.add(7,"7");
        classes.add(8,"8");
        classes.add(9,"9");
        classes.add(10,"10");

        return inflater.inflate(R.layout.fragment_creator_assigning, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        volunteerSelect = (AutoCompleteTextView) view.findViewById(R.id.search_volunteer);
        class_select = (Spinner) view.findViewById(R.id.class_spinner);
        subject_select = (Spinner) view.findViewById(R.id.subject_spinner);
        topic_select = (Spinner) view.findViewById(R.id.topic_spinner);
        dateandtime = (TextView) view.findViewById(R.id.input_date_time);

        dateandtime.setInputType(InputType.TYPE_NULL);

        assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!vol_id.isEmpty()){
                    if (!selectedClass.isEmpty()){
                        if (!selectedSubject.isEmpty()){
                            if (selectedTime!=0){

                            }else{

                            }
                        }else{

                        }
                    }else{

                    }
                }else{
                    Toast.makeText(getActivity(),"Select a volunteer",Toast.LENGTH_SHORT).show();
                }
            }
        });

        picker = new SingleDateAndTimePickerDialog.Builder(getActivity())
                .curved()
                .minutesStep(15)
                .title("Scroll to change")
                .listener(new SingleDateAndTimePickerDialog.Listener() {
                    @Override
                    public void onDateSelected(Date date) {
                        selectedTime = date.getTime();
                        dateandtime.setText(date.toString());
                    }
                });

        dateandtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                picker.display();
            }
        });

        volunteerSelect.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

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
                        }
                        volunteerAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, names);
                        volunteerSelect.setAdapter(volunteerAdapter);
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

        classAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item, classes);
        class_select.setAdapter(classAdapter);

        subjectsAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,subjects);
        subject_select.setAdapter(subjectsAdapter);
        subjectsAdapter.notifyDataSetChanged();

        topicsAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,topics);
        topic_select.setAdapter(topicsAdapter);
        topicsAdapter.notifyDataSetChanged();

        class_select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedClass = classes.get(i);
                if (i!=0) {
                    Log.e("hello from class","hello from class 1 ");
                    Call<Subjects> subjectsCall = ApiManager.getInstance().getService().getSubjects(selectedClass);
                    subjectsCall.enqueue(new Callback<Subjects>() {
                        @Override
                        public void onResponse(Call<Subjects> call, Response<Subjects> response) {
                            subjects = (ArrayList<String>) response.body().getSubjects();
                            for(int i=0;i<subjects.size();i++){
                                Log.e("subejcts",subjects.get(i));
                            }
                            subjectsAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,subjects);
                            subject_select.setAdapter(subjectsAdapter);
                            subjectsAdapter.notifyDataSetChanged();
                            subject_select.setEnabled(true);
                        }

                        @Override
                        public void onFailure(Call<Subjects> call, Throwable t) {
                            Toast.makeText(getActivity(), "Check Internet Connection", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        subject_select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedSubject = subjects.get(i);
                final Call<TopicList> topicListCall = ApiManager.getInstance().getService().getTopics(selectedClass,selectedSubject);
                if(!selectedSubject.equals(null)) {
                    topicListCall.enqueue(new Callback<TopicList>() {
                        @Override
                        public void onResponse(Call<TopicList> call, Response<TopicList> response) {
                            topicList = response.body().getTopics();
                            if (topicList.size()!=0){
                                topics.clear();
                            }
                            for (int i = 0; i < topicList.size(); i++) {
                                Log.e("topic names",topicList.get(i).getChapterName());
                                topics.add(i, topicList.get(i).getChapterName());
                            }
                            if(topics!=null) {
                                topicsAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, topics);
                                topic_select.setAdapter(topicsAdapter);
                                topicsAdapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onFailure(Call<TopicList> call, Throwable t) {
                            Toast.makeText(getActivity(), "Check Internet Connection", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        topic_select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedTopic = subjects.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /*if(!subjects.get(0).equals("Select a class for subjects:")){
            subject_select.setEnabled(true);
            subjectsAdapter.notifyDataSetChanged();
        }

        if (!topics.get(0).equals("Select a subject for topics:")){
//            topic_select.setEnabled(true);
            topicsAdapter.notifyDataSetChanged();
        }*/

    }
}
