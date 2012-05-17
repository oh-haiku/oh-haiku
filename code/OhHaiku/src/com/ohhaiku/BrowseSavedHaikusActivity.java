package com.ohhaiku;

import java.sql.SQLException;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.ohhaiku.database.DatabaseHelper;
import com.ohhaiku.models.Poem;
import com.ohhaiku.utility.Constants;
import com.ohhaiku.views.PoemAdapter;

/*
 * Activity that displays the user's saved Haikus (both finished and unfinished ones).
 */
public class BrowseSavedHaikusActivity extends OrmLiteBaseActivity<DatabaseHelper> {
	private ListView lv;
	private List<Poem> poems;
  private ListAdapter adapter;
	
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.browse);
    lv = (ListView) findViewById(R.id.listView);
    fetchPoems();
    setUpClickListeners();
  }

  private void setUpClickListeners() {
    lv.setOnItemClickListener(new OnItemClickListener() {

      public void onItemClick(AdapterView<?> parent, View view, int position, 
          long id) {
        Poem thePoem = poems.get(position);
        Intent intent = new Intent(getBaseContext(), HaikuCompositionActivity.class);
        intent.putExtra(Constants.HAIKU_ID, thePoem.getId());
        setResult(Activity.RESULT_OK, intent);
        finish();
      }
      
    });
    
    lv.setOnItemLongClickListener(new OnItemLongClickListener() {

      public boolean onItemLongClick(AdapterView<?> parent, View view, int position,
          long id) {
        BrowseSavedHaikusActivity activity = BrowseSavedHaikusActivity.this;
        final Poem p = (Poem) parent.getItemAtPosition(position);
        Builder b = new Builder(activity);
        b.setTitle("Delete a Haiku");
        b.setMessage("Would you like to delete the following Haiku?\n" + p.toString());
        b.setPositiveButton("Delete", new OnClickListener() {

          public void onClick(DialogInterface dialog, int which) {
            deletePoem(p);
          }});
        b.setNegativeButton("Cancel", new OnClickListener() {

          public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
          
        });
        AlertDialog ad = b.create();
        ad.show();
        return true;
      }
      
    });
  }

  private void deletePoem(Poem p) {
    Dao<Poem, Integer> dao;
    try {
      dao = getHelper().getPoemDao();
      dao.delete(p);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    fetchPoems();
  }
  
  private void fetchPoems() {
    try {
      Dao<Poem, Integer> poemDao = getHelper().getPoemDao();
      poems = poemDao.queryForAll();
      adapter = new PoemAdapter(this, R.layout.poem, poems);
      lv.setAdapter(adapter);
    } catch (SQLException e) {
      throw new RuntimeException("Could not get Haikus");
    }
  }
}
