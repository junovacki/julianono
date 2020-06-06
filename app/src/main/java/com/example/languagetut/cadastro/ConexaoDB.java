package com.example.languagetut.cadastro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexaoDB extends SQLiteOpenHelper {
    private static final String name = "langtutor.db";
    private static final int version = 1;

    public ConexaoDB(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE question (" +
                "  question_id integer primary key autoincrement," +
                "  level_required integer," +
                "  question_text varchar(300)" +
                ")");
        db.execSQL("CREATE TABLE user (" +
                "  user_id integer primary key autoincrement," +
                "  name varchar(50)," +
                "  age integer," +
                "  level integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
