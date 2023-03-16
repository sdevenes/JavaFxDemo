package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;

public class cardController {

    @FXML
    private VBox box;

    @FXML
    private ImageView imgPlaceholder;

    @FXML
    private Label titleLabel;

    @FXML
    private Label yearLabel;

    public void setData(Movie movie){

        titleLabel.setText(movie.getTitle());
        yearLabel.setText(Integer.toString(movie.getYear()));
        imgPlaceholder.setImage(movie.getImg());
        //File file = new File("indianaJones.jpg");
        //System.out.println(file);
        //Image img = new Image(file.toURI().toString());
//        if (movie.getImg().length() > 0) {
//            Image img = new Image(getClass().getResourceAsStream("/img/" + movie.getImg()));
//            imgPlaceholder.setImage(img);
//        }
    }
}
