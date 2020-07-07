package com.dodemy.android.androidsharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Android stores Shared Preferences settings as XML file in shared_prefs folder under DATA/data/{application package} directory.
 * The DATA folder can be obtained by calling Environment.getDataDirectory()
 */
public class MainActivity2 extends AppCompatActivity {
    //PREFERENCE_FILE_NAME is the name of the file where the shared preferences key-value pair is stored.
    public static final String PREFERENCE_FILE_NAME = "myPrefName";
    public static final String NAME_KEY = "nameKey";
    public static final String EMAIL_KEY = "emailKey";
    SharedPreferences mSharedPreferences;
    EditText mName, mEmail;
    Button mHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mName = findViewById(R.id.etName);
        mEmail = findViewById(R.id.etEmail);
        mHome = findViewById(R.id.home);
        keepFieldsIntact();
        homeActivity();
    }

    public void Save(View view) {
        String myName = mName.getText().toString();
        String myEmail = mEmail.getText().toString();
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(NAME_KEY, myName);
        editor.putString(EMAIL_KEY, myEmail);
        editor.apply();
        Toast.makeText(MainActivity2.this, "Your details are save!", Toast.LENGTH_LONG).show();
    }

    public void clear(View view) {
        mName = findViewById(R.id.etName);
        mEmail = findViewById(R.id.etEmail);
        mName.setText("");
        mEmail.setText("");
        Toast.makeText(MainActivity2.this, "The fields are cleared!", Toast.LENGTH_LONG).show();
    }

    public void Get(View view) {
        mName = findViewById(R.id.etName);
        mEmail = findViewById(R.id.etEmail);
        mSharedPreferences = getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        if (mSharedPreferences.contains(NAME_KEY)) {
            mName.setText(mSharedPreferences.getString(NAME_KEY, ""));
        }
        if (mSharedPreferences.contains(EMAIL_KEY)) {
            mEmail.setText(mSharedPreferences.getString(EMAIL_KEY, ""));
        }
        Toast.makeText(MainActivity2.this, "Your details are retrieved", Toast.LENGTH_LONG).show();
    }

    public void homeActivity() {
        mHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                MainActivity2.this.startActivity(intent);
            }
        });
        Toast.makeText(MainActivity2.this, "You are are about to go Home Screen", Toast.LENGTH_LONG).show();
    }

    public void keepFieldsIntact() {
        mSharedPreferences = getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        if (mSharedPreferences.contains(NAME_KEY)) {
            mName.setText(mSharedPreferences.getString(NAME_KEY, ""));
        }
        if (mSharedPreferences.contains(EMAIL_KEY)) {
            mEmail.setText(mSharedPreferences.getString(EMAIL_KEY, ""));
        }
        Toast.makeText(MainActivity2.this, "Hurrah, the fields are intact!", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}