package com.example.demo;

/**
 * Class representing an Actor
 */
public class Actor {
    protected String name;
    protected int age;

    /**
     * Constructor with initial values
     * @param name The actor's name
     * @param age The actor's age
     */
    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Getter for the actor's name
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the actor's age
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * Allows to use println() on an Actor object
     * @return The actor's info as a String object
     */
    public String toString() {
        return this.name + " (" + age + ")";
    }
}
