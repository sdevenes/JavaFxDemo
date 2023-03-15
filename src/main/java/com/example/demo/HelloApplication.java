package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        Biblio myBib;

        // Create films
        Actor HarrisonFord = new Actor("Harrison Ford", 81);
        Actor MarkHamill = new Actor("Mark Hamill", 71);
        Movie starWars = new Movie("Star Wars", new Actor[]{HarrisonFord, MarkHamill}, "", 1977);
        System.out.println(starWars);

        Actor KarenAllen = new Actor("Karen Allen", 71);
        Movie IndianaJones = new Movie("Indiana Jones", new Actor[]{HarrisonFord, KarenAllen}, "", 1981);
        System.out.println(IndianaJones);

        myBib = new Biblio();
        myBib.addMovie(starWars);
        myBib.addMovie(IndianaJones);

        myBib.printCollection();

        myBib.removeMovie("Star Wars");
        myBib.removeMovie("Oblivion");

        myBib.printCollection();


        launch();
    }
}