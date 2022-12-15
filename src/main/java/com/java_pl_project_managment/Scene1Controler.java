package com.java_pl_project_managment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene1Controler implements Initializable {
    public Button sendReport;
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private CategoryAxis proX;
    @FXML
    private NumberAxis proY;
    @FXML
    private BarChart<String, Number> chart ;

    @FXML
    private Label pmNameID;
    @FXML
    private Label pmEmailID;


    @FXML
    private TextField ReportDesc;

    @FXML
    private TextField ReportEM;

    @FXML
    private TextField ReportTL;


    //private String emp_Email, tl_Email, report_desc;




    private void setLable(Label l, String s){
        l.setText(s);

    }

    @FXML
    public void SwitchToDsashboard(ActionEvent event) throws IOException{
        System.out.println("dashBoard");

        System.out.println(pmEmailID.getText());
        System.out.println(pmNameID.getText());

        App.setRoot("fxml/dashboard");
        //        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
//
//        setLable(pmNameID, "Hossam");
//        setLable(pmEmailID, "Hossam@gmail.com");
//
//        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setResizable(false);
        //stage.show();








    }
    @FXML
    public void SwitchToProject(ActionEvent event) throws IOException{
        //TODO setter to the pm_email  txt field default value as the current pm_email

        System.out.println("project");
        App.setRoot("fxml/ProjectsPM");



//        Parent root = FXMLLoader.load(getClass().getResource("ProjectsPM.fxml"));
//        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();


    }
    @FXML
    public void SwitchToReport(ActionEvent event) throws IOException{
        System.out.println("Report view");
        App.setRoot("fxml/Report");
        //        Parent root = FXMLLoader.load(getClass().getResource("ProjectsPM.fxml"));
        //        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //        scene = new Scene(root);
        //        stage.setScene(scene);
        //        stage.setResizable(false);
        //        stage.show();


    }

    @FXML
    public void sendReport(ActionEvent event){
        String emp_Email, tl_Email, report_desc;
        report_desc = ReportDesc.getText();
        emp_Email = ReportEM.getText();
        tl_Email = ReportTL.getText();
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("can't send report");
        if(emp_Email.equals("") || tl_Email.equals("") || report_desc.equals("")){
            a.setContentText("fill all fields please");
            a.show();

        }
        else {
            System.out.println(report_desc+'\n'+emp_Email+'\n'+tl_Email);
            ReportDesc.setText("");
            ReportEM.setText("");
            ReportTL.setText("");


        }


    }



//

    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO we need to generalize the strings in the set-label
        setLable(pmNameID, "Hossam");
        setLable(pmEmailID, "Hossam@gmail.com");




    }



}