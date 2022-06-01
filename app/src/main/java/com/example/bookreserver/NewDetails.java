package com.example.bookreserver;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewDetails extends AppCompatActivity {
    SQLiteDatabase library;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
    private static Calendar c = Calendar.getInstance();
    private static Date date = new Date();

    public static String deadline = sdf.format(c.getTime());

    public static final String EXTRA_MESSAGE123 = "com.example.bookreserver.MyBooksRV";

    EditText etnewnumpass;
    Button btnok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newdetails_main);
        library = getBaseContext().openOrCreateDatabase("library.db", MODE_PRIVATE, null);
        library.execSQL("CREATE TABLE IF NOT EXISTS mybooks(_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, author TEXT, numpass TEXT, deadline TEXT)");
        etnewnumpass = findViewById(R.id.newnumpass);
        btnok = findViewById(R.id.btnok);

        btnok.setOnClickListener(v -> {
            if (etnewnumpass.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "Введите данные!!!", Toast.LENGTH_SHORT).show();

            } else {
                update();
                goHome();

            }
        });
    }


    private void update() {
        Intent intent = getIntent();
        String dolche = intent.getStringExtra(SelectBooks.EXTRA_MESSAGE);
        String numpasser = etnewnumpass.getText().toString();
        try {
            c.setTime(sdf.parse(date.toString()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, 14);
        deadline = sdf.format(c.getTime());
        Intent intent1 = new Intent(this, MyBooksRV.class);
        intent1.putExtra(EXTRA_MESSAGE123, dolche);
        startActivity(intent);
        library.execSQL("INSERT INTO mybooks (title, author) SELECT title, author FROM books WHERE title = '" + dolche + "'");
        library.execSQL("UPDATE mybooks SET numpass = '" + numpasser + "' WHERE title = '" + dolche + "'");
        library.execSQL("UPDATE mybooks SET deadline = '" + deadline + "' WHERE title = '" + dolche + "'");
        library.execSQL("DELETE FROM books WHERE title = '" + dolche + "'");
        Toast.makeText(getApplicationContext(), "Приходите забирать", Toast.LENGTH_SHORT).show();
    }

    private void goHome() {
        library.close();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
