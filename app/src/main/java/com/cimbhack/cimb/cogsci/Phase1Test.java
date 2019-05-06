package com.cimbhack.cimb.cogsci;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Phase1Test extends AppCompatActivity {
    String[] questions ={"cup-DESK", "car-PORT", "apple-PEN", "cloak-DANGER",
            "pots-PANS", "cream-SUGAR", "salt-PEPPER" , "shoes-SOCKS",
            "knife-FORK","law-ORDER","kerb-CRAB","cash-CACHE",
            "down-OUT" , "last-SECOND" , "cheap-CHIP" ,"birds-BUTTERFLY",
            "bacon-EGGS" , "water-SOAP" , "wine-CHEESE" , "rhyme-REASON",

    };

    final android.os.Handler handler = new android.os.Handler();
    TextView display;
    Button ready;
    String keys;
    String sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phase_1_test);
        display = (TextView) findViewById(R.id.display);
        ready = (Button) findViewById(R.id.ready);

        Bundle bundle= getIntent().getExtras();
        if(bundle!=null){
            keys = bundle.getString("key");
            sex = bundle.getString("sex");
            Log.i("Keys" , "Matric No ::"+keys);
        }
        handler.post(new Runnable() {

            int i =0;
            public void run() {
                ready.setVisibility(View.INVISIBLE);
                display.setText(questions[i]);
                i++;
                if (i == questions.length) {
                    handler.removeCallbacks(this);
                    ready.getHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            handler.postDelayed(this, 1000*3);
                            ready.setVisibility(View.VISIBLE);
                            ready.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    Intent intent = new Intent(Phase1Test.this,Phase2Test.class);
                                    intent.putExtra("key",keys);
                                    intent.putExtra("sex",sex);
                                    startActivity(intent);
                                }
                            });
                        }
                    });

                } else {
                    //5 sec
                    handler.postDelayed(this, 1000 * 3);
                }
            }
        });

    }

}
