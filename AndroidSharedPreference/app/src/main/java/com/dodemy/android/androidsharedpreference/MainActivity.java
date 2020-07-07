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
    public static final String My_PREFERENCES_FILE = "MyPrefName";
    public static final String My_NAME = "nameKey";
    public static final String My_PHONE = "phoneKey";
    public static final String My_EMAIL = "emailKey";
    EditText personName, emailAddress, phoneNumber;
    Button saveButton, activity2;
    SharedPreferences sharedPreferencesFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personName = findViewById(R.id.personName);
        emailAddress = findViewById(R.id.emailAddress);
        phoneNumber = findViewById(R.id.phoneNumber);
        saveButton = findViewById(R.id.saveButton);
        activity2 = findViewById(R.id.activity2);
        keepFieldsIntact();
        saveIntoMyPreferenceFile();
        secondActivity();
    }

    public void secondActivity() {
        activity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }

    public void saveIntoMyPreferenceFile() {
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myName = personName.getText().toString();
                String myEmail = emailAddress.getText().toString();
                String myNumber = phoneNumber.getText().toString();

                SharedPreferences.Editor editor = sharedPreferencesFile.edit();
                editor.putString(My_NAME, myName);
                editor.putString(My_PHONE, myNumber);
                editor.putString(My_EMAIL, myEmail);
                editor.apply();
                Toast.makeText(MainActivity.this, "Saved! Thanks", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void keepFieldsIntact() {
        sharedPreferencesFile = getSharedPreferences(My_PREFERENCES_FILE, Context.MODE_PRIVATE);
        if (sharedPreferencesFile.contains(My_NAME)) {
            personName.setText(sharedPreferencesFile.getString(My_NAME, ""));
        }
        if (sharedPreferencesFile.contains(My_PHONE)) {
            phoneNumber.setText(sharedPreferencesFile.getString(My_PHONE, ""));
        }
        if (sharedPreferencesFile.contains(My_EMAIL)) {
            emailAddress.setText(sharedPreferencesFile.getString(My_EMAIL, ""));
        }
        Toast.makeText(MainActivity.this, "Hurrah, your fields are intact!", Toast.LENGTH_SHORT).show();
    }
}