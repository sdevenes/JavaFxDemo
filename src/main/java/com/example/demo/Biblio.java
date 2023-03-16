package com.example.demo;

import java.util.ArrayList;

/**
 *  Class containing the list of movies
 */
public class Biblio {
    protected ArrayList<Movie> movieCollection = new ArrayList<Movie>();

    public Biblio(){
        // Default constructor
    }

    /**
     * Constructor with initial movie list
     * @param movieCollection the ArrayList of Movie objects
     */
    public Biblio(ArrayList<Movie> movieCollection){
        this.movieCollection = movieCollection;
    }

    /**
     * Getter for the list of Movies
     * @return The list of Movie
     */
    public ArrayList<Movie> getMovieCollection(){
        return this.movieCollection;
    }

    /**
     * Print in the console the list of Movies
     */
    public void printCollection(){
        for (Movie item: this.movieCollection){
            System.out.println(item);
        }
    }

    /**
     * Add a new movie in the list
     * @param movie The movie object to add in the biblio
     */
    public void addMovie(Movie movie){
        this.movieCollection.add(movie);
    }

    /**
     * Remove a movie of the list given its title
     * @param movieTitle The movie title
     */
    public void removeMovie(String movieTitle){
        Movie movieToRemove = null;
        System.out.println("Looking for movie title to remove:" + movieTitle);

        for (Movie item: this.movieCollection){
            System.out.println(item.getTitle());
            if (item.getTitle().equals(movieTitle)) {
                movieToRemove = item;
//                this.movieCollection.remove(item);
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
