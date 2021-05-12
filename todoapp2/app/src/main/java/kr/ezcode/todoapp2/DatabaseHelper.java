package kr.ezcode.todoapp2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "kr.ezcode.todoapp2.db";
    final static int DB_VER = 1;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE tasks (" +
                " id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " title TEXT NOT NULL," +
                " checked INTEGER NOT NULL)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < newVersion) {
            db.execSQL("DROP TABLE tasks");
            onCreate(db);
        }
    }
}
