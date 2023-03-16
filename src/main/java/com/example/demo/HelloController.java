package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.demo.HelloApplication;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Label mylabel;

    @FXML
    private HBox cardLayout;

    private Biblio myBib;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        System.out.println("Init helloController");

        createBib();

        try {
            for (Movie movie: this.myBib.getMovieCollection()) {
                // Display movie
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                VBox cardBox = fxmlLoader.load();
                cardController cardCtr = fxmlLoader.getController();
                cardCtr.setData(movie);
                cardLayout.getChildren().add(cardBox);
                System.out.println(movie);
            }

        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public void createBib(){
        // Create films
        Actor HarrisonFord = new Actor("Harrison Ford", 81);
        Actor MarkHamill = new Actor("Mark Hamill", 71);
        Movie starWars = new Movie("Star Wars", new Actor[]{HarrisonFord, MarkHamill}, "starwars.jpg", 1977);
        System.out.println(starWars);

        Actor KarenAllen = new Actor("Karen Allen", 71);
        Movie IndianaJones = new Movie("Indiana Jones", new Actor[]{HarrisonFord, KarenAllen}, "indianaJones.jpg", 1981);
        System.out.println(IndianaJones);

        this.myBib = new Biblio();
        this.myBib.addMovie(starWars);
        this.myBib.addMovie(IndianaJones);

//        this.myBib.printCollection();
//
//        this.myBib.removeMovie("Star Wars");
//        this.myBib.removeMovie("Oblivion");
//
//        this.myBib.printCollection();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        mylabel.setText("Hellooo000");
    }
}