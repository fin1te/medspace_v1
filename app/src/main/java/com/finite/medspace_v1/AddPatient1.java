package com.finite.medspace_v1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.finite.medspace_v1.Model.Patient;
import com.finite.medspace_v1.Utils.TextUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class AddPatient1 extends AppCompatActivity {
    private Button add_pat1_et_next_button;
    private EditText add_pat1_et_aadhaar_no, add_pat1_et_name, add_pat1_et_dob, add_pat1_et_address,
            add_pat1_et_pincode, add_pat1_et_phone_no, add_pat1_et_email_id, add_pat1_et_occupation,
            add_pat1_et_marital_status, add_pat1_et_children, add_pat1_et_username,
            add_pat1_et_password;

    private RadioGroup radioGrp;
    private RadioButton add_pat1_radio_m, add_pat1_radio_f;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    public String add_pat1_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient1);
        init();
        add_pat1_et_next_button();
    }

    private void init() {
        add_pat1_et_aadhaar_no = findViewById(R.id.add_pat1_et_aadhaar_no);
        add_pat1_et_name = findViewById(R.id.add_pat1_et_name);
        add_pat1_et_dob = findViewById(R.id.add_pat1_et_dob);
        radioGrp = findViewById(R.id.radioGrp);
        add_pat1_radio_m = findViewById(R.id.add_pat1_radio_m);
        add_pat1_radio_f = findViewById(R.id.add_pat1_radio_f);
        add_pat1_et_address = findViewById(R.id.add_pat1_et_address);
        add_pat1_et_pincode = findViewById(R.id.add_pat1_et_pincode);
        add_pat1_et_phone_no = findViewById(R.id.add_pat1_et_phone_no);
        add_pat1_et_email_id = findViewById(R.id.add_pat1_et_email_id);
        add_pat1_et_occupation = findViewById(R.id.add_pat1_et_occupation);
        add_pat1_et_marital_status = findViewById(R.id.add_pat1_et_marital_status);
        add_pat1_et_children = findViewById(R.id.add_pat1_et_children);
        add_pat1_et_username = findViewById(R.id.add_pat1_et_username);
        add_pat1_et_password = findViewById(R.id.add_pat1_et_password);
          add_pat1_et_next_button = findViewById(R.id.add_pat1_et_next_button);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void add_pat1_et_next_button() {
        add_pat1_et_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String str_add_pat1_et_aadhaar_no = add_pat1_et_aadhaar_no.getText().toString();
                final String str_add_pat1_et_name = add_pat1_et_name.getText().toString();
                final String str_add_pat1_et_dob = add_pat1_et_dob.getText().toString();
                final String str_add_pat1_radio_m = add_pat1_radio_m.getText().toString();
                final String str_add_pat1_radio_f = add_pat1_radio_f.getText().toString();
                final String str_add_pat1_et_address = add_pat1_et_address.getText().toString();
                final String str_add_pat1_et_pincode = add_pat1_et_pincode.getText().toString();
                final String str_add_pat1_et_phone_no = add_pat1_et_phone_no.getText().toString();
                final String str_add_pat1_et_email_id = add_pat1_et_email_id.getText().toString();
                final String str_add_pat1_et_occupation = add_pat1_et_occupation.getText().toString();
                final String str_add_pat1_et_marital_status = add_pat1_et_marital_status.getText().toString();
                final String str_add_pat1_et_children = add_pat1_et_children.getText().toString();
                final String str_add_pat1_et_username = add_pat1_et_username.getText().toString();
                final String str_add_pat1_et_password = add_pat1_et_password.getText().toString();

                Query usernameQuery = FirebaseDatabase.getInstance().getReference().child("Users").
                        orderByChild("AadhaarNo").equalTo(str_add_pat1_et_aadhaar_no);
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
                        register(str_add_pat1_et_aadhaar_no, str_add_pat1_et_name,
                                str_add_pat1_et_dob, str_add_pat1_et_address,
                                str_add_pat1_et_pincode, str_add_pat1_et_phone_no,
                                str_add_pat1_et_email_id, str_add_pat1_et_occupation,
                                str_add_pat1_et_marital_status, str_add_pat1_et_children,
                                str_add_pat1_et_username, str_add_pat1_et_password);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
//                Intent intent = new Intent(AddPatient1.this, AddPatient2.class);
//                startActivity(intent);
            }
        });
    }

    public void register(String aadhaarNo, String name, String dob,
                         String address, String pincode, String phone, String email, String occupation,
                         String maritalstatus, String children, String username, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(AddPatient1.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                            assert firebaseUser != null;
                            final String userID = firebaseUser.getUid();

                            if (task.isSuccessful()) {
                                Toast.makeText(AddPatient1.this, "You have registered successfully!", Toast.LENGTH_SHORT).show();

                                databaseReference = FirebaseDatabase.getInstance().getReference().
                                        child("Users").child(userID);

                                Patient newUser = new Patient();

                                newUser.setPatientId(userID);
                                newUser.setUserType("patient");
                                newUser.setAdd_pat1_et_aadhaar_no(aadhaarNo);
                                newUser.setAdd_pat1_et_name(name);
                                newUser.setAdd_pat1_et_dob(dob);
                                newUser.setAdd_pat1_et_address(address);
                                newUser.setAdd_pat1_et_pincode(pincode);
                                newUser.setAdd_pat1_et_phone_no(phone);
                                newUser.setAdd_pat1_et_email_id(email);
                                newUser.setAdd_pat1_et_occupation(occupation);
                                newUser.setAdd_pat1_et_marital_status(maritalstatus);
                                newUser.setAdd_pat1_et_children(children);
                                newUser.setAdd_pat1_et_username(username);
                                newUser.setAdd_pat1_et_password(password);
                                newUser.setAdd_pat2_et_genetic_disorder("");
                                newUser.setAdd_pat2_et_congenital_anomaly("");
                                newUser.setAdd_pat2_et_allergies("");
                                newUser.setAdd_pat2_et_drug_allergies("");
                                newUser.setAdd_pat2_et_significant_family_history("");
                                newUser.setAdd_pat2_et_significant_injury_trauma("");
                                newUser.setAdd_pat2_et_significant_diagnosis("");
                                newUser.setAdd_pat3_et_date("");
                                newUser.setAdd_pat3_et_hospital_name("");
                                newUser.setAdd_pat3_et_doctor_name("");
                                newUser.setAdd_pat3_et_complaints("");
                                newUser.setAdd_pat3_et_reports("");
                                newUser.setAdd_pat3_et_diagnosis("");
                                newUser.setAdd_pat3_et_drugs_prescribed("");
                                newUser.setAdd_pat3_et_follow_up_date("");

                                databaseReference.setValue(newUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {

                                            add_pat1_test = userID;
                                            Intent intent = new Intent(AddPatient1.this, AddPatient2.class);
                                            intent.putExtra("patientId", add_pat1_test);
                                            startActivity(intent);
                                            firebaseAuth.signOut();
                                        }
                                    }
                                });
                            } else {
                                Toast.makeText(AddPatient1.this, Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(AddPatient1.this, "You can't register with this email or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}