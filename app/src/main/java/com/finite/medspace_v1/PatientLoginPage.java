package com.finite.medspace_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class PatientLoginPage extends AppCompatActivity {

    private Button pat_lgpg_backbtn,pat_lgpg_login_btn,pat_lgpg_contact_us;
    private ImageButton pat_lgpg_credits_btn;
    private EditText pat_lgpg_et_username,pat_lgpg_et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login_page);

        init();
        pat_lgpg_backbtn();
        pat_lgpg_login_btn();
        pat_lgpg_contact_us();
        pat_lgpg_credits_btn();
    }
    private void init()
    {
        pat_lgpg_backbtn = findViewById(R.id.pat_lgpg_backbtn);
        pat_lgpg_login_btn = findViewById(R.id.pat_lgpg_login_btn);
        pat_lgpg_contact_us = findViewById(R.id.pat_lgpg_contact_us);
        pat_lgpg_credits_btn = findViewById(R.id.pat_lgpg_credits_btn);
        pat_lgpg_et_username = findViewById(R.id.pat_lgpg_et_username);
        pat_lgpg_et_password = findViewById(R.id.pat_lgpg_et_password);
    }
    private void pat_lgpg_backbtn()
    {
        pat_lgpg_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //Intent intent = new Intent(PatientLoginPage.this, MainLoginPage.class);
                //startActivity(intent);
            }
        });
    }
    private void pat_lgpg_login_btn()
    {
        pat_lgpg_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ent_user = pat_lgpg_et_username.getText().toString();
                final String ent_pass = pat_lgpg_et_password.getText().toString();
                if((ent_user.equals("rishabh_admin")&&(ent_pass.equals("realpassword")))) {
                Intent intent = new Intent(PatientLoginPage.this, PatientHome.class);
                startActivity(intent);
                }
                else
                {
                    Toast.makeText(PatientLoginPage.this, "Username & Password Don't Match!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void pat_lgpg_contact_us()
    {
        pat_lgpg_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientLoginPage.this, ContactUsPage.class);
                startActivity(intent);
            }
        });
    }
    private void pat_lgpg_credits_btn()
    {
        pat_lgpg_credits_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientLoginPage.this, CreditsPage.class);
                startActivity(intent);
            }
        });
    }
}