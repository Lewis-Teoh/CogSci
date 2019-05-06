package com.cimbhack.cimb.cogsci;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class Phase2Test extends AppCompatActivity {
    String[] questions = {"cup-D__K", "car-P__T", "apple-P_N", "cloak-DA___R",
            "pots-P__S", "cream-SU__R", "salt-P_P__R" , "shoes-S__KS",
            "knife-F__K","law-O_D_R","kerb-C__B","cash-CAC__",
            "down-O_T" , "last-S__O_D" , "cheap-C__P" ,"birds-BUTTE__LY",
            "bacon-E__S" , "water-S__P" , "wine-C__E_E" , "rhyme-RE_S_N",

    };
    String[] answer = {"cup-DESK", "car-PORT", "apple-PEN", "cloak-DANGER",
            "pots-PANS", "cream-SUGAR", "salt-PEPPER" , "shoes-SOCKS",
            "knife-FORK","law-ORDER","kerb-CRAB","cash-CACHE",
            "down-OUT" , "last-SECOND" , "cheap-CHIP" ,"birds-BUTTERFLY",
            "bacon-EGGS" , "water-SOAP" , "wine-CHEESE" , "rhyme-REASON",

    };
    ArrayList<String> arrayList = new ArrayList<String>();
    int arraylength = questions.length;
    final android.os.Handler handler = new android.os.Handler();
    TextView display;
    EditText input;
    Button submit , finish;
    String keys , sex;

    int i = 0;
    int correct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phase_2_test);
        display = (TextView) findViewById(R.id.questions3);
        input = (EditText) findViewById(R.id.answer);
        submit = (Button) findViewById(R.id.submit);
        finish = (Button) findViewById(R.id.finishPhase2);

        finish.setVisibility(View.INVISIBLE);
        display.setText(questions[0]);
        submit.setEnabled(false);

        Bundle bundle=getIntent().getExtras();
        if(null!=bundle){
            keys = bundle.getString("key");
            sex = bundle.getString("sex");
            Log.i("Keys" , "Matric No ::"+keys);
        }

        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(i!=arraylength) {
                    processButtonByTextLength(questions[i].length());
                }else{
                    submit.setVisibility(View.INVISIBLE);
                }
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });




        input.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int action = event.getAction();

                if(action==event.ACTION_UP){

                    processButtonByTextLength(questions[i].length());
                }
                return false;
            }
        });



    }
    private void processButtonByTextLength(int length)
    {
        String inputText = input.getText().toString();
        if(inputText.length() == length)
        {
            input.setOnKeyListener(new View.OnKeyListener()
            {
                public boolean onKey(View v, int keyCode, KeyEvent event)
                {
                    if (event.getAction() == KeyEvent.ACTION_DOWN)
                    {
                        switch (keyCode)
                        {
                            case KeyEvent.KEYCODE_DPAD_CENTER:
                            case KeyEvent.KEYCODE_ENTER:

                                        nextQuestion();

                                return true;
                            default:
                                break;
                        }
                    }
                    return false;
                }
            });
            submit.setEnabled(true);
        }else
        {
            submit.setEnabled(false);
        }
    }
    private void printArrayList(){
        for(int i = 0; i < arrayList.size(); i++) {
            Log.d("Array List : ","element "+arrayList.get(i));
        }
    }
    private void nextQuestion(){
        if (input.getText().length()!=0) {
            if(input.getText().toString().equals(answer[i])) {
                correct++;
                arrayList.add(input.getText().toString());
                Log.d("MyApp", "correct question" + correct);
            }
            else {
                arrayList.add(input.getText().toString());
            }
        }
        i++;
        if (i != arraylength) {
            display.setText(questions[i]);
        }
        else {
            printArrayList();
            display.setText("Finish");
            finish.setVisibility(View.VISIBLE);
            input.setVisibility(View.INVISIBLE);
            finish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Phase2Test.this, Phase3Test.class);
                    intent.putExtra("array_list", arrayList);
                    intent.putExtra("key",keys);
                    intent.putExtra("sex",sex);
                    startActivity(intent);
                }
            });
        }
        input.setText(null);
        Log.d("MyApp", "iteration " + i + "array" + arraylength);
    }
}
