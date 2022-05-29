package com.example.bookreserver;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SelectBooks extends AppCompatActivity {
    ArrayList<Books> booksList = new ArrayList<>();
    RecyclerView recyclerView;
    BookAdapterRV bookAdapterRV;
    DatabaseHelper databaseHelper;
    SQLiteDatabase library;

    EditText sercher;
    Button serchbtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        library = getBaseContext().openOrCreateDatabase("library.db", MODE_PRIVATE, null);
        library.execSQL("CREATE TABLE IF NOT EXISTS books(title TEXT NOT NULL, author TEXT NOT NULL, reserver TEXT NOT NULL)");
        setContentView(R.layout.booklist);
        recyclerView = findViewById(R.id.list_viewselect);
        bookAdapterRV = new BookAdapterRV(this,booksList);
        recyclerView.setAdapter(bookAdapterRV);
        //databaseHelper = new DatabaseHelper(getApplicationContext());
        //library = databaseHelper.getReadableDatabase();

        sercher = findViewById(R.id.search);
        serchbtn = findViewById(R.id.searchbtn);

        serchbtn.setOnClickListener(v -> {
            sercher.setText(null);
        });
        initBooks();
        selectBook();


    }



    private void initBooks() {
        booksList.clear();
        library.execSQL("INSERT INTO books VALUES ('Капитанская дочка','А.С.Пушкин','');");
        library.execSQL("INSERT INTO books VALUES ('Война и мир','Л.Н.Толстой','');");
        library.execSQL("INSERT INTO books VALUES ('Челкаш','М.Горький','');");
        library.execSQL("INSERT INTO books VALUES ('Человек в футляре','А.П.Чехов','');");
        library.execSQL("INSERT INTO books VALUES ('Преступление и наказание','Ф.И.Достоевский','');");
        library.execSQL("INSERT INTO books VALUES ('Ревизор','Н.В.Гоголь','');");
        library.execSQL("INSERT INTO books VALUES ('Собачье сердце','М.Булгаков','');");
        library.execSQL("INSERT INTO books VALUES ('Три товарища','Эрих Мария Ремарк','');");
        library.execSQL("INSERT INTO books VALUES ('Мёртвые Души','Н.В.Гоголь','');");
        library.execSQL("INSERT INTO books VALUES ('Евгений Онегин','А.С.Пушкин','');");
        library.execSQL("INSERT INTO books VALUES ('Тихий Дон','М.А.Шолохов','');");
    }
    private void selectBook(){
        booksList.clear();
        Cursor query = library.rawQuery("SELECT * FROM books;", null);
        if (query.moveToFirst()) {
            do{
                String title = query.getString(0);
                String author= query.getString(1);
                booksList.add(new Books(title, author));
            }while(query.moveToNext());
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        library.close();
    }
}
