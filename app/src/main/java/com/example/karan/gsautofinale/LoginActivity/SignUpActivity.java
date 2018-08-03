package com.example.karan.gsautofinale.LoginActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.karan.gsautofinale.MainActivity;
import com.example.karan.gsautofinale.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    FirebaseAuth fAuth;
    EditText etName,etDob,etMobile,etUsername,etPass,etLocation;
    Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fAuth = FirebaseAuth.getInstance();

        etName = (EditText) findViewById(R.id.etName);
        etDob = (EditText) findViewById(R.id.etDob);
        etMobile = (EditText) findViewById(R.id.etMobile);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPass = (EditText) findViewById(R.id.etPass);
        etLocation = (EditText) findViewById(R.id.etLocation);
        bRegister = (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = etUsername.getText().toString();
                String pass = etPass.getText().toString();
                String name = etName.getText().toString();

                Register(username,pass,name);

                if (TextUtils.isEmpty(name)){
                    Toast.makeText(SignUpActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(username)){
                    Toast.makeText(SignUpActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(pass)){
                    Toast.makeText(SignUpActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                }
                if (pass.length()<6){
                    Toast.makeText(SignUpActivity.this, "Password too small", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

    private void Register(String username,String pass,String name){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait we are Signing you up....");
        progressDialog.show();

        fAuth.createUserWithEmailAndPassword(username,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    String user_id = fAuth.getCurrentUser().getUid();
                    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference().child("users").child(user_id);

                    String name = etName.getText().toString();
                    String dob = etDob.getText().toString();
                    String mobile = etMobile.getText().toString();
                    String location = etLocation.getText().toString();

                    Map map = new HashMap();
                    map.put("Name",name);
                    map.put("Dob",dob);
                    map.put("Mobile",mobile);
                    map.put("Location",location);

                    myRef.setValue(map);

                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                    progressDialog.dismiss();

                    Toast.makeText(SignUpActivity.this, "Registered", Toast.LENGTH_SHORT).show();

                }else {

                    Toast.makeText(SignUpActivity.this, "Error while registering you", Toast.LENGTH_SHORT).show();

                    progressDialog.dismiss();
                }
            }
        });
    }
}
