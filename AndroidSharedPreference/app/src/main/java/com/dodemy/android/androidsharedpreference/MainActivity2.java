package com.dodemy.android.androidsharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    public static final String MY_PREFERENCE = "myPref";
    public static final String NAME_KEY = "nameKey";
    public static final String EMAIL_KEY = "emailKey";
    SharedPreferences mSharedPreferences;
    EditText mName;
    EditText mEmail;
    Button mHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mName = findViewById(R.id.etName);
        mEmail = findViewById(R.id.etEmail);
        mHome = findViewById(R.id.home);
        mSharedPreferences = getSharedPreferences(MY_PREFERENCE, Context.MODE_PRIVATE);
        if (mSharedPreferences.contains(NAME_KEY)) {
            mName.setText(mSharedPreferences.getString(NAME_KEY, ""));
        }
        if (mSharedPreferences.contains(EMAIL_KEY)) {
            mEmail.setText(mSharedPreferences.getString(EMAIL_KEY, ""));
        }

        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                MainActivity2.this.startActivity(intent);
            }
        });
    }
    public void Save(View view) {
        String myName = mName.getText().toString();
        String myEmail = mEmail.getText().toString();
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(NAME_KEY, myName);
        editor.putString(EMAIL_KEY, myEmail);
        editor.apply();
    }
    public void clear(View view) {
        mName = findViewById(R.id.etName);
        mEmail = findViewById(R.id.etEmail);
        mName.setText("");
        mEmail.setText("");
    }
    public void Get(View view) {
        mName =  findViewById(R.id.etName);
        mEmail = findViewById(R.id.etEmail);
        mSharedPreferences = getSharedPreferences(MY_PREFERENCE, Context.MODE_PRIVATE);
        if (mSharedPreferences.contains(NAME_KEY)) {
            mName.setText(mSharedPreferences.getString(NAME_KEY, ""));
        }
        if (mSharedPreferences.contains(EMAIL_KEY)) {
            mEmail.setText(mSharedPreferences.getString(EMAIL_KEY, ""));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}