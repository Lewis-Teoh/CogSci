package com.cimbhack.cimb.cogsci;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ResultActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    double result =0;
    String s="";
    String keys;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        Button btnResult = (Button) findViewById(R.id.viewResult);
        final Button viewGlobalResult = (Button) findViewById(R.id.globalResult);
        final TextView txtResult = (TextView) findViewById(R.id.result);
        final TextView txtGrats = (TextView) findViewById(R.id.congratz);

        txtResult.setVisibility(View.INVISIBLE);
        txtGrats.setVisibility(View.INVISIBLE);
        txtGrats.setText("Congratulations!");
        viewGlobalResult.setEnabled(false);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            result = bundle.getDouble("Score");
            result = (double) Math.round(result*100d)/100d;
            s = String.valueOf(result);

            keys = bundle.getString("key");
        }
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtGrats.setVisibility(View.VISIBLE);
                txtResult.setVisibility(View.VISIBLE);
                txtResult.setText(s +"%");
                viewGlobalResult.setEnabled(true);

                myRef= database.getReference("Participants");
                myRef.setValue(keys+"                "+s+"%");

                viewGlobalResult.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ResultActivity.this,GlobalResult.class);
//                        intent.putExtra("key",keys);
//                        intent.putExtra("Percentage",s+"%");
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
