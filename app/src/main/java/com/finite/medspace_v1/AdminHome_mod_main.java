package com.finite.medspace_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminHome_mod_main extends AppCompatActivity {

    private Button admin_home_mod_modify_patient_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_mod_main);
        init();
        admin_home_mod_modify_patient_button();

    }
    private void init(){
        admin_home_mod_modify_patient_button = findViewById(R.id.admin_home_mod_modify_patient_button);
    }
    private void admin_home_mod_modify_patient_button(){
        admin_home_mod_modify_patient_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminHome_mod_main.this, TemporaryActivity.class);
                startActivity(intent);
            }
        });
    }
}