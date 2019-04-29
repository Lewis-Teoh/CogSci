package com.cimbhack.cimb.cogsci;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Phase3Test extends AppCompatActivity {

    String[] answer = {"cup-DESK", "car-PORT", "apple-PEN", "table-CHAIR",
            "ship-MOTOR", "down-OUT" , "rice-NOODLES",
    };
    TextView textView ;
    Button btnYes , btnNo;
    int i = 0;
    int correct=0;
    ArrayList<String> check ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.phase_3_test);

        textView = (TextView) findViewById(R.id.questions3);
        btnYes = (Button) findViewById(R.id.yes);
        btnNo = (Button) findViewById(R.id.no);

        textView.setText(answer[i]);

        Bundle bundle = getIntent().getExtras();
        if(null!=bundle){
            ArrayList<String> arrayList = bundle.getStringArrayList("array_list");
            check = (ArrayList<String>) arrayList.clone();
            Log.i("List" , "Passed Array List ::"+check);
        }
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer[i].equals(check.get(i))){
                    correct++;
                    Log.d("Correct" , "Number of correct questions"+correct);
                }
                i++;
                textView.setText(answer[i]);
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answer[i].equals(check.get(i))) {
                    correct++;
                    Log.d("Correct", "Number of correct questions" + correct);
                }
                i++;
                textView.setText(answer[i]);
            }
        });
    }


}
