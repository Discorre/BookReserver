package com.example.bookreserver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyBooksRV extends RecyclerView.Adapter<MyBooksRV.ViewHolder> {

    private final ArrayList<Books> mybooks;
    private final LayoutInflater inflater;


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
        String deadline = NewDetails.deadline;
        holder.mydeadline.setText("Дата сдачи: "+deadline);
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
