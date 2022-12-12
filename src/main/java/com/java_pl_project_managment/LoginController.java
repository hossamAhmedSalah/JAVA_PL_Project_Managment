package com.java_pl_project_managment;

import com.java_pl_project_managment.util.User;
import com.java_pl_project_managment.util.DB.*;
import java.io.IOException;
import java.sql.SQLException;

import javafx.css.CssMetaData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

public class LoginController{
    private String getStyle = getClass().getResource("style/app.css").toExternalForm();

    @FXML private TextField email;
    @FXML private TextField password;
    @FXML private DialogPane log_dialog;

    @FXML
    private void kek(ActionEvent event) throws IOException,SQLException {
        String e = email.getText();
        String p = password.getText();
        // System.out.println(e);
        // System.out.println(p);
        User u1 = new User();
        if(!u1.Login(e, p)){
            log_dialog.setContentText(" ");
            log_dialog.setContentText("Wrong email or password");
        }
        else{
            log_dialog.setContentText(" ");
            log_dialog.setContentText("Welcome " + u1.name + "!!");
            return;
        }
        // System.out.println(u1.toString());
    }
}
