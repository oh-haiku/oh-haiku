package com.ohhaiku;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
 * Activity that shows the main menu
 */

public class MenuActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
	}
	
	public void goToSavedHaikus(View view) {
	  startActivity(new Intent(this, BrowseSavedHaikusActivity.class));
	}
	
	public void goToHelp(View view) {
	  startActivity(new Intent(this, HelpActivity.class));
	}
	
	public void goToFAQ(View view) {
	  // TODO: write gotoFAQ method
	}
	
	public void loginToTwitter(View view) {
	  // TODO write login to twitter method
	}
}
