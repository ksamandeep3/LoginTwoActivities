package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText etUsername,etPassword;
Button okbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.etus);
        etPassword = findViewById(R.id.etpas);
        okbtn = findViewById(R.id.okBtn);

         okbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        //if etUsername.getText().toString().equals("admin")
        String user = etUsername.getText().toString();
        String pass = etPassword.getText().toString();
        if(user.equals("admin") && pass.equals("Pa55word"))
        {
            //making intent, intent is a transition between two activities
            Intent act = new Intent(getApplicationContext(),Main2Activity.class);
            //starting an intent
            startActivity(act);
        }
        else
           Toast.makeText(getApplicationContext(),"Invalid username and password", Toast.LENGTH_SHORT).show();
    }
}
