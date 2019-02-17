package com.example.otimdibossman.myjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mpassword;
    Button mlogin_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpassword = (EditText) findViewById(R.id.password_edittext);
        mlogin_button = (Button) findViewById(R.id.login_button);
        mlogin_button.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if (view == mlogin_button) {
            try {
                Intent seeNotes = new Intent(getApplicationContext(), notesActivity.class);
                startActivity(seeNotes);
            } catch (Exception e) {
                Log.e("MainActivity::seeNotes", e.getMessage());
            }
        }
    }
}