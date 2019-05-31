package com.example.jstore_android_jonathan;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViewsService;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText FullNameInput = (EditText) findViewById(R.id.FullNameInput);
        final EditText UserNameInput = (EditText) findViewById(R.id.UsernameInput);
        final EditText EmailInput = (EditText) findViewById(R.id.EmailInput);
        final EditText PasswordInput = (EditText) findViewById(R.id.PasswordInput);
        final Button RegisterButton = (Button) findViewById(R.id.RegisterButton);

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String username = UserNameInput.getText().toString();
                String fullname = FullNameInput.getText().toString();
                String email = EmailInput.getText().toString();
                String password = PasswordInput.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            if (jsonResponse != null) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register Success!").create().show();
                            }
                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                            builder.setMessage("Register Failed!").create().show();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(username, fullname, email, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}
