package com.ohhaiku;

import java.sql.SQLException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.ohhaiku.database.DatabaseHelper;
import com.ohhaiku.models.Haiku;
import com.ohhaiku.models.Poem;
import com.ohhaiku.Constants;

/*
 * Main activity: shows the Haiku composition window.
 */


public class HaikuCompositionActivity extends OrmLiteBaseActivity<DatabaseHelper> {
  private static final String logTag = "HaikuComposition";
  private static final int DEFAULT_VALUE = -1;

  /** Called when the activity is first created. */	
	@Override
  public void onCreate(Bundle savedInstanceState) {
  	super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }

  public void goToMenu(View view) {
    startActivityForResult(new Intent(this, MenuActivity.class), Constants.LOAD_HAIKU);
	}
  
  public void onCheck(View view) {
    Poem p = new Poem(getLines());
    Haiku h = new Haiku(p);
    boolean valid = h.isValid();
    if (valid) {
      setStatus(getString(R.string.certified_text));
    } else {
      setStatus(getString(R.string.not_certified_haiku_text));
    }
  }
  
  public String[] getLines() {
    TextView[] views = new TextView[3];
    
    // Fetch textviews containing the poem lines
    views[0] = (TextView) this.findViewById(R.id.editTextRow1);
    views[1] = (TextView) this.findViewById(R.id.editTextRow2);
    views[2] = (TextView) this.findViewById(R.id.editTextRow3);
    
    String[] lines = new String[3];
    
    for(int i = 0; i < 3; i++) {
      lines[i] = views[i].getText().toString();
    }
    
    return lines;
  }
	
	// Click handlers
	public void saveHaiku(View view) {
	  Poem p = new Poem(getLines());
	  
	  // Try to persist poem
	  try {
	    Dao<Poem, Integer> poemPersister = getHelper().getPoemDao();
      poemPersister.create(p);
      setStatus(getString(R.string.save_succeeded_text));
    } catch (SQLException e) {
      Log.e(logTag, "Could not save Haiku", e);
      setStatus(getString(R.string.save_failed_text));
    } 
	}

  private void setStatus(String status) {
    TextView statusView = (TextView) this.findViewById(R.id.statusText);
    statusView.setText(status);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == Activity.RESULT_OK && requestCode == Constants.LOAD_HAIKU) {
      int id = data.getIntExtra(Constants.HAIKU_ID, DEFAULT_VALUE);
      if (id != DEFAULT_VALUE) {
        loadHaiku(id);
      } else {
        setStatus(getString(R.string.haiku_load_failed_text));
      }
    }
  }

  private void loadHaiku(int id) {
    // TODO Auto-generated method stub
    
  }
}//HaikuCompositionActivity
