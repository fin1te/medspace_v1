package com.finite.medspace_v1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class AddPatient3 extends AppCompatActivity {

    private Button add_pat3_finish_button;
    private EditText add_pat3_et_date,add_pat3_et_hospital_name,add_pat3_et_doctor_name,
            add_pat3_et_complaints,add_pat3_et_reports,add_pat3_et_diagnosis,
            add_pat3_et_drugs_prescribed,add_pat3_et_follow_up_date;
    DatabaseReference databaseReference;
    Context context;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient3);
        init();
        Intent intent = getIntent();
        userId = intent.getStringExtra("patientId");
        add_pat3_et_next_button();
        databaseReference = FirebaseDatabase.getInstance().getReference().
                child("Users").child(userId);
    }
    private void init(){
        add_pat3_et_date = findViewById(R.id.add_pat3_et_date);
        add_pat3_et_hospital_name = findViewById(R.id.add_pat3_et_hospital_name);
        add_pat3_et_doctor_name = findViewById(R.id.add_pat3_et_doctor_name);
        add_pat3_et_complaints = findViewById(R.id.add_pat3_et_complaints);
        add_pat3_et_reports = findViewById(R.id.add_pat3_et_reports);
        add_pat3_et_diagnosis = findViewById(R.id.add_pat3_et_diagnosis);
        add_pat3_et_drugs_prescribed = findViewById(R.id.add_pat3_et_drugs_prescribed);
        add_pat3_et_follow_up_date = findViewById(R.id.add_pat3_et_follow_up_date);
        add_pat3_finish_button = findViewById(R.id.add_pat3_next_button);
    }

    private void add_pat3_et_next_button() {
        add_pat3_finish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntent();

                final String str_add_pat3_et_date = add_pat3_et_date.getText().toString();
                final String str_add_pat3_et_hospital_name = add_pat3_et_hospital_name.getText().toString();
                final String str_add_pat3_et_doctor_name = add_pat3_et_doctor_name.getText().toString();
                final String str_add_pat3_et_complaints = add_pat3_et_complaints.getText().toString();
                final String str_add_pat3_et_reports = add_pat3_et_reports.getText().toString();
                final String str_add_pat3_et_diagnosis = add_pat3_et_diagnosis.getText().toString();
                final String str_add_pat3_et_drugs_prescribed = add_pat3_et_drugs_prescribed.getText().toString();
                final String str_add_pat3_et_follow_up_date = add_pat3_et_follow_up_date.getText().toString();

                Query usernameQuery = FirebaseDatabase.getInstance().getReference().child("Users").
                        orderByChild("AadhaarNo").equalTo(str_add_pat3_et_complaints);
                usernameQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //                        if (TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no) && TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no) &&
                        //                                TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no) && TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no) &&
                        //                                TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no) && TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no) &&
                        //                                TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no) && TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no) &&
                        //                                TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no) && TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no) &&
                        //                                TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no) && TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no) &&
                        //                                TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no) && TextUtils.isEmpty((CharSequence) add_pat1_et_aadhaar_no)) {
                        //                            add_pat1_et_aadhaar_no.setError("Username is required!");
                        //                            add_pat1_et_aadhaar_no.setError("Phone No is required!");
                        //                            add_pat1_et_aadhaar_no.setError("Email is required!");
                        //                            add_pat1_et_aadhaar_no.setError("Password is required!");
                        //                            add_pat1_et_aadhaar_no.setError("Retype password is required!");
                        //                        }else if(add_pat1_et_aadhaar_no.length() < 6 )
                        //                        {
                        //                            password.setError("Password should have no less than 6 characters!");
                        //                        }
                        //                        else if(add_pat1_et_aadhaar_no.length() != 10)
                        //                        {
                        //                            phoneNo.setError("Phone should have no less or more than 10 characters!");
                        //
                        //                        }
                        //                        else if(!add_pat1_et_aadhaar_no.equals(str_repassword))
                        //                        {
                        //                            repassword.setError("Password does not match!");
                        //                        }
                        //                        else if(dataSnapshot.getChildrenCount() > 0)
                        //                        {
                        //                            username.setError("Username already exists!");
                        //                        }
                        //                        else {
                        //
                        //                        }
                        update(str_add_pat3_et_date,str_add_pat3_et_hospital_name,str_add_pat3_et_doctor_name,
                                str_add_pat3_et_complaints,str_add_pat3_et_reports,str_add_pat3_et_diagnosis,
                                str_add_pat3_et_drugs_prescribed,str_add_pat3_et_follow_up_date);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
    private void update(String date, String hospitalName, String doctorName,
                        String complaints, String reports, String disgnosis, String drugsPrescribed,
                        String followUpDate){

//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString("patientId", TextUtils.PREF_LATEST_USER_ID);
//        editor.commit();
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("add_pat3_et_date", date);
        hashMap.put("add_pat3_et_hospital_name", hospitalName);
        hashMap.put("add_pat3_et_doctor_name",doctorName);
        hashMap.put("add_pat3_et_complaints", complaints);
        hashMap.put("add_pat3_et_reports", reports);
        hashMap.put("add_pat3_et_diagnosis", disgnosis);
        hashMap.put("add_pat3_et_drugs_prescribed",drugsPrescribed);
        hashMap.put("add_pat3_et_follow_up_date",followUpDate);

        databaseReference.updateChildren(hashMap);

        Intent intent = new Intent(AddPatient3.this, WelcomePage.class);
        startActivity(intent);
    }
}