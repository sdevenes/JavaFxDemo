package com.example.demo;

import javafx.scene.image.Image;

/**
 * Class representing a Movie
 */
public class Movie {
    protected String title;
    protected int rating;
    protected Actor[] actorList;
    protected Image img;
    protected int year;

    /**
     * Constructor with initial values
     * @param title The title of the movie
     * @param actorList The list of actor who played in the movie
     * @param img The cover image of the movie
     * @param year The release year of the movie
     */
    public Movie(String title, Actor[] actorList, Image img, int year){
        this.title = title;
        this.actorList = actorList;
        this.img = img;
        this.year = year;
    }

    /**
     * Getter for the movie's title
     * @return
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Getter for the movie's year
     * @return The year of the release of the movie
     */
    public int getYear(){
        return this.year;
    }

    /**
     * Getter for the movie's cover image
     * @return The movie's cover image
     */
    public Image getImg(){
        return this.img;
    }

    /**
     * Getter for the list of actor
     * @return
     */
    public Actor[] getActorList(){
        return this.actorList;
    }

    /**
     * Allows to use println() on a Movie object
     * @return The movie info as a String object
     */
    public String toString() {
        String str = "Title: " + this.title + "\n\tYear: " + year + "\n\tActor(s):";
        for (Actor act: this.actorList){
            str += "\n\t -" + act.toString();
        }
        return str;
    }
}
