package com.example.languagetut.cadastro;

import java.io.Serializable;

public class Question implements Serializable {
    private int question_id;
    private int level_required;
    private String question_text;

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getLevel_required() {
        return level_required;
    }

    public void setLevel_required(int level_required) {
        this.level_required = level_required;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }
}
