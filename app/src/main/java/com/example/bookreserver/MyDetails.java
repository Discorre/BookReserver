package com.example.bookreserver;

import static com.example.bookreserver.DatabaseHelper.TABLE;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyDetails extends AppCompatActivity {
    TextView myname, myfamile, mysurname, mynumpass, mybirthday;
    Button updatebtn, removebtn;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mydetails_main);
        myname = findViewById(R.id.myname);
        myfamile = findViewById(R.id.myfamile);
        mysurname = findViewById(R.id.mysurname);
        mynumpass = findViewById(R.id.mynumpass);
        mybirthday = findViewById(R.id.mybirthday);
        updatebtn = findViewById(R.id.updatebtn);
        removebtn = findViewById(R.id.removebtn);

        removebtn.setOnClickListener(view -> {

        });

        updatebtn.setOnClickListener(view -> {

        });
        /*private void selectUsers() {
            Cursor query = library.rawQuery("SELECT * FROM users", null);
            if (query.moveToFirst()) {
                String name = query.getString(1);
                String famile = query.getString(2);
                String surname = query.getString(3);
                String numpass = query.getString(4);
                String birthday = query.getString(5);
            }
        }*/

    }

}
