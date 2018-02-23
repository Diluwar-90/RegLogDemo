package com.example.dil.reglogdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    TextView tvName,tvEmail,tvPhone,tvGender,tvCountry;
    String mName,mEmail,mPhone,mGender,mCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

       /* tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvGender = findViewById(R.id.tvGender);
        tvCountry = findViewById(R.id.tvCountry);

        Intent intent = getIntent();
        mName = (intent.getExtras().getString("Name"));
        mEmail = (intent.getExtras().getString("Email"));
        mPhone = (intent.getExtras().getString("Phone"));
        mGender = (intent.getExtras().getString("Gender"));
        mCountry = (intent.getExtras().getString("countryName"));

        tvName.setText("Name : " +mName);
        tvEmail.setText("Email : " +mEmail);
        tvPhone.setText("Phone : " +mPhone);
        tvGender.setText("Gender : " +mGender);
        tvCountry.setText("Country : " +mCountry);*/

    }
}
