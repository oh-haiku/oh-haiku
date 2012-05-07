package com.ohhaiku.database;

import java.sql.SQLException;

import android.R;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.ohhaiku.models.Poem;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
  private static final String DATABASE_NAME = "ohhaiku.db";
  private static final int DATABASE_VERSION = 1;
  
  private Dao<Poem, Integer> poemDao;
  
  public DatabaseHelper(Context context)
  {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }
  
  @Override
  public void onCreate(SQLiteDatabase db, ConnectionSource src) {
    try {
      TableUtils.createTable(src, Poem.class);
    } catch (SQLException e) {
      Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
      throw new RuntimeException(e);
    }
  }
  
  /**
   * Triggered upon upgrade.
   * WARNING: drops all tables if the new DATABASE_VERSION does not match the old
   */
  @Override
  public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion,
      int newVersion) {
    try {
      Log.i(DatabaseHelper.class.getName(), "onUpgrade");
      TableUtils.dropTable(connectionSource, Poem.class, true);
      // after we drop the old tables, we create the new ones
      onCreate(db, connectionSource);
    } catch (SQLException e) {
      Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
      throw new RuntimeException(e);
    }
  }
  
  /**
   * @return A DAO-object which can be used to persist Poems
   * @throws SQLException
   */
  public Dao<Poem, Integer> getPoemDao() throws SQLException {
    if (poemDao == null)
      poemDao = getDao(Poem.class);
    return poemDao;
  }
  
  /**
   * Close the database connections and clear any cached DAOs.
   */
  @Override
  public void close() {
    super.close();
    poemDao = null;
  }

}
