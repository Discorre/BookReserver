package com.example.bookreserver;

import static com.example.bookreserver.NewDetails.deadline;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MyBooksRV extends RecyclerView.Adapter<MyBooksRV.ViewHolder> {

    private final ArrayList<Books> mybooks;
    private final LayoutInflater inflater;
    /*private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMM-yyyy");
    private static Calendar c = Calendar.getInstance();
    String deadline12 = NewDetails.deadline;*/


    public MyBooksRV(ArrayList<Books> mybooks, Context context) {
        this.mybooks = mybooks;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.mybooks_main, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Books books = mybooks.get(position);
        holder.mybook.setText("Название: " + books.getName());
        holder.myauthor.setText("Автор: " + books.getAuthor());
        /*try {
            c.setTime(sdf.parse(deadline12));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, 14);
        deadline12 = sdf.format(c.getTime());*/

        holder.mydeadline.setText("Дата сдачи: "+books.getDeadline());
    }

    @Override
    public int getItemCount() {
        return mybooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mybook, myauthor, mydeadline;

        public ViewHolder(@NonNull View v) {
            super(v);
            mybook = v.findViewById(R.id.mytitle);
            myauthor = v.findViewById(R.id.myauthor);
            mydeadline = v.findViewById(R.id.mydeadline);
        }
    }
}
