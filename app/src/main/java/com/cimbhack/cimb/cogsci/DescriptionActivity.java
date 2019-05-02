package com.cimbhack.cimb.cogsci;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {
    TextView description ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_activity);

        description = (TextView) findViewById(R.id.textView2);
        description.setMovementMethod(new ScrollingMovementMethod());
        String s= "Background\n\n" +
                "There has been much controversy over the issue of recovered memories. (For an excellent overview, see the book edited by Conway, 1997.) This is the apparent finding that people who enter psychotherapy suddenly recover memories of events that happened to them years ago, usually memories of sexual abuse. Schooler, Bendiksen, and Ambadar (1997) use the term discovered memories rather than recovered memories because the latter implies that the memories are of real events whereas the former is neutral on whether the memory is of a real event or not.\n\n" +
                "Phase 1\n"+"In Phase I, you will see a series of word pairs, such as cup-DESK. Each pair is shown for about 3 seconds. There are 44 pairs of words. Read the words silently to yourself.\n\n"+
                "Phase 2\n"+"In Phase II, you will be given a cued-recall test. You will be shown a cue and will be asked to recall the word that was presented with it. For example, you might see: cup-D--K. To respond, type in the two missing letters. If you can't remember the target, just type in any two letters.\n\n"+
                "Phase 3\n"+"In Phase III, you will be shown a cue and target pair again, but this time you will be asked if you recalled the target in Phase II. A Yes response means that you do remember recalling the target word in Phase II; a No response means that you do not remember recalling the target word in Phase II.\n\n"+
                "At the end of the experiment, you will be asked if you want to save your data to a set of global data. After you answer the question, a new Web page window will appear that includes a debriefing, your data, your group's data, and the global data.";
        SpannableString ss1=  new SpannableString(s);
        ss1.setSpan(new RelativeSizeSpan(2f), 0,10, 0); // set size
        ss1.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 10, 0);// set color

        description.setText(ss1);
    }
}
