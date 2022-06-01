package com.example.bookreserver;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyBooks extends AppCompatActivity {

    ArrayList<Books> bookList = new ArrayList<>();
    RecyclerView recyclerView;
    MyBooksRV myBooksRV;
    SQLiteDatabase library;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        library = getBaseContext().openOrCreateDatabase("library.db", MODE_PRIVATE, null);
        library.execSQL("CREATE TABLE IF NOT EXISTS mybooks(_id INTEGER, title TEXT, author TEXT, numpass TEXT, deadline TEXT)");
        setContentView(R.layout.mybookslist);
        recyclerView = findViewById(R.id.list_viewmy);
        myBooksRV = new MyBooksRV(bookList, this);
        recyclerView.setAdapter(myBooksRV);
        Intent intent = getIntent();
        String dolche = intent.getStringExtra(NewDetails.EXTRA_MESSAGE123);
        library.execSQL("SELECT deadline FROM mybooks WHERE title = '" + dolche+"'");
        selectBook();


    }

    private void selectBook() {
        bookList.clear();
        Cursor query = library.rawQuery("SELECT * FROM mybooks ;", null);
        if (query.moveToFirst()) {
            do {
                String title = query.getString(1);
                String author = query.getString(2);
                String deadline = query.getString(4);
                bookList.add(new Books(title, author, deadline));
            } while (query.moveToNext());
        }
    }


}
