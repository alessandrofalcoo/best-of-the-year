package org.lessons.java.best_of_the_year.controller;

public class Movie {
    private String title;
    private int id;

    public Movie(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}
