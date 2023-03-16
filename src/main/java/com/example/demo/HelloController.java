package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.demo.HelloApplication;
import javafx.stage.FileChooser;

public class HelloController implements Initializable {

    @FXML
    private HBox cardLayout;
    @FXML
    private TextField titleToAdd;
    @FXML
    private TextField yearToAdd;
    @FXML
    private TextField titleToRemove;

    private Biblio myBib;


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        System.out.println("Init helloController");

        createBib();

        updateDisplay();

    }

    public void updateDisplay(){
        // Remove all children first, and add the existing one (not very effective but simple enough)
        cardLayout.getChildren().clear();

        try {
            // Run through the list of movie and add them in the view
            for (Movie movie: this.myBib.getMovieCollection()) {
                // Display movie
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));
                VBox cardBox = fxmlLoader.load();
                cardController cardCtr = fxmlLoader.getController();
                cardCtr.setData(movie);
                cardLayout.getChildren().add(cardBox);
                //System.out.println(movie);
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void createBib(){
        // Create films
        Actor HarrisonFord = new Actor("Harrison Ford", 81);
        Actor MarkHamill = new Actor("Mark Hamill", 71);
        Image img = new Image(getClass().getResourceAsStream("/img/starwars.jpg"));
        Movie starWars = new Movie("Star Wars", new Actor[]{HarrisonFord, MarkHamill}, img, 1977);
        //System.out.println(starWars);

        Actor KarenAllen = new Actor("Karen Allen", 71);
        img = new Image(getClass().getResourceAsStream("/img/indianaJones.jpg"));
        Movie IndianaJones = new Movie("Indiana Jones", new Actor[]{HarrisonFord, KarenAllen}, img, 1981);
        //System.out.println(IndianaJones);

        Actor ChristianBale = new Actor("Christian Bale", 49);
        Actor CillianMurphy = new Actor("Cillian Murphy", 46);
        img = new Image(getClass().getResourceAsStream("/img/BatmanBegins.jpg"));
        Movie BatmanBegins = new Movie("Batman Begins", new Actor[]{ChristianBale, CillianMurphy}, img, 2005);

        this.myBib = new Biblio();
        this.myBib.addMovie(starWars);
        this.myBib.addMovie(IndianaJones);
        this.myBib.addMovie(BatmanBegins);

//        this.myBib.printCollection();
//
//        this.myBib.removeMovie("Star Wars");
//        this.myBib.removeMovie("Oblivion");
//
//        this.myBib.printCollection();
    }

//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//        mylabel.setText("Hellooo000");
//    }
    @FXML
    protected void onAddButtonClick(){
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        // Show open file dialog
        File file = fileChooser.showOpenDialog(null);

        Image img = null;
        if (file != null) {
            img = new Image(file.toURI().toString());
        }

        // Create new movie with info from textField
        Movie movie = new Movie(titleToAdd.getText(), new Actor[]{}, img, Integer.valueOf(yearToAdd.getText()));
        System.out.println("Add movie");
        this.myBib.addMovie(movie);
        this.myBib.printCollection();
        updateDisplay();
    }

    @FXML
    protected void onRemoveButtonClick(){
        System.out.println("Remove movie..");
        this.myBib.removeMovie(titleToRemove.getText());
        updateDisplay();
    }
}