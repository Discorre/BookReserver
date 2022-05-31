package com.example.bookreserver;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    static Button myBooks, initBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBooks = findViewById(R.id.mybooks);
        myBooks.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MyBooks.class);
            startActivity(intent);
        });
        initBooks = findViewById(R.id.initbooks);
        initBooks.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SelectBooks.class);
            startActivity(intent);
        });


    }
}