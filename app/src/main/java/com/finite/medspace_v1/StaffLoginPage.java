package com.finite.medspace_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class StaffLoginPage extends AppCompatActivity {

    private Button staff_lgpg_backbtn,staff_lgpg_login_btn,staff_lgpg_contact_us;
    private ImageButton staff_lgpg_credits_btn;
    private EditText staff_lgpg_et_username,staff_lgpg_et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_login_page);
    init();
    staff_lgpg_backbtn();
    staff_lgpg_login_btn();
    staff_lgpg_contact_us();
    staff_lgpg_credits_btn();
    }

    private void init()
    {
        staff_lgpg_backbtn = findViewById(R.id.staff_lgpg_backbtn);
        staff_lgpg_login_btn = findViewById(R.id.staff_lgpg_login_btn);
        staff_lgpg_contact_us = findViewById(R.id.staff_lgpg_contact_us);
        staff_lgpg_credits_btn = findViewById(R.id.staff_lgpg_credits_btn);
        staff_lgpg_et_username = findViewById(R.id.staff_lgpg_et_username);
        staff_lgpg_et_password = findViewById(R.id.staff_lgpg_et_password);
    }
    private void staff_lgpg_backbtn()
    {
        staff_lgpg_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //Intent intent = new Intent(StaffLoginPage.this, MainLoginPage.class);
                //startActivity(intent);
            }
        });
    }
    private void staff_lgpg_login_btn()
    {
        staff_lgpg_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ent_user = staff_lgpg_et_username.getText().toString();
                final String ent_pass = staff_lgpg_et_password.getText().toString();
                if((ent_user.equals("staff@medspace.com")&&(ent_pass.equals("staffs")))) {
                Intent intent = new Intent(StaffLoginPage.this, StaffHome.class);
                startActivity(intent);
                }
                else
                {
                    Toast.makeText(StaffLoginPage.this, "Username & Password Don't Match!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void staff_lgpg_contact_us()
    {
        staff_lgpg_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffLoginPage.this, ContactUsPage.class);
                startActivity(intent);
            }
        });
    }
    private void staff_lgpg_credits_btn()
    {
        staff_lgpg_credits_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffLoginPage.this, CreditsPage.class);
                startActivity(intent);
            }
        });
    }
}