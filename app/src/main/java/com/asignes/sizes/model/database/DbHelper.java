package com.asignes.sizes.model.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

  public DbHelper(Context context) {
    super(context, DbConstants.DB_NAME, null, DbConstants.DB_VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    if (db.isReadOnly()) {
      db = getWritableDatabase();
    }
    db.execSQL(DbConstants.Movies.CREATE_SQL);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  }
}
