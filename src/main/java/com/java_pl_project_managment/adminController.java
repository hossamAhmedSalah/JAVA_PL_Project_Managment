package com.java_pl_project_managment;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class adminController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}