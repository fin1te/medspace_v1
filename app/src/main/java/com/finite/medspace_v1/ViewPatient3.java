package com.finite.medspace_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewPatient3 extends AppCompatActivity {
    private Button add_pat3_next_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient3);
        init();
        add_pat3_next_button();

    }

    private void init() {
        add_pat3_next_button = findViewById(R.id.add_pat3_next_button);
    }

    private void add_pat3_next_button() {
        add_pat3_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPatient3.this, WelcomePage.class);
                startActivity(intent);
            }
        });
    }
}