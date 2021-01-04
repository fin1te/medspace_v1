package com.finite.medspace_v1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.finite.medspace_v1.Utils.TextUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class AddPatient2 extends AppCompatActivity {

    private Button add_pat2_et_next_button;
    private CheckBox add_pat2_hypertension;
    private RadioGroup add_pat2_radioGroup,add_pat2_radioGroup2;
    private RadioButton add_pat2_diabetes_type1,add_pat2_diabetes_type2,add_pat2_hyperthyroidism,add_pat2_hypothyroidism;
    private EditText add_pat2_et_genetic_disorder,add_pat2_et_congenital_anomaly,
            add_pat2_et_allergies,add_pat2_et_drug_allergies,add_pat2_et_significant_family_history,
            add_pat2_et_significant_injury_trauma,add_pat2_et_significant_diagnosis;
    DatabaseReference databaseReference;
    Context context;
    String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient2);
        init();
        Intent intent = getIntent();
        userId = intent.getStringExtra("patientId");
        add_pat2_et_next_button();
        databaseReference = FirebaseDatabase.getInstance().getReference().
                child("Users").child(userId);
    }
    private void init(){
        add_pat2_hypertension = findViewById(R.id.add_pat2_hypertension);
        add_pat2_radioGroup = findViewById(R.id.add_pat2_radioGroup);
        add_pat2_diabetes_type1 = findViewById(R.id.add_pat2_diabetes_type1);
        add_pat2_diabetes_type2 = findViewById(R.id.add_pat2_diabetes_type2);
        add_pat2_radioGroup2 = findViewById(R.id.add_pat2_radioGroup2);
        add_pat2_hyperthyroidism = findViewById(R.id.add_pat2_hyperthyroidism);
        add_pat2_hypothyroidism = findViewById(R.id.add_pat2_hypothyroidism);
        add_pat2_et_genetic_disorder = findViewById(R.id.add_pat2_et_genetic_disorder);
        add_pat2_et_congenital_anomaly = findViewById(R.id.add_pat2_et_congenital_anomaly);
        add_pat2_et_allergies = findViewById(R.id.add_pat2_et_allergies);
        add_pat2_et_drug_allergies = findViewById(R.id.add_pat2_et_drug_allergies);
        add_pat2_et_significant_family_history = findViewById(R.id.add_pat2_et_significant_family_history);
        add_pat2_et_significant_injury_trauma = findViewById(R.id.add_pat2_et_significant_injury_trauma);
        add_pat2_et_significant_diagnosis = findViewById(R.id.add_pat2_et_significant_diagnosis);
        add_pat2_et_next_button = findViewById(R.id.add_pat2_et_next_button);
    }

    private void add_pat2_et_next_button() {
        add_pat2_et_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntent();

                //                final String str_add_pat2_hypertension = add_pat2_hypertension.getText().toString();
                final String str_add_pat2_et_genetic_disorder = add_pat2_et_genetic_disorder.getText().toString();
                final String str_add_pat2_et_congenital_anomaly = add_pat2_et_congenital_anomaly.getText().toString();
                final String str_add_pat2_et_allergies = add_pat2_et_allergies.getText().toString();
                final String str_add_pat2_et_drug_allergies = add_pat2_et_drug_allergies.getText().toString();
                final String str_add_pat2_et_significant_family_history = add_pat2_et_significant_family_history.getText().toString();
                final String str_add_pat2_et_significant_injury_trauma = add_pat2_et_significant_injury_trauma.getText().toString();
                final String str_add_pat2_et_significant_diagnosis = add_pat2_et_significant_diagnosis.getText().toString();

                Query usernameQuery = FirebaseDatabase.getInstance().getReference().child("Users").
                        orderByChild("AadhaarNo").equalTo(str_add_pat2_et_allergies);
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
                        update(str_add_pat2_et_genetic_disorder,str_add_pat2_et_congenital_anomaly,
                                str_add_pat2_et_allergies,str_add_pat2_et_drug_allergies,
                                str_add_pat2_et_significant_family_history,
                                str_add_pat2_et_significant_injury_trauma,str_add_pat2_et_significant_diagnosis);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
    private void update(String genetic_disorder, String cogenital_anomaly, String allergies,
                        String drug_allergies, String sig_family_history, String sig_injury_trauma, String sig_diagnosis){

//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
//        SharedPreferences.Editor editor = preferences.edit();
//        editor.putString("patientId", TextUtils.PREF_LATEST_USER_ID);
//        editor.commit();
        HashMap<String, Object> hashMap = new HashMap<>();

        hashMap.put("add_pat2_et_genetic_disorder", genetic_disorder);
        hashMap.put("add_pat2_et_congenital_anomaly", cogenital_anomaly);
        hashMap.put("add_pat2_et_allergies",allergies);
        hashMap.put("add_pat2_et_drug_allergies", drug_allergies);
        hashMap.put("add_pat2_et_significant_family_history", sig_family_history);
        hashMap.put("add_pat2_et_significant_injury_trauma", sig_injury_trauma);
        hashMap.put("add_pat2_et_significant_diagnosis",sig_diagnosis);

        databaseReference.updateChildren(hashMap);

        Intent intent = new Intent(AddPatient2.this, AddPatient3.class);
        intent.putExtra("patientId", userId);
        startActivity(intent);
    }
}