package com.ohhaiku;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/*
 * Activity that displays the user's saved Haikus (both finished and unfinished ones).
 */


public class BrowseSavedHaikusActivity extends Activity{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tw = new TextView(this);
        tw.setText("Saved Haikus");
        setContentView(tw);
    }
}
