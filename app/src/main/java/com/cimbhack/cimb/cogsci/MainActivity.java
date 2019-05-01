package com.cimbhack.cimb.cogsci;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button btnBeginTest;
    EditText matricNo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBeginTest = (Button) findViewById(R.id.beginTest);
        matricNo = (EditText) findViewById(R.id.matricNo);
        btnBeginTest.setEnabled(true);
        matricNo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                processButtonByTextLength();
            }
        });

        btnBeginTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Phase1Test.class);
                intent.putExtra("key" , matricNo.getText().toString());
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
            btnBeginTest.setEnabled(true);
        }
    }




}
