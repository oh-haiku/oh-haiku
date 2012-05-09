package com.ohhaiku;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.ohhaiku.database.DatabaseHelper;
import com.ohhaiku.models.Poem;
import com.ohhaiku.views.PoemAdapter;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

/*
 * Activity that displays the user's saved Haikus (both finished and unfinished ones).
 */
public class BrowseSavedHaikusActivity extends OrmLiteBaseActivity<DatabaseHelper> {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.browse);
      setUpListView();
    }

    private void setUpListView() {
      try {
        Dao<Poem, Integer> poemDao = getHelper().getPoemDao();
        List<Poem> poems = poemDao.queryForAll();
        ListAdapter adapter = new PoemAdapter(this, R.layout.poem, poems);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
      } catch (SQLException e) {
        throw new RuntimeException("Could not get Haikus");
      }
    }
}
