package com.example.bookreserver;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.UnusedAppRestrictionsBackportCallback;

public class NewDetails extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    SQLiteDatabase library;

    EditText etnewname, etnewfamile, etnewsurename, etnewnumpass, etnewbirthday;
    Button btnok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newdetails_main);
        library = getBaseContext().openOrCreateDatabase("library.db", MODE_PRIVATE, null);
        library.execSQL("CREATE TABLE IF NOT EXISTS users(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, famile TEXT NOT NULL, surname TEXT NOT NULL, numpass TEXT NOT NULL, birthday TEXT NOT NULL)");
        //databaseHelper = new DatabaseHelper(getApplicationContext());
        //library = databaseHelper.getWritableDatabase();
        etnewname = findViewById(R.id.newname);
        etnewfamile = findViewById(R.id.newfamname);
        etnewsurename = findViewById(R.id.newsurname);
        etnewnumpass = findViewById(R.id.newnumpass);
        etnewbirthday = findViewById(R.id.newbirthday);
        btnok = findViewById(R.id.btnok);
        btnok.setOnClickListener(v -> {
            if (etnewname != null || etnewfamile != null || etnewsurename != null || etnewnumpass != null || etnewbirthday != null) {
                initUsers();
            /*etnewname.setText(null);
            etnewfamile.setText(null);
            etnewsurename.setText(null);
            etnewnumpass.setText(null);
            etnewbirthday.setText(null);*/
                goHome();
            }else{
                Toast.makeText(getApplicationContext(),"NS XT CRF",Toast.LENGTH_LONG).show();

            }
        });


    }


    private void initUsers() {
        String name = etnewname.getText().toString();
        String famile = etnewfamile.getText().toString();
        String surname = etnewsurename.getText().toString();
        String numpass = etnewnumpass.getText().toString();
        String birthday = etnewbirthday.getText().toString();
        library.execSQL("INSERT INTO users(name, famile, surname, numpass, birthday) VALUES('"
                + name + "', '"
                + famile + "', '"
                + surname + "', '"
                + numpass + "', '"
                + birthday + "');");
//        databaseHelper.insertUsers(new Users(name, famile, surname, numpass, birthday), library);


    }

    private void goHome() {
        library.close();
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
