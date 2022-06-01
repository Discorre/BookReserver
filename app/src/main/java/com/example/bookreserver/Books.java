package com.example.bookreserver;


public class Books{
    private String title;
    private String author;
    private String deadline;


    public Books(String title, String author, String deadline){
        this.title = title;
        this.author = author;
        this.deadline = deadline;
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
