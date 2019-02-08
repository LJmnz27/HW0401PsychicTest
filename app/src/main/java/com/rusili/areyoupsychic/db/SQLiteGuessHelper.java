package com.rusili.areyoupsychic.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.rusili.areyoupsychic.db.model.Guess;

import java.util.ArrayList;
import java.util.List;

public class SQLiteGuessHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "psychic.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Guess";

    public SQLiteGuessHelper(@NonNull Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "user TEXT, correct INTEGER);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {
        // No-op
    }

    public long saveGuess(@NonNull Guess guess) {
        final SQLiteDatabase database = this.getWritableDatabase();

        final ContentValues values = new ContentValues();
        values.put(Guess.USER_KEY, guess.getUser());
        values.put(Guess.CORRECT_KEY, guess.isCorrect());

        final long id = database.insert(SQLiteGuessHelper.TABLE_NAME, null, values);
        database.close();

        return id;
    }

    @NonNull
    public List<Guess> getAllGuesses() {
        final List<Guess> guessList = new ArrayList<>();

        final Cursor cursor = this.getReadableDatabase().rawQuery(
                "SELECT * FROM " + SQLiteGuessHelper.TABLE_NAME + ";", null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    final String user = cursor.getString(cursor.getColumnIndex(Guess.USER_KEY));
                    final int correctInt = cursor.getInt(cursor.getColumnIndex(Guess.CORRECT_KEY));
                    final boolean correct = (correctInt == 1);

                    final Guess guess = new Guess(user, correct);
                    guessList.add(guess);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }

        return guessList;
    }
}
