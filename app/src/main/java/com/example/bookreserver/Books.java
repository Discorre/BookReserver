package com.example.bookreserver;

public class Books {
    private String title;
    private String author;


    public Books(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
