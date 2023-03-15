package com.example.demo;

public class Movie {
    protected String title;
    protected int rating;
    protected Actor[] actorList;
    protected String img;
    protected int year;

    // Constructor
    public Movie(String name, Actor[] actorList, String img, int year){
        this.title = name;
        this.actorList = actorList;
        this.img = img;
        this.year = year;
    }

    public String getTitle(){
        return this.title;
    }

    public Actor[] getActorList(){
        return this.actorList;
    }

    // To print info on movie
    public String toString() {
        String str = "Title: " + this.title + "\n\tYear: " + year + "\n\tActor(s):";
        for (Actor act: this.actorList){
            str += "\n\t -" + act.toString();
        }
        return str;

    }
}
