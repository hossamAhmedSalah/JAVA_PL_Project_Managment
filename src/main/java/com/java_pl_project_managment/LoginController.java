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

public class LoginController extends Account{
    // private String getStyle = getClass().getResource("style/app.css").toExternalForm();

    public LoginController() throws SQLException {
    }

    @FXML private TextField email;
    @FXML private PasswordField password;

    @FXML
    private void kek(ActionEvent event) throws IOException,SQLException {
        String e = email.getText();
        String p = password.getText();

        Alert a = new Alert(AlertType.NONE);

        Account acc = new Account();
        if(!acc.Login(e, p)){
            a.setAlertType(AlertType.ERROR);
            a.setHeaderText("");
            a.setContentText("Wrong email or password");
            a.showAndWait();
            email.clear();
            password.clear();
        }
        else{
            // a.setAlertType(AlertType.INFORMATION);
            // a.setHeaderText("");
            // a.setContentText("Welcome " + Account.username);
            // a.showAndWait();   

            if(Account.role.toLowerCase().equals("ad")){
                Admin ad = new Admin();
                ad.view_project();
                App.setRoot("fxml/admin");
            }
            else if(Account.role.toLowerCase().equals("pm"))
                App.setRoot("fxml/dashboard");
            else if(Account.role.toLowerCase().equals("tl"))
                App.setRoot("fxml/TLPenalty");
            // else    App.setRoot("fxml/employee");
            // else    App.setRoot("fxml/primary");
        }
    }
}
