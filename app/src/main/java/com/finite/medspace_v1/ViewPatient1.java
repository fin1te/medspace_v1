package com.finite.medspace_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ViewPatient1 extends AppCompatActivity {
    private Button edit_pat1_next_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_patient1);
        init();
        edit_pat1_next_button();

    }

    private void edit_pat1_next_button() {
        edit_pat1_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewPatient1.this, ViewPatient2.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        edit_pat1_next_button = findViewById(R.id.edit_pat1_next_button);
    }
}