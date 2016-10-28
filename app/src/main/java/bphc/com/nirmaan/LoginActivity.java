package bphc.com.nirmaan;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bphc.com.nirmaan.model.SignIn;
import bphc.com.nirmaan.model.SignUp;
import bphc.com.nirmaan.service.ApiManager;
import bphc.com.nirmaan.service.BuildApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    int in_up=0;
    Button signin,signup,submit;
    TextInputLayout input_username,input_password,input_retype,input_usertype;
    EditText username,password,retype,usertype;
    BuildApi service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signin = (Button) findViewById(R.id.signin);
        signup = (Button) findViewById(R.id.signup);
        submit = (Button) findViewById(R.id.sign_submit);

        input_username = (TextInputLayout) findViewById(R.id.input_sign_username);
        input_password = (TextInputLayout) findViewById(R.id.input_sign_password);
        input_retype = (TextInputLayout) findViewById(R.id.input_sign_retype_password);
        input_usertype = (TextInputLayout) findViewById(R.id.input_sign_user_type);

        username = (EditText) findViewById(R.id.sign_username);
        password = (EditText) findViewById(R.id.sign_password);
        retype = (EditText) findViewById(R.id.sign_retype_password);
        usertype = (EditText) findViewById(R.id.sign_user_type);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(in_up == 0) {
                    Call<SignIn> call = ApiManager.getInstance().getService().authenticateUser(username.getText().toString(), password.getText().toString());
                    call.enqueue(new Callback<SignIn>() {
                        @Override
                        public void onResponse(Call<SignIn> call, Response<SignIn> response) {
                            Log.e("Sign in", response.message());
                        }

                        @Override
                        public void onFailure(Call<SignIn> call, Throwable t) {
                            Log.e("Sign in", t.toString());
                        }
                    });
                }else{
                    Call<SignUp> call = ApiManager.getInstance().getService().registerUser(username.getText().toString(), password.getText().toString(), usertype.getText().toString());
                    call.enqueue(new Callback<SignUp>() {
                        @Override
                        public void onResponse(Call<SignUp> call, Response<SignUp> response) {
                            Log.e("Sign up", response.message());
                        }
                        @Override
                        public void onFailure(Call<SignUp> call, Throwable t) {
                            Log.e("Sign up", t.toString());
                        }
                    });
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_retype.setVisibility(View.VISIBLE);
                input_usertype.setVisibility(View.VISIBLE);
                signup.setBackgroundColor(Color.CYAN);
                signin.setBackgroundColor(Color.GRAY);
                in_up = 1;
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_retype.setVisibility(View.GONE);
                input_usertype.setVisibility(View.GONE);
                signup.setBackgroundColor(Color.GRAY);
                signin.setBackgroundColor(Color.CYAN);
                in_up = 0;
            }
        });
    }
}
