package com.dodemy.android.androidsharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String My_PREFERENCES = "MyPref";
    public static final String My_NAME = "nameKey";
    public static final String My_PHONE = "phoneKey";
    public static final String My_EMAIL = "emailKey";
    EditText personName, emailAddress, phoneNumber;
    Button saveButton, activity2;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personName = findViewById(R.id.personName);
        emailAddress = findViewById(R.id.emailAddress);
        phoneNumber = findViewById(R.id.phoneNumber);
        saveButton = findViewById(R.id.saveButton);
        activity2 = findViewById(R.id.activity2);
        sharedpreferences = getSharedPreferences(My_PREFERENCES, Context.MODE_PRIVATE);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myName = personName.getText().toString();
                String myEmail = emailAddress.getText().toString();
                String myNumber = phoneNumber.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(My_NAME, myName);
                editor.putString(My_PHONE, myNumber);
                editor.putString(My_EMAIL, myEmail);
                editor.apply();
                Toast.makeText(MainActivity.this, "Thanks", Toast.LENGTH_LONG).show();
            }
        });

        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}