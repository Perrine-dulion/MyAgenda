package com.example.myagenda.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    Context context;

    public DbHelper(Context context) {
        super(context, DbInfo.DB_NAME, null, DbInfo.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DbInfo.CategoryTable.REQUEST_CREATE);
        db.execSQL(DbInfo.TodoTaskTable.REQUEST_CREATE);


        db.execSQL(DbInfo.CategoryTable.REQUEST_ADD_INITIAL_DATA, new String[]{"Perso"});
        db.execSQL(DbInfo.CategoryTable.REQUEST_ADD_INITIAL_DATA, new String[]{"travail"});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DbInfo.CategoryTable.REQUEST_DROP);
        db.execSQL(DbInfo.TodoTaskTable.REQUEST_DROP);

        onCreate(db);
    }
}
