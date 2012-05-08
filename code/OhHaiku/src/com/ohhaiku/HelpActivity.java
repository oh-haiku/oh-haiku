package com.ohhaiku;

import android.app.Activity;
import android.os.Bundle;

/*
 * Activity that shows help and FAQ
 */

public class HelpActivity extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.help);
	 }
}
