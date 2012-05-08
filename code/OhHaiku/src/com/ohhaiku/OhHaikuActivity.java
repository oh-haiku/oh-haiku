package com.ohhaiku;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.Dao;
import com.ohhaiku.database.DatabaseHelper;
import com.ohhaiku.models.Poem;

import android.os.Bundle;
import android.util.Log;

/*
 * Main activity: shows the Haiku composition window.
 */

public class OhHaikuActivity extends OrmLiteBaseActivity<DatabaseHelper> {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	doDatabaseStuff();
      setContentView(R.layout.main);
    }
    
    private void doDatabaseStuff(){
      try {
        Dao<Poem, Integer> dao = getHelper().getPoemDao();
        Poem p = new Poem();
        p.setLine(0, "apa");
        p.setLine(1, "bepa");
        p.setLine(2, "Cepa");
        dao.create(p);
        Log.i(this.getClass().toString(), "P has id: " + p.getId());
        Poem p2 = new Poem(new String[] {"fepa", "gepa", "hepa"});
        dao.create(p2);
        List<Poem> poems = dao.queryForAll();
        for (Poem apoem : poems) {
          Log.i(this.getClass().toString(), "Poem is: " + apoem.toString());
        }
      } catch (SQLException e) {
        Log.e(DatabaseHelper.class.getName(), "Can't get DAO", e);
      }
    }
}