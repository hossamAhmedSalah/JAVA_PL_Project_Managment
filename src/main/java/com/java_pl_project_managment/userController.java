package com.java_pl_project_managment;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import com.java_pl_project_managment.util.Account;
import com.java_pl_project_managment.util.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class userController extends Admin implements Initializable{

    public userController() throws SQLException {
    }

    @FXML
    private Button pushBtn;
    @FXML
    private ComboBox<String> choice;

    @FXML
    private TextField email;
    @FXML
    private TextField gender;
    @FXML
    private TextField imgUrl;
    @FXML
    private TextField password;
    @FXML
    private TextField role;
    @FXML
    private TextField salary;
    @FXML
    private TextField username;

    @FXML
    private Label welcome_ad;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        welcome_ad.setText("Welcome "+Account.username);
    }

    Alert a = new Alert(AlertType.NONE);

    @FXML
    private void viewP(MouseEvent event) throws IOException{
        App.setRoot("fxml/admin");
    }
    @FXML
    private void addU(MouseEvent event) throws IOException{
        // App.setRoot("fxml/modifyUsers");
    }
    
    @FXML
    private void comboAction(ActionEvent event) {
        String chs = choice.getValue();
        // System.out.println(choice.getValue());
        if(chs.equals("Add")){
            email.setEditable(true);
            email.setPromptText("email");
            username.setEditable(true);
            username.setPromptText("username");
            password.setEditable(true);
            password.setPromptText("password");
            role.setEditable(true);
            role.setPromptText("role");
            gender.setEditable(true);
            gender.setPromptText("gender");
            imgUrl.setEditable(true);
            imgUrl.setPromptText("imgUrl");
            salary.setEditable(true);
            salary.setPromptText("salary");
        }
        else if(chs.equals("Delete")){
            email.setEditable(true);
            email.setPromptText("email");
            username.setEditable(false);
            username.setPromptText("NOT EDITABLE");
            username.clear();
            password.setEditable(false);
            password.setPromptText("NOT EDITABLE");
            password.clear();
            role.setEditable(false);
            role.setPromptText("NOT EDITABLE");
            role.clear();
            gender.setEditable(false);
            gender.setPromptText("NOT EDITABLE");
            gender.clear();
            imgUrl.setEditable(false);
            imgUrl.setPromptText("NOT EDITABLE");
            imgUrl.clear();
            salary.setEditable(false);
            salary.setPromptText("NOT EDITABLE");
            salary.clear();
        }
        else if(chs.equals("Update")){
            email.setEditable(true);
            email.setPromptText("email");
            username.setEditable(true);
            username.setPromptText("username");
            password.setEditable(true);
            password.setPromptText("password");
            role.setEditable(false);
            role.setPromptText("NOT EDITABLE");
            role.clear();
            gender.setEditable(true);
            gender.setPromptText("gender");
            imgUrl.setEditable(true);
            imgUrl.setPromptText("imgUrl");
            salary.setEditable(true);
            salary.setPromptText("salary");
        }
    }

    @FXML
    private void modbtn(ActionEvent event) throws SQLException{
        if(!email.getText().equals("")){
            if(choice.getValue().equals("Add")){
                if(super.add(new String[]{email.getText(),username.getText(),password.getText(),gender.getText(),role.getText(),imgUrl.getText(),salary.getText(),null})){
                    a.setAlertType(AlertType.INFORMATION);
                    a.setHeaderText("");
                    a.setContentText("Added Successfully");
                    a.showAndWait();
                }
                else if(!(role.getText() == "em" || role.getText() == "ad" || role.getText() == "tl" || role.getText() == "pm") ){
                    a.setAlertType(AlertType.ERROR);
                    a.setHeaderText("");
                    a.setContentText("Wrong Role Type!");
                    a.showAndWait();
                }
                else{
                    a.setAlertType(AlertType.ERROR);
                    a.setHeaderText("");
                    a.setContentText("Email Already Added!");
                    a.showAndWait();
                }
            }
            else if(choice.getValue().equals("Delete")){
                if(super.delete(email.getText())){
                    a.setAlertType(AlertType.INFORMATION);
                    a.setHeaderText("");
                    a.setContentText("Deleted Successfully");
                    a.showAndWait();
                }
                else{
                    a.setAlertType(AlertType.ERROR);
                    a.setHeaderText("");
                    a.setContentText("Email Not Found!");
                    a.showAndWait();
                }
            }
            else if(choice.getValue().equals("Update")){
                if(super.update(new String[]{email.getText(),username.getText(),password.getText(),gender.getText(),imgUrl.getText(),salary.getText()})){
                    a.setAlertType(AlertType.INFORMATION);
                    a.setHeaderText("");
                    a.setContentText("Updated Successfully");
                    a.showAndWait();
                }
                else{
                    a.setAlertType(AlertType.ERROR);
                    a.setHeaderText("");
                    a.setContentText("Email Not Found!");
                    a.showAndWait();
                }
            }
        }
        else{
            a.setAlertType(AlertType.WARNING);
            a.setHeaderText("");
            a.setContentText("Email Cannot be empty");
            a.showAndWait();
        }
    }

    @FXML
    private void logOut(ActionEvent event){
        Alert y = new Alert(Alert.AlertType.CONFIRMATION);
        if (Objects.equals(Account.gender, "M")){
            y.setTitle("Are you sure you want to log out MR."+ Account.username);
            y.setContentText("stay in your work☠ manager, the plan need more details🥺");
            y.setResizable(true);
        }
        else {
            y.setTitle("Are you sure you want to log out Miss."+ Account.username);
            y.setContentText("bye hope the extra money the other company would pay for you deserve😶");
            y.setResizable(true);
        }
        if(y.showAndWait().get() == ButtonType.OK){
            try {
                App.setRoot("fxml/main");
                Account.email = null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
