package com.example.bookreserver;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


public class Users {
private static long id;
    private static String name;
    private static String famile;
    private static String surname;
    private static String numpass;

    private static String birthday;

    public Users(long id, String name, String famile, String surname, String numpass, String birthday) {
        this.id = id;
        this.name = name;
        this.famile = famile;
        this.surname = surname;
        this.numpass = numpass;
        this.birthday = birthday;
    }
    public long getId() {
        return id;
    }

    public void setId(long _id) {
        this.id = id;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getFamile() {
        return famile;
    }

    public void setFamile(String famile) {
        this.famile = famile;
    }

    public static String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static String getNumpass() {
        return numpass;
    }

    public void setNumpass(String numpass) {
        this.numpass = numpass;
    }

    public static String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name+" : "+this.famile+" : "+this.surname+" : "+this.numpass+" : "+this.birthday;
    }
}
