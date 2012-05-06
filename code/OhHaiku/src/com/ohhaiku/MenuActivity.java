package com.ohhaiku;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/*
 * Activity that shows the main menu
 */

public class MenuActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    TextView tw = new TextView(this);
	    tw.setText("Menu");
	    setContentView(tw);
	}
}
