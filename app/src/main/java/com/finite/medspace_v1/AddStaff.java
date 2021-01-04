package com.finite.medspace_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddStaff extends AppCompatActivity {

    private Button add_staff_next_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);
        init();
        add_staff_next_button();
    }
    private void init(){
        add_staff_next_button = findViewById(R.id.add_staff_next_button);
    }
    private void add_staff_next_button(){
        add_staff_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddStaff.this, TemporaryActivity.class);
                startActivity(intent);
            }
        });
    }
}