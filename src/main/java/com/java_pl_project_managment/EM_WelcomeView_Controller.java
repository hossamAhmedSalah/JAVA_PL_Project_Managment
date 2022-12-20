package com.java_pl_project_managment;

import com.java_pl_project_managment.util.Account;
import com.java_pl_project_managment.util.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EM_WelcomeView_Controller extends Account implements Initializable {
    @FXML
    public Button startWork;
    @FXML
    public Button endWork;

    public long startTimer ;
    public long endTimer ;

    @FXML
    public Button totalHours ;
    @FXML
    public Label employee_name ;
    @FXML
    public Label employeeName ;


    public EM_WelcomeView_Controller() throws SQLException {
    }

    public void StartWork() {

        startWork.setStyle("-fx-background-color: red");
        startWork.setMinWidth(350);
        startWork.setText("Now you are starting Work");
        startWork.setCancelButton(true);
        this.startTimer = System.currentTimeMillis() ;
        endWork.setText("End Work");
        endWork.setStyle("-fx-backrgound-color : #0ECDFF ");
        endWork.setMinWidth(178);
        totalHours.setText("Working Timer");
        totalHours.setStyle("-fx-backrgound-color : #0ECDFF ");
        totalHours.setMinWidth(197);

    }

    public void EndWork() {
        if (startWork.isCancelButton()) {
            endWork.setStyle("-fx-background-color : red");
            endWork.setMinWidth(370);
            endWork.setText("Now you finished your Work");
            this.endTimer = System.currentTimeMillis();
            startWork.setText("Start Work");
            startWork.setStyle("-fx-backrgound-color : #7AA5FF");
            startWork.setMinWidth(167);
        }
    }
    public void worksHourTimer(){
        totalHours.setStyle("-fx-background-color : red");
        totalHours.setMinWidth(370);

        totalHours.setText("you have worked : " + ((endTimer - startTimer)/1000f)/60f + "minutes");

        startWork.setText("Start Work");
        startWork.setStyle("-fx-backrgound-color : #7AA5FF");
        startWork.setMinWidth(167);
        endWork.setText("End Work");
        endWork.setStyle("-fx-backrgound-color : #0ECDFF ");
        endWork.setMinWidth(178);
    }


    public void gotoTasks(ActionEvent event) throws IOException {
        App.setRoot("fxml/task-view1");
    }
    public void switch_to_mdata(ActionEvent event) throws IOException {
        App.setRoot("fxml/Monthdata");
    }
    public void switch_to_vacation(ActionEvent event) throws IOException {
        App.setRoot("fxml/vacationEM");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employee_name.setText(Account.username);
        employeeName.setText("Welcome "+Account.username);

    }
}
