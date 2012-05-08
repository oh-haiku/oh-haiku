package com.ohhaiku;

import android.app.Activity;
import android.os.Bundle;

/*
 * Activity that allows the user to tweet a Haiku.
 */


public class TweetAHaikuActivity extends Activity{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.logintwitter);
	 }
}
