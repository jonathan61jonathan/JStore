package com.example.jstore_android_jonathan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText EmailInput = (EditText) findViewById(R.id.EmailInput);
        final EditText PasswordInput = (EditText) findViewById(R.id.PasswordInput);
        final Button LoginButton = (Button) findViewById(R.id.LogInButton);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = EmailInput.getText().toString();
                final String password = PasswordInput.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            if (jsonResponse != null) {
                                String name = jsonResponse.getString("name");
                                String email = jsonResponse.getString("email");
                                String username = jsonResponse.getString("username");
                                String password = jsonResponse.getString("password");
                                int id = Integer.valueOf(jsonResponse.getString("id"));
                                String birthDate = jsonResponse.getString("birthDate");

                                AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginActivity.this);
                                builder1.setMessage("Login Success!").create().show();

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("name", name);
                                intent.putExtra("email", email);
                                intent.putExtra("username", username);
                                intent.putExtra("password", password);
                                intent.putExtra("id", id);
                                intent.putExtra("birthDate", birthDate);
                                startActivity(intent);
                            }
                        } catch (JSONException e) {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(LoginActivity.this);
                            builder1.setMessage("Login Failed!").create().show();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(email, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });

        final TextView registerClickable = (TextView) findViewById(R.id.RegisterLink);
        registerClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regisIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(regisIntent);
            }
        });
    }
}