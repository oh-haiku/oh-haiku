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
	  startActivityForResult(new Intent(this, BrowseSavedHaikusActivity.class), Constants.LOAD_HAIKU);
	}
	
	public void goToHelp(View view) {
	  startActivity(new Intent(this, HelpActivity.class));
	}
	
	public void goToFAQ(View view) {
	  // TODO
	}
	
	public void loginToTwitter(View view) {
	  startActivity(new Intent(this, BrowseSavedHaikusActivity.class));
	}

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == Activity.RESULT_OK && requestCode == Constants.LOAD_HAIKU) {
      setResult(Activity.RESULT_OK, data);
      finish();
    }
  }
}
