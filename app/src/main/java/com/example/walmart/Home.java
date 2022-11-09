package com.example.walmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements
        BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationItemView bottomNavigationItemView;
    NavigationView navigationView;

    ImageView ACustomer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ACustomer=findViewById(R.id.addCustomerClick);
        ACustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent ACustomerIntent=new Intent(Home.this, AddCustomer.class);
               startActivity(ACustomerIntent);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){
            case R.id.item2:
                Intent intent=new Intent(Home.this,Login.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}