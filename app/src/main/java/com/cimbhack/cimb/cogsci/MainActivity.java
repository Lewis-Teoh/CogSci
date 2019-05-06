package com.cimbhack.cimb.cogsci;

import android.content.Intent;
import android.support.design.widget.TabItem;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button btnBeginTest , btnDesc;
    EditText matricNo;
    TabItem tab;
    String matricNum, sex;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBeginTest = (Button) findViewById(R.id.beginTest);
        matricNo = (EditText) findViewById(R.id.matricNo);
        btnDesc = (Button) findViewById(R.id.description);
        spinner = (Spinner) findViewById(R.id.spinner1);


        btnBeginTest.setEnabled(false);
        matricNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                matricNum = matricNo.getText().toString();
                processButtonByTextLength();
            }
        });
        addListenerOnButton();

        btnBeginTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Phase1Test.class);
                intent.putExtra("key" , matricNum);
                intent.putExtra("sex",sex);
                startActivity(intent);
                matricNo.setText(null);
                spinner.setSelection(0);
            }
        });

        btnDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DescriptionActivity.class);
                startActivity(intent);
            }
        });
    }
    private void processButtonByTextLength()
    {
        String inputText = matricNo.getText().toString();
        if(inputText.length() == 9)
        {
            btnBeginTest.setEnabled(true);
        }else
        {
            btnBeginTest.setEnabled(false);
        }
    }
    public void addListenerOnButton() {

        spinner = (Spinner) findViewById(R.id.spinner1);


        btnBeginTest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                       sex = String.valueOf(spinner.getSelectedItem());
            }

        });
    }




}
