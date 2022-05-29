package com.example.bookreserver;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MyBooks extends AppCompatActivity {

    TextView myname,myfamile,mysurname,mynumpass,mybirthday;
    Button removebtn,updatebtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mybookslist);

        myname = findViewById(R.id.myname);
        myfamile = findViewById(R.id.myfamile);
        mysurname = findViewById(R.id.mysurname);
        mynumpass = findViewById(R.id.mynumpass);
        mybirthday = findViewById(R.id.mybirthday);

        removebtn = findViewById(R.id.removebtn);
        removebtn.setOnClickListener(view -> {

        });

        updatebtn = findViewById(R.id.updatebtn);
        updatebtn.setOnClickListener(view -> {

        });

    }
}
