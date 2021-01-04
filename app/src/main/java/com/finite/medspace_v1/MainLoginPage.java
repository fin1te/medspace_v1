package com.finite.medspace_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainLoginPage extends AppCompatActivity {

    private Button mnlgpg_admin_btn,mnlgpg_staff_btn,mnlgpg_patient_btn,mnlgpg_contact_us,mnlgpg_back_btn;
    private ImageButton mnlgpg_credits_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login_page);

        init();
        mnlgpg_admin_btn();
        mnlgpg_staff_btn();
        mnlgpg_patient_btn();
        mnlgpg_contact_us();
        mnlgpg_credits_btn();
        mnlgpg_back_btn();
    }
    private void init()
    {
        mnlgpg_admin_btn = findViewById(R.id.mnlgpg_admin_btn);
        mnlgpg_staff_btn = findViewById(R.id.mnlgpg_staff_btn);
        mnlgpg_patient_btn = findViewById(R.id.mnlgpg_patient_btn);
        mnlgpg_contact_us = findViewById(R.id.mnlgpg_contact_us);
        mnlgpg_credits_btn = findViewById(R.id.mnlgpg_credits_btn);
        mnlgpg_back_btn = findViewById(R.id.mnlgpg_back_btn);
    }
    private void mnlgpg_admin_btn()
    {
        mnlgpg_admin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLoginPage.this, AdminLoginPage.class);
                startActivity(intent);
            }
        });
    }
    private void mnlgpg_staff_btn()
    {
        mnlgpg_staff_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLoginPage.this, StaffLoginPage.class);
                startActivity(intent);
            }
        });
    }
    private void mnlgpg_patient_btn()
    {
        mnlgpg_patient_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLoginPage.this, PatientLoginPage.class);
                startActivity(intent);
            }
        });
    }
    private void mnlgpg_contact_us()
    {
        mnlgpg_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLoginPage.this, ContactUsPage.class);
                startActivity(intent);
            }
        });
    }
    private void mnlgpg_credits_btn()
    {
        mnlgpg_credits_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLoginPage.this, CreditsPage.class);
                startActivity(intent);
            }
        });
    }
    private void mnlgpg_back_btn()
    {
        mnlgpg_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //Intent intent = new Intent(MainLoginPage.this, WelcomePage.class);
                //startActivity(intent);
            }
        });
    }
}