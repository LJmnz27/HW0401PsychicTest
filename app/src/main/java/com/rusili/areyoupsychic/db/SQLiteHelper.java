package com.rusili.areyoupsychic.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "psychic.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "guesses";

    public SQLiteHelper(@NonNull Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {

    }
}
