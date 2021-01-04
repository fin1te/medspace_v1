package com.finite.medspace_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PatientHome extends AppCompatActivity {

    private Button pat_home_back_button,pat_search_button,pat_contact_us;
    private EditText pat_aadhaar_text_box;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);
        init();
        pat_home_back_button();
        pat_search_button();
        pat_contact_us();
    }
    private void init(){
        pat_home_back_button = findViewById(R.id.pat_home_back_button);
        pat_search_button = findViewById(R.id.add_pat1_et_next_button);
        pat_contact_us = findViewById(R.id.pat_contact_us);
        pat_aadhaar_text_box = findViewById(R.id.pat_aadhaar_text_box);
    }
    private void pat_home_back_button(){
        pat_home_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void pat_search_button(){
        pat_search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String entered_aadhaar = pat_aadhaar_text_box.getText().toString();
                double value = Double.parseDouble(entered_aadhaar);
                Double match_val = 123456789012D;
                if(value==123456789012D) {
                    Intent intent = new Intent(PatientHome.this, ViewPatient1.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(PatientHome.this, "Aadhaar Number did not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void pat_contact_us(){
        pat_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PatientHome.this, ContactUsPage.class);
                startActivity(intent);
            }
        });
    }
}