package com.cimbhack.cimb.cogsci;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Phase1Test extends AppCompatActivity {
    String[] questions = {"cup-DESK", "car-PORT", "apple-PEN", "table-CHAIR",
                        "ship-MOTOR", "down-OUT", "down-OUT" , "rice-NOODLES",
                        };

    final android.os.Handler handler = new android.os.Handler();
    TextView display;
    Button ready;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phase_1_test);
        display = (TextView) findViewById(R.id.display);
        ready = (Button) findViewById(R.id.ready);

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
