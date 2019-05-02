package com.cimbhack.cimb.cogsci;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Phase3Test extends AppCompatActivity {

    String[] answer = {"cup-DESK", "car-PORT", "apple-PEN", "cloak-DANGER",
            "pots-PANS", "cream-SUGAR", "salt-PEPPER" , "shoes-SOCKS",
            "knife-FORK","law-ORDER","kerb-CRAB","cash-CACHE",
            "down-OUT" , "last-SECOND" , "cheap-CHIP" ,"birds-BUTTERFLY",
            "bacon-EGGS" , "water-SOAP" , "wine-CHEESE" , "rhyme-REASON",
            "thin-THICK", "roll-WRAP" , "profit-LOSS" , "cup-SAUCER",
            "bread-BUTTER" ,"rock-LOCK" , "cloth-SHIRT", "chocolate-COINS",
            "tower-MIRROR" , "wire-STRING", "toilet-BED" , "switch-BUTTON",
            "book-PAPER" , "mouse-CUTE" , "broom-MAP" , "fan-BEG",
            "cold-NIGHT", "plug-CABLE" , "pencil-CLOCK" , "bean-BIN",
            "hills-ROAD" , "chain-KEY" , "buns-CARROT" , "sweet-CANS"
    };
    TextView textView ;
    Button btnYes , btnNo , finishAttempt;
    int i = 0;
    int correct=0;
    double score = 0;
    String keys;
    ArrayList<String> check ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.phase_3_test);

        textView = (TextView) findViewById(R.id.questions3);
        btnYes = (Button) findViewById(R.id.yes);
        btnNo = (Button) findViewById(R.id.no);
        finishAttempt = (Button) findViewById(R.id.finish3);

        finishAttempt.setVisibility(View.INVISIBLE);
        textView.setText(answer[i]);

        Bundle bundle = getIntent().getExtras();
        if(null!=bundle){
            ArrayList<String> arrayList = bundle.getStringArrayList("array_list");
            check = (ArrayList<String>) arrayList.clone();
            keys = bundle.getString("key");
            Log.i("List" , "Passed Array List ::"+check);
            Log.i("Keys" , "Matric No ::"+keys);
        }
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(answer[i].equals(check.get(i))){
                    correct++;
                    Log.d("Correct" , "Number of correct questions"+correct);
                    Log.d("Score", "Percentage : "+evaluateScore(correct)+"%");

                }
                i++;
                if (i != answer.length) {
                    textView.setText(answer[i]);
                }
                else{
                    textView.setText("Finish");
                    btnYes.setVisibility(View.INVISIBLE);
                    btnNo.setVisibility(View.INVISIBLE);
                    finishAttempt.setVisibility(View.VISIBLE);
                    finishAttempt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Phase3Test.this,ResultActivity.class);
                            intent.putExtra("Score",evaluateScore(correct));
                            intent.putExtra("key",keys);
                            startActivity(intent);
                        }
                    });
                }



            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answer[i].equals(check.get(i))) {
                    correct++;
                    Log.d("Correct", "Number of correct questions" + correct);
                    Log.d("Score", "Percentage : "+evaluateScore(correct)+"%");
                }
                i++;
                if (i != answer.length) {
                    textView.setText(answer[i]);
                }
                else{
                    textView.setText("Finish");
                    btnYes.setVisibility(View.INVISIBLE);
                    btnNo.setVisibility(View.INVISIBLE);
                    finishAttempt.setVisibility(View.VISIBLE);
                    finishAttempt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Phase3Test.this,ResultActivity.class);
                            intent.putExtra("Score",evaluateScore(correct));
                            intent.putExtra("key",keys);
                            startActivity(intent);
                        }
                    });
                }

            }
        });

    }

    protected double evaluateScore(double correct) {
        score = (correct/answer.length)*100;
        Log.d("abc","abc"+correct);
        return score;
    }


}

