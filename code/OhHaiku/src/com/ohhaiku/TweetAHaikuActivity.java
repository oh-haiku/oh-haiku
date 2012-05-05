package com.ohhaiku;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/*
 * Activity that allows the user to tweet a Haiku.
 */


public class TweetAHaikuActivity extends Activity{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    TextView tw = new TextView(this);
	    tw.setText("Tweet a haiku");
	    setContentView(tw);
	 }
}
