package com.example.languagetut.cadastro;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DAO {
    private ConexaoDB conexaoDB;
    private SQLiteDatabase db;
    //User
    private String name = "name";
    private String age = "age";
    private String level = "level";
    private String tableUser = "user";
    //Question
    private String levelRequired = "level_required";
    private String questionText = "question_text";
    private String tableQuestion = "question";

    public DAO(){
    }

    public void setConexaoDB(ConexaoDB con){
        conexaoDB = con;
        db = conexaoDB.getWritableDatabase();
    }

    public long insertUser(User user){
        ContentValues contentValues = new ContentValues();
        contentValues.put(name, user.getName());
        contentValues.put(age, user.getAge());
        contentValues.put(level, user.getLevel());
        return db.insert(tableUser, null, contentValues);
    }

    public long insertQuestion(Question question){
        ContentValues contentValues = new ContentValues();
        contentValues.put(levelRequired, question.getLevel_required());
        contentValues.put(questionText, question.getQuestion_text());
        return db.insert(tableQuestion, null, contentValues);
    }

    public Question selectQuestion(int id){
        Question question = new Question();
        String query = "SELECT * FROM " + tableQuestion + " WHERE question_id="+id;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()){
            question.setLevel_required(cursor.getInt(1));
            question.setQuestion_text(cursor.getString(2));
        }
        return question;
    }

    public User selectUser(int id){
        User user = new User();
        String query = "SELECT * FROM " + tableUser + " WHERE user_id="+id;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext()){
            user.setName(cursor.getString(1));
            user.setAge(cursor.getInt(2));
            user.setLevel(cursor.getInt(3));
        }
        return user;
    }
}
