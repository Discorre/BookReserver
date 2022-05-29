package com.example.bookreserver;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "library.db";
    private static final int SCHEMA = 1;
    public static final String TABLE = "users";

    public static final String COLUMN_ID = "id";
    private static final String COLUMN_NUMPASS = "numpass";
    private static final String COLUMN_BIRTHDAY = "birthday";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_FAMILE = "famile";
    private static final String COLUMN_SURNAME = "surname";

    public static final String COLUMN_BID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_AUTHOR = "author";
    private static final String COLUMN_RESERVER = "reserver";
    public static final String BTABLE = "books";
    public static final int BSHEMA = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase library) {
        library.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_FAMILE + " TEXT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_SURNAME + " TEXT, "
                + COLUMN_NUMPASS + " INTEGER, "
                + COLUMN_BIRTHDAY + " DATE );");
        library.execSQL("CREATE TABLE IF NOT EXISTS "+BTABLE +" ("
                +COLUMN_BID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COLUMN_TITLE+" TEXT ");
        library.execSQL("INSERT INTO " + TABLE + " ("
                + COLUMN_FAMILE + ", "
                + COLUMN_NAME + ", "
                + COLUMN_SURNAME + ", "
                + COLUMN_NUMPASS + ", "
                + COLUMN_BIRTHDAY + ") VALUES ('Михайлов','Егор','Сергеевич','8113000000','31.12.99' );");
    }

    public void onDelete(SQLiteDatabase library) {
        library.execSQL("DELETE FROM " + TABLE + ";");

    }

    @Override
    public void onUpgrade(SQLiteDatabase library, int i, int i1) {
        library.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(library);
    }

    public void insertUsers(Users users, SQLiteDatabase library) {
        library.execSQL("INSERT INTO " + TABLE
                + "(_id, name, famile, surname, numpass, birthday) VALUES('"
                + users.getName() + "', '"
                + users.getFamile() + "', '"
                + users.getSurname() + "', '"
                + users.getNumpass() + "', '"
                + users.getBirthday() + "');");
    }


}
