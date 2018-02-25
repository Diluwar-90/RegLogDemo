package com.example.dil.reglogdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginWithQRcode extends AppCompatActivity implements View.OnClickListener{
    private Button buttonScan;
    private TextView textViewName, textViewAddress;
    private IntentIntegrator qrScan;
    private static final String USER_NAME = "Diluwar";
    private static final String PASSWORD = "123456";
    String UserName,Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_qrcode);
        buttonScan = (Button) findViewById(R.id.buttonScan);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewAddress = (TextView) findViewById(R.id.textViewAddress);

        qrScan = new IntentIntegrator(this);

        buttonScan.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if (result != null){
            //if qrcode has nothing in it
            if (result.getContents() == null){
                Toast.makeText(this,"Result not found!",Toast.LENGTH_LONG).show();
            }else {
                try {
                    JSONObject object = new JSONObject(result.getContents());
                    UserName = object.getString("name");
                    Password = object.getString("password");
                    textViewName.setText(UserName);
                    textViewAddress.setText(Password);


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                    //textViewAddress.setText(result.getContents());


                }
            }
        }else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onClick(View view) {
        qrScan.initiateScan();
        if (USER_NAME.equals(UserName) && PASSWORD.equals(Password)){
            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_LONG).show();
            Intent i = new Intent(LoginWithQRcode.this,Details.class);
            startActivity(i);
        }

    }
}
