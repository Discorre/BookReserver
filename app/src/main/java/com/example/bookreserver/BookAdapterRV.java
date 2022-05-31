package com.example.bookreserver;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapterRV extends RecyclerView.Adapter<BookAdapterRV.ViewHolder> implements View.OnClickListener {

    interface OnBookClickListener {
        void onBookClick(Books books, int position);
    }

    private final ArrayList<Books> books;
    private final LayoutInflater inflater;
    private Context mContext;

    private final OnBookClickListener onClickListener;

    public BookAdapterRV(ArrayList<Books> books, Context context, OnBookClickListener onClickListener) {
        this.books = books;
        this.inflater = LayoutInflater.from(context);
        this.mContext = context;
        this.onClickListener = onClickListener;

    }

    @NonNull
    @Override
    public BookAdapterRV.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapterRV.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Books bookses = books.get(position);
        holder.title.setText("Название: " + bookses.getName());
        holder.author.setText("Автор: " + bookses.getAuthor());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onBookClick(bookses, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    @Override
    public void onClick(View view) {
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView title;
        final TextView author;

        public ViewHolder(@NonNull View v) {
            super(v);
            title = v.findViewById(R.id.name);
            author = v.findViewById(R.id.author);


        }
    }

}
