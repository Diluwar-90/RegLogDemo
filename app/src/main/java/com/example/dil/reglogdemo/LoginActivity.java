package com.example.dil.reglogdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etName, etPassword;
    Button btnLogin;
    String Name,Password;
    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name= etName.getText().toString();
                Password = etPassword.getText().toString();
                if (USER_NAME.equals(Name) && PASSWORD.equals(Password)){
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginActivity.this,Details.class);
                    startActivity(i);
                }
            }
        });



    }
}
