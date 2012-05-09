package com.ohhaiku;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.ohhaiku.database.DatabaseHelper;
import com.ohhaiku.models.Poem;
import com.ohhaiku.views.PoemAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

/*
 * Activity that displays the user's saved Haikus (both finished and unfinished ones).
 */
public class BrowseSavedHaikusActivity extends OrmLiteBaseActivity<DatabaseHelper> {
	private ListView lv;
	private List<Poem> poems;
	
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.browse);
    lv = (ListView) findViewById(R.id.listView);
    fetchPoems();
    lv.setOnItemClickListener(new OnItemClickListener() {

      public void onItemClick(AdapterView<?> parent, View view, int position, 
          long id) {
        Poem thePoem = poems.get(position);
        Intent intent = new Intent(getBaseContext(), HaikuCompositionActivity.class);
        intent.putExtra("POEM_ID", thePoem.getId());
        startActivity(intent);
      }
      
    });
  }

  private void fetchPoems() {
    try {
      Dao<Poem, Integer> poemDao = getHelper().getPoemDao();
      poems = poemDao.queryForAll();
      ListAdapter adapter = new PoemAdapter(this, R.layout.poem, poems);
      lv.setAdapter(adapter);
    } catch (SQLException e) {
      throw new RuntimeException("Could not get Haikus");
    }
  }
}
