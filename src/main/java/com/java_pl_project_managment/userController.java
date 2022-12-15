package com.java_pl_project_managment;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class userController {
    @FXML
    private void viewP(MouseEvent event) throws IOException{
        App.setRoot("fxml/admin");
    }
    @FXML
    private void addU(MouseEvent event) throws IOException{
        App.setRoot("fxml/addUser");
    }
    @FXML
    private void deleteU(MouseEvent event) throws IOException{
        App.setRoot("fxml/deleteUser");
    }
    @FXML
    private void updateU(MouseEvent event) throws IOException{
        App.setRoot("fxml/updateUser");
    }
    
}
