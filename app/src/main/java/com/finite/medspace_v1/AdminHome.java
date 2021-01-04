package com.finite.medspace_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHome extends AppCompatActivity {

    private Button admin_home_back_button,admin_home_add_staff_button,admin_home_next_button;
    private Button admin_home_add_patient_button,admin_home_view_button,admin_home_contact_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        init();
        admin_home_back_button();
        admin_home_add_staff_button();
        admin_home_next_button();
        admin_home_add_patient_button();
        admin_home_view_button();
        admin_home_contact_us();
    }
    private void init()
    {
        admin_home_back_button = findViewById(R.id.admin_home_back_button);
        admin_home_add_staff_button = findViewById(R.id.admin_home_add_staff_button);
        admin_home_next_button = findViewById(R.id.admin_home_next_button);
        admin_home_add_patient_button = findViewById(R.id.admin_home_add_patient_button);
        admin_home_view_button = findViewById(R.id.admin_home_view_button);
        admin_home_contact_us = findViewById(R.id.admin_home_contact_us);
    }
    private void admin_home_back_button(){
        admin_home_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void admin_home_add_staff_button(){
        admin_home_add_staff_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, AddStaff.class);
                startActivity(intent);
            }
        });
    }
    private void admin_home_next_button(){
        admin_home_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, AdminHome_mod_main.class);
                startActivity(intent);
            }
        });
    }
    private void admin_home_add_patient_button(){
        admin_home_add_patient_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, AddPatient1.class);
                startActivity(intent);
            }
        });
    }
    private void admin_home_view_button(){
        admin_home_view_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, PatientHome.class);
                startActivity(intent);
            }
        });
    }
    private void admin_home_contact_us(){
        admin_home_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome.this, ContactUsPage.class);
                startActivity(intent);
            }
        });
    }
}