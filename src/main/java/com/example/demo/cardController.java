package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


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
    }
}
