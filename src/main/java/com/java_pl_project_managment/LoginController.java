package com.java_pl_project_managment;

import com.java_pl_project_managment.util.Account;
import com.java_pl_project_managment.util.Admin;
import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginController{
    // private String getStyle = getClass().getResource("style/app.css").toExternalForm();

    @FXML private TextField email;
    @FXML private PasswordField password;


    @FXML
    private void kek(ActionEvent event) throws IOException,SQLException {
        String e = email.getText();
        String p = password.getText();

        Alert a = new Alert(AlertType.NONE);

        Account u1 = new Account();
        if(!u1.Login(e, p)){
            a.setAlertType(AlertType.ERROR);
            a.setHeaderText("");
            a.setContentText("Wrong email or password");
            a.showAndWait();
            email.clear();
            password.clear();
        }
        else{
            a.setAlertType(AlertType.INFORMATION);
            a.setHeaderText("");
            a.setContentText("Welcome " + u1.username);
            a.showAndWait();
            Admin a1 = new Admin(u1);
            // a1.delete("hoh@g.com");
            // System.out.println(a1.username);
            // if(!a1.add(new String[]{"hoh@g.com","hoh","123","M","AD","//","125","null"})){
            //     a.setAlertType(AlertType.ERROR);
            //     a.setHeaderText("");
            //     a.setContentText("Cant insert duplicate emails");
            //     a.showAndWait();
            // }
        }
    }
}
