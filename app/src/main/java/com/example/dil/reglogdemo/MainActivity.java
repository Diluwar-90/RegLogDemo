package com.example.dil.reglogdemo;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText etName,etPhone,etEmail,etPass,etConPass;
    RadioGroup radioGroup_Gender;
    Spinner myspinner;
    Button btnSign_Up;
    String Name, Phone,Email,Password,conPassword,Gender,countryName;
    int selected_gender_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextInputLayout nameWrapper =  findViewById(R.id.nameWrapper);
        final TextInputLayout phoneWrapper = findViewById(R.id.phoneWrapper);

        nameWrapper.setHint("Name ");
        phoneWrapper.setHint("Phone");

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        etConPass = findViewById(R.id.etConPass);
        radioGroup_Gender = findViewById(R.id.radioGroup);
        myspinner = findViewById(R.id.mySpinner);

        TextView tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(login);
            }
        });

        btnSign_Up = findViewById(R.id.btnSignUp);

        btnSign_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameWrapper.getEditText().getText().toString();
                String phone = phoneWrapper.getEditText().getText().toString();

                Name = etName.getText().toString();
                Email = etEmail.getText().toString();
                Phone = etPhone.getText().toString();
                Password = etPass.getText().toString();
                conPassword = etConPass.getText().toString();
                selected_gender_ID = radioGroup_Gender.getCheckedRadioButtonId();
                if(selected_gender_ID == R.id.btnMale)
                    Gender = "Male";
                else
                    Gender = "Male";
                countryName = myspinner.getSelectedItem().toString();


                if (Name.length() == 0){
                    nameWrapper.setError("Name can not be blank");
                    return;
                }
                else if (!isValidMobile(phone)){
                    phoneWrapper.setError("Invalid Phone No");
                    return;
                }
                else if (!isValidEmail(Email)){
                    etEmail.setError("Invalid Email");
                    return;
                }
                else if (!isValidPassword(Password)){
                    etPass.setError("Invalid Password");
                    return;
                }
                else if (!Password.equals(conPassword)){
                    etConPass.setError("Password can not match");
                    return;
                }
                Toast.makeText(getBaseContext(),"Registration is successfull"  ,Toast.LENGTH_LONG).show();

                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                /*i.putExtra("Name",Name);
                i.putExtra("Email",Email);
                i.putExtra("Phone",Phone);
                i.putExtra("Gender",Gender);
                i.putExtra("countryName",countryName);*/
                startActivity(i);

            }
        });
    }
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() > 5) {
            return true;
        }
        return false;
    }
    private boolean isValidMobile(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }
}

