package com.ohhaiku;

import android.app.Activity;
import android.os.Bundle;

/*
 * Main activity: shows the Haiku composition window.
 */

public class OhHaikuActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}