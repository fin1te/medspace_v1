package com.finite.medspace_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewPatient2 extends AppCompatActivity {
    private Button edit_pat2_next_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient2);
        init();
        edit_pat1_next_button();

    }

    private void edit_pat1_next_button() {
        edit_pat2_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPatient2.this, ViewPatient3.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        edit_pat2_next_button = findViewById(R.id.edit_pat2_next_button);
    }
}