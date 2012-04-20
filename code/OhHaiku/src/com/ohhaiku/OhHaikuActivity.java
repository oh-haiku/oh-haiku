package com.ohhaiku;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OhHaikuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tw = new TextView(this);
        tw.setText("Hello world!");
        setContentView(tw);
    }
}