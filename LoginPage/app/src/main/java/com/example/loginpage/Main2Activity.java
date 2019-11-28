package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    EditText etcad, etrate;
    Button con,clr;
    Spinner sp;
    double result;
    double[] rates = {0.75, 1.11, 53.91, 0.68, 0.58};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        List<String> Currencies = new ArrayList<String>();
        Currencies.add("USD");
        Currencies.add("AUS");
        Currencies.add("INR");
        Currencies.add("EURO");
        Currencies.add("POUND");

        sp = findViewById(R.id.sp1);
        etcad = findViewById(R.id.etCad);
        con = findViewById(R.id.conBtn);
        clr = findViewById(R.id.clrBtn);
        EditText etrate = findViewById(R.id.etRates);

        ArrayAdapter<String> curAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, Currencies);
        curAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        sp.setAdapter(curAdapter);
        sp.setOnItemSelectedListener(this);



        //setting action to the convet button
        con.setOnClickListener(this);
        clr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.conBtn:
                    Double Amt = new Double(result);
                    etrate.setText(Amt.toString());
                    result = 0 ;
                     break;

            case R.id.clrBtn:
                etcad.setText("");
                etrate.setText("");

        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


         etrate = findViewById(R.id.etRates);
        //etrate.setText(Rates.get(position).toString());


        if (etcad.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "Please enter the amount in CAD...!", Toast.LENGTH_LONG).show();
        }
        else {

            double cad = Double.parseDouble(etcad.getText().toString());
            double amt = cad * rates[position];
            result = amt;

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}