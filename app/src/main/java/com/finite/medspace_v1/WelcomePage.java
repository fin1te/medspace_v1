package com.finite.medspace_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class WelcomePage extends AppCompatActivity {

    //declaring the buttons to intent
    private Button wlpg_login_btn,wlpg_contact_us;
    private ImageButton wlpg_credits_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
        init();
        wlpg_login_btn();
        wlpg_contact_us();
        wlpg_credits_btn();
    }

    private void init(){
    wlpg_login_btn = findViewById(R.id.wlpg_login_btn);
    wlpg_contact_us = findViewById(R.id.wlpg_contact_us);
    wlpg_credits_btn = findViewById(R.id.wlpg_credits_btn);
    }

    private void wlpg_login_btn(){
        wlpg_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomePage.this, MainLoginPage.class);
                startActivity(intent);
            }
        });
    }
    private void wlpg_contact_us(){
        wlpg_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomePage.this, ContactUsPage.class);
                startActivity(intent);
            }
        });
    }
    private void wlpg_credits_btn(){
        wlpg_credits_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomePage.this, CreditsPage.class);
                startActivity(intent);
            }
        });
    }
}
