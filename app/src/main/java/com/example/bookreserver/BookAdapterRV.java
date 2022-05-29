package com.example.bookreserver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.util.ArrayList;

public class BookAdapterRV extends RecyclerView.Adapter<BookAdapterRV.ViewHolder> {
    private final ArrayList<Books> books;
    private final LayoutInflater inflater;

    public BookAdapterRV(Context context, ArrayList<Books> books) {
        this.books = books;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public BookAdapterRV.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapterRV.ViewHolder holder, int position) {
        Books bookin = books.get(position);
        holder.bname.setText(bookin.getName());
        holder.author.setText(bookin.getAuthor());
        holder.resbtn.setOnClickListener(v -> {

        });

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final Button resbtn;
        final TextView bname, author;
        public ViewHolder(@NonNull View v) {
            super(v);
            resbtn = v.findViewById(R.id.reservebtn);
            bname = v.findViewById(R.id.name);
            author = v.findViewById(R.id.author);

        }
    }

}
