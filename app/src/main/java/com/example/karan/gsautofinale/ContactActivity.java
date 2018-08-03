package com.example.karan.gsautofinale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactActivity extends AppCompatActivity {

    EditText etContactName,etContactEmail,etContactSubject,etContactMessage;
    Button bSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        etContactName = (EditText) findViewById(R.id.etContactName);
        etContactEmail = (EditText) findViewById(R.id.etContactEmail);
        etContactSubject = (EditText) findViewById(R.id.etContactSubject);
        etContactMessage = (EditText) findViewById(R.id.etContactMessage);
        bSend = (Button) findViewById(R.id.bSend);

        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etContactName.getText().toString();
                String email = etContactEmail.getText().toString();
                String subject = etContactSubject.getText().toString();
                String message = etContactMessage.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);

                Boolean onError = false;
                if (!isValidEmail(email)) {
                    onError = true;
                    etContactEmail.setError("Invalid Email");
                    return;
                }
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"karan.sandhu9698@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,"name:"+name+'\n'+"Email ID:"+email+'\n'+"Message:"+'\n'+message);
                startActivity(Intent.createChooser(intent,"send Email..."));

            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
