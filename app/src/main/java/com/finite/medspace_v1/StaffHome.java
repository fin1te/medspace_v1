package com.finite.medspace_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StaffHome extends AppCompatActivity {

    private Button staff_home_back_button,staff_home_add_button,staff_home_view_button,staff_home_contact_us;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home);
        init();
        staff_home_back_button();
        staff_home_add_button();
        staff_home_view_button();
        staff_home_contact_us();
    }
    private void init(){
        staff_home_back_button = findViewById(R.id.staff_home_back_button);
        staff_home_add_button = findViewById(R.id.staff_home_add_button);
        staff_home_view_button = findViewById(R.id.staff_home_view_button);
        staff_home_contact_us = findViewById(R.id.staff_home_contact_us);
    }
    private void staff_home_back_button(){
        staff_home_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void staff_home_add_button(){
        staff_home_add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffHome.this, AddPatient1.class);
                startActivity(intent);
            }
        });
    }
    private void staff_home_view_button(){
        staff_home_view_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffHome.this, PatientHome.class);
                startActivity(intent);
            }
        });
    }
    private void staff_home_contact_us(){
        staff_home_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffHome.this, ContactUsPage.class);
                startActivity(intent);
            }
        });
    }
}