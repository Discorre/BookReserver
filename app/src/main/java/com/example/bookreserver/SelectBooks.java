package com.example.bookreserver;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelectBooks extends AppCompatActivity {
    ArrayList<Books> booksList = new ArrayList<>();
    RecyclerView recyclerView;
    public static final String EXTRA_MESSAGE = "com.example.bookreserver.NewDetails";
    BookAdapterRV bookAdapterRV;
    SQLiteDatabase library;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        library = getBaseContext().openOrCreateDatabase("library.db", MODE_PRIVATE, null);
        library.execSQL("CREATE TABLE IF NOT EXISTS books(_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, author TEXT, numpass TEXT)");
        setContentView(R.layout.booklist);
        recyclerView = findViewById(R.id.list_viewselect);
        BookAdapterRV.OnBookClickListener bookClickListener = new BookAdapterRV.OnBookClickListener() {
            @Override
            public void onBookClick(Books books, int position) {
                Intent intent = new Intent(SelectBooks.this, NewDetails.class);
                String dolche = books.getName();
                intent.putExtra(EXTRA_MESSAGE, dolche);
                startActivity(intent);
            }
        };
        bookAdapterRV = new BookAdapterRV(booksList, this, bookClickListener);
        recyclerView.setAdapter(bookAdapterRV);
        selectBook();
        if (bookAdapterRV.getItemCount() == 0) {
            initBooks();
        }
        selectBook();

    }

    private void initBooks() {
        booksList.clear();
        library.execSQL("INSERT INTO books(title, author, numpass) VALUES ('Капитанская дочка','А.С.Пушкин','');");
        library.execSQL("INSERT INTO books(title, author, numpass) VALUES ('Война и мир','Л.Н.Толстой','');");
        library.execSQL("INSERT INTO books(title, author, numpass) VALUES ('Челкаш','М.Горький','');");
        library.execSQL("INSERT INTO books(title, author, numpass) VALUES ('Человек в футляре','А.П.Чехов','');");
        library.execSQL("INSERT INTO books(title, author, numpass) VALUES ('Преступление и наказание','Ф.И.Достоевский','');");
        library.execSQL("INSERT INTO books(title, author, numpass) VALUES ('Ревизор','Н.В.Гоголь','');");
        library.execSQL("INSERT INTO books(title, author, numpass) VALUES ('Собачье сердце','М.Булгаков','');");
        library.execSQL("INSERT INTO books(title, author, numpass) VALUES ('Три товарища','Эрих Мария Ремарк','');");
        library.execSQL("INSERT INTO books(title, author, numpass) VALUES ('Мёртвые Души','Н.В.Гоголь','');");
        library.execSQL("INSERT INTO books(title, author, numpass) VALUES ('Евгений Онегин','А.С.Пушкин','');");
        library.execSQL("INSERT INTO books(title, author, numpass) VALUES ('Тихий Дон','М.А.Шолохов','');");
    }


    private void selectBook() {
        booksList.clear();
        Cursor query = library.rawQuery("SELECT * FROM books ;", null);
        if (query.moveToFirst()) {
            do {
                String title = query.getString(1);
                String author = query.getString(2);
                String deadline = query.getString(3);
                booksList.add(new Books(title, author, deadline));
            } while (query.moveToNext());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        library.close();
    }
}
