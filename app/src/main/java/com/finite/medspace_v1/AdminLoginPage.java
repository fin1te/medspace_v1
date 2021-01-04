package com.finite.medspace_v1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.finite.medspace_v1.Model.Admin;
import com.finite.medspace_v1.Utils.Global;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminLoginPage extends AppCompatActivity {

    private Button admin_lgpg_backbtn,admin_lgpg_login_btn,admin_lgpg_contact_us;
    private ImageButton admin_lgpg_credits_btn;
    private EditText admin_lgpg_et_username, admin_lgpg_et_password;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_page);

        init();
        admin_lgpg_backbtn();
        admin_lgpg_login_btn();
        admin_lgpg_credits_btn();
        admin_lgpg_contact_us();
    }

    private void init()
    {
        admin_lgpg_backbtn = findViewById(R.id.admin_lgpg_backbtn);
        admin_lgpg_login_btn = findViewById(R.id.admin_lgpg_login_btn);
        admin_lgpg_credits_btn = findViewById(R.id.admin_lgpg_credits_btn);
        admin_lgpg_contact_us = findViewById(R.id.admin_lgpg_contact_us);
        admin_lgpg_et_username = findViewById(R.id.admin_lgpg_et_username);
        admin_lgpg_et_password = findViewById(R.id.admin_lgpg_et_password);

        firebaseAuth = FirebaseAuth.getInstance();
    }
    private void admin_lgpg_login_btn()
    {
        admin_lgpg_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adminUsername = admin_lgpg_et_username.getText().toString();
                String adminPassword = admin_lgpg_et_password.getText().toString();

                if(TextUtils.isEmpty(adminUsername) && TextUtils.isEmpty(adminPassword))
                {
                    admin_lgpg_et_username.setError("Username can not be empty!");
                    admin_lgpg_et_password.setError("Password can not be empty!");
                }
                else if(TextUtils.isEmpty(adminUsername))
                {
                    admin_lgpg_et_username.setError("Username can not be empty");
                }
                else if(TextUtils.isEmpty(adminPassword))
                {
                    admin_lgpg_et_password.setError("Password can not be empty");
                }
                else{
                    firebaseAuth.signInWithEmailAndPassword(adminUsername, adminPassword)
                            .addOnCompleteListener(AdminLoginPage.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Users")
                                                    .child(firebaseAuth.getCurrentUser().getUid());

                                            reference.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                    SharedPreferences.Editor editor = getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit();
                                                    editor.putString(com.finite.medspace_v1.Utils.TextUtils.PREF_LATEST_USER_ID, firebaseAuth.getCurrentUser().getUid());
                                                    editor.apply();

                                                    Intent intent = new Intent(AdminLoginPage.this, AdminHome.class);
                                                    startActivity(intent);
                                                    Global.setCurrentUser(dataSnapshot.getValue(Admin.class));
                                                    finish();
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                                }
                                            });


                                    } else {
                                        Toast.makeText(AdminLoginPage.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }
    private void admin_lgpg_backbtn()
    {
        admin_lgpg_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //Intent intent = new Intent(AdminLoginPage.this, MainLoginPage.class);
                //startActivity(intent);
            }
        });
    }

    private void admin_lgpg_credits_btn()
    {
        admin_lgpg_credits_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminLoginPage.this, CreditsPage.class);
                startActivity(intent);
            }
        });
    }
    private void admin_lgpg_contact_us()
    {
        admin_lgpg_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminLoginPage.this, ContactUsPage.class);
                startActivity(intent);
            }
        });
    }
}