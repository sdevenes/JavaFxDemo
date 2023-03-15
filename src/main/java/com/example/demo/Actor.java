package com.example.demo;

public class Actor {
    protected String name;
    protected int age;

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }
    // To print info on actor
    public String toString() {
        return this.name + " (" + age + ")";
    }
}
