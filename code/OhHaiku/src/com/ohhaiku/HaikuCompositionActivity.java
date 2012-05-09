package com.ohhaiku;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
 * Main activity: shows the Haiku composition window.
 */


public class HaikuCompositionActivity extends Activity {
  /** Called when the activity is first created. */	
	@Override
  public void onCreate(Bundle savedInstanceState) {
  	super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }
	
	public void goToMenu(View view) {
    startActivity(new Intent(this, MenuActivity.class));
	}
}//HaikuCompositionActivity
