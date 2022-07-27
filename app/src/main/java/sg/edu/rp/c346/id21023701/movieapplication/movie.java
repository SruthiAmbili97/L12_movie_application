package sg.edu.rp.c346.id21023701.movieapplication;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class movie extends ArrayAdapter {
    private String title;
    private String genre;
    private int year;
    private char rating;

    public movie(@NonNull Context context, int resource, String title, String genre, int year, char rating) {
        super(context, resource);
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public char getRating() {
        return rating;
    }

    public void setRating(char rating) {
        this.rating = rating;
    }
}
