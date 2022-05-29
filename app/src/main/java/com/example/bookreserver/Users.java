package com.example.bookreserver;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*@Entity(tableName = "users")*/
public class Users {

    /*@PrimaryKey
    @ColumnInfo(name = "_id")
    private long _id;*/

 /*   @ColumnInfo(name = "uname")*/
    private static String name;

   /* @ColumnInfo(name = "famile")*/
    private static String famile;

    /*@ColumnInfo(name = "surname")*/
    private static String surname;

   /* @ColumnInfo(name = "numpass")*/
    private static String numpass;

   /* @ColumnInfo(name = "birthday")*/
    private static String birthday;

    public Users(/*long _id,*/ String name, String famile, String surname, String numpass, String birthday) {
        //this._id = _id;
        this.name = name;
        this.famile = famile;
        this.surname = surname;
        this.numpass = numpass;
        this.birthday = birthday;
    }
/*    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }*/

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
}
