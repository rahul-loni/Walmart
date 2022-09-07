package com.example.walmart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void back_arrow_login(View view) {
        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    public void Forgot_Password(View view) {
        Intent intent=new Intent(getApplicationContext(),ForgotPassword.class);
        startActivity(intent);
    }

    public void register_now(View view) {
        Intent intent=new Intent(getApplicationContext(),Signup.class);
        startActivity(intent);
    }
}