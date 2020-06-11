package com.example.languagetut.cadastro;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {

    private static int user_id;
    private String name;
    private int age;
    private int level;

    public static int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        User.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
