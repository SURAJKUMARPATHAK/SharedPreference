package com.my.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private static final String SHARED_PREF_NAME = "mysharedpref";
    private static final String NAME = "keyname";

    EditText editText;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextName);
        textView = findViewById(R.id.textView);

        findViewById(R.id.buttonSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveName();
                displayName();
            }
        });
    }

    private void saveName() {
        String name = editText.getText().toString();

        if (name.isEmpty()) {
            editText.setError("Name required");
            editText.requestFocus();
            return;
        }

        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString(NAME, name);

        editor.apply();

        editText.setText("");
    }

    private void displayName() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sp.getString(NAME, null);

        if (name != null) {
            textView.setText("Welcome " + name);
        }
    }

    //My Change 1

}