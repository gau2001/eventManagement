package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_signup extends AppCompatActivity {
    EditText t1,t2,t3,t4;
    Button b1;
    FirebaseAuth auth;
    ProgressBar p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        t1 = findViewById(R.id.fullName);
        t2 = findViewById(R.id.Email);
        t3 = findViewById(R.id.password);
        t4 = findViewById(R.id.phone);
        b1 = findViewById(R.id.loginbtn);
        auth=FirebaseAuth.getInstance();
        p1=findViewById(R.id.progressBar);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=t2.getText().toString().trim();
                String password=t3.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    t2.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    t3.setError("Password is required");
                    return;
                }
                if (password.length()<6)
                {
                    t3.setError("password must be 8 characters and more");
                    return;
                }
                p1.setVisibility(View.VISIBLE);
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(activity_signup.this, "Registration Sucesfull", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else{
                            Toast.makeText(activity_signup.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            p1.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
    }
}
/*
t1 = findViewById(R.id.fullName);
        t2 = findViewById(R.id.Email);
        t3 = findViewById(R.id.password);
        t4 = findViewById(R.id.phone);
        b1 = findViewById(R.id.loginbtn);
        auth=FirebaseAuth.getInstance();
        p1=findViewById(R.id.progressBar);import com.example.planner.ui.login.LoginViewModelFactory;package com.example.planner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_Register extends AppCompatActivity {
EditText t1,t2,t3,t4;
Button b1;
FirebaseAuth auth;
ProgressBar p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_Register);
        t1 = findViewById(R.id.fullName);
        t2 = findViewById(R.id.Email);
        t3 = findViewById(R.id.password);
        t4 = findViewById(R.id.phone);
        b1 = findViewById(R.id.loginbtn);
        auth=FirebaseAuth.getInstance();
        p1=findViewById(R.id.progressBar);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=t2.getText().toString().trim();
                String password=t3.getText().toString().trim();

                if(TextUtils.isEmpty(email))
                {
                    t2.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password))
                {
                    t3.setError("Password is required");
                    return;
                }
                if (password.length()<6)
                {
                    t3.setError("password must be 8 characters and more");
                    return;
                }
                p1.setVisibility(View.VISIBLE);
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(activity_Register.this, "", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else{
                            Toast.makeText(activity_Register.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            p1.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

    }
}
 */