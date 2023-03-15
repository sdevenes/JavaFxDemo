package com.example.demo;

import java.util.ArrayList;

public class Biblio {
    protected ArrayList<Movie> movieCollection = new ArrayList<Movie>();

    public Biblio(){
        // Default constructor
    }
    public Biblio(ArrayList<Movie> movieCollection){
        this.movieCollection = movieCollection;
    }

    public ArrayList<Movie> getMovieCollection(){
        return this.movieCollection;
    }

    public void printCollection(){
        for (Movie item: this.movieCollection){
            System.out.println(item.getTitle());
        }
    }

    public void addMovie(Movie movie){
        this.movieCollection.add(movie);
    }

    public void removeMovie(String movieTitle){
        Movie movieToRemove = null;
        for (Movie item: this.movieCollection){
            if (item.getTitle() == movieTitle) {
                movieToRemove = item;
            }
        }
        if (movieToRemove != null){
            this.movieCollection.remove(movieToRemove);
            System.out.println("Movie with title " + movieTitle + " successfully removed!");
        }
        else {
            System.out.println("This movie does not exist!");
        }
    }
}
