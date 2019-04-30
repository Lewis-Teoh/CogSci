package com.cimbhack.cimb.cogsci;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    double result =0;
    String s="";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        Button btnResult = (Button) findViewById(R.id.viewResult);
        final TextView txtResult = (TextView) findViewById(R.id.result);
        final TextView txtGrats = (TextView) findViewById(R.id.congratz);

        txtResult.setVisibility(View.INVISIBLE);
        txtGrats.setVisibility(View.INVISIBLE);
        txtGrats.setText("Congratulations!");

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            result = bundle.getDouble("Score");
            result = (double) Math.round(result*100d)/100d;
            s = String.valueOf(result);
        }
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtGrats.setVisibility(View.VISIBLE);
                txtResult.setVisibility(View.VISIBLE);
                txtResult.setText(s +"%");
            }
        });
    }
}
