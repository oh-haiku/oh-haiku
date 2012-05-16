/**
 * @author Jesper Josefsson
 */

package com.ohhaiku;

import java.sql.SQLException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.ohhaiku.database.DatabaseHelper;
import com.ohhaiku.models.Haiku;
import com.ohhaiku.models.Poem;
import com.ohhaiku.utility.Constants;

/*
 * Main activity: shows the Haiku composition window.
 */
public class HaikuCompositionActivity extends OrmLiteBaseActivity<DatabaseHelper> {
  private static final String logTag = "HaikuComposition";
  private static final int DEFAULT_VALUE = -1;
  
  /*
   * This variable is only set with a persisted poem.
   * Used to enable updates of poems
   */
  private Poem poem;

  /** Called when the activity is first created. */	
	@Override
  public void onCreate(Bundle savedInstanceState) {
  	super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
  }

	/**
	 * Click handler for the menu button
	 * Starts the menu, possibly expecting a result in the form of Poem
	 */
  public void onGoToMenu(View view) {
    startActivityForResult(new Intent(this, MenuActivity.class), Constants.LOAD_HAIKU);
	}
  
  /**
   * Click handler for the Check Haiku button
   */
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
  
  /*
   * Returns three textViews corresponding to the three lines of the Haiku
   */
  private TextView[] getTextViews() {
    TextView[] views = new TextView[3];
    
    // Fetch textviews containing the poem lines
    views[0] = (TextView) this.findViewById(R.id.editTextRow1);
    views[1] = (TextView) this.findViewById(R.id.editTextRow2);
    views[2] = (TextView) this.findViewById(R.id.editTextRow3);
    
    return views;
  }
  
  /*
   * Returns an array of Strings, representing the three lines of the Haiku
   */
  private String[] getLines() {
    TextView[] views = getTextViews();
    
    String[] lines = new String[3];
    
    for(int i = 0; i < 3; i++) {
      lines[i] = views[i].getText().toString();
    }
    
    return lines;
  }
  
  /*
   * Sets the three lines of the Haiku
   */
  private void setLines(String[] lines) {
    TextView[] views = getTextViews();
    for (int i = 0; i < 3; i++) {
      views[i].setText(lines[i]);
    }
  }
	
  /*
   * Fetches the Haiku from the composition view and attempts to persist it.
   */
	private void saveHaiku() {
	  poem = new Poem(getLines());
	  
	  // Try to persist poem
	  try {
	    Dao<Poem, Integer> poemPersister = getHelper().getPoemDao();
      poemPersister.create(poem);
      setStatus(getString(R.string.save_succeeded_text));
    } catch (SQLException e) {
      Log.e(logTag, "Could not save Haiku", e);
      setStatus(getString(R.string.save_failed_text));
    } 
	}

	/*
	 * Sets the status text view.
	 */
  private void setStatus(String status) {
    TextView statusView = (TextView) this.findViewById(R.id.statusText);
    statusView.setText(status);
  }
  
  /*
   * Called when the Menu activity passes on a Haiku from the BrowseSavedHaikus Activity
   * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
   */
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
  
  /*
   * Fetches a haiku from the database by ID
   */
  private void loadHaiku(int id) {
    try {
      Dao<Poem, Integer> dao = getHelper().getPoemDao();
      Poem p = dao.queryForId(id);
      setPoem(p);
    } catch (SQLException e) {
      setStatus(getString(R.string.haiku_load_failed_text));
    }
  }
  
  /*
   * Sets the current poem.
   * This will set the instance variable and render the Haiku in the GUI
   */
  private void setPoem(Poem poem) {
    this.poem = poem;
    Log.i(logTag, poem.toString());
    setLines(poem.getLinesAsArray());
    setStatus(getString(R.string.haiku_loaded_text));
    setPersistButtonText(getString(R.string.update_button_title));
  }
  
  /**
   * Click handler for the clear button
   */
  public void onClear(View v) {
    poem = null;
    setLines(new String[] {"", "", ""});
    setPersistButtonText(getString(R.string.save_button_title));
    setStatus("");
  }

  /*
   * Sets the text of the persist button. Used toggle between "Update" and "Save"
   */
  private void setPersistButtonText(String text) {
    Button b = (Button) findViewById(R.id.PersistButton);
    if (b != null) {
      b.setText(text);
    }
  }
  
  /**
   * Click handler for the Save/Update button
   * Checks if the current haiku has been saved, if so - updates it. Otherwise, saves a new Haiku.
   */
  public void onPersist(View v) {
    if (poem == null) {
      saveHaiku();
    } else {
      updateHaiku();
    }
  }
  
  /*
   * Updates the current Haiku using the contents of the textViews.
   */
  private void updateHaiku() {
    poem.setLines(getLines());
    try {
      Dao<Poem, Integer> dao = getHelper().getPoemDao();
      dao.update(poem);
      setStatus(getString(R.string.updated_haiku_text));
    } catch (SQLException e) {
      setStatus(getString(R.string.update_failed_text));
    }
    
  }
}//HaikuCompositionActivity
