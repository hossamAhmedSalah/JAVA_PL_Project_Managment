package com.java_pl_project_managment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {
    @FXML
    CategoryAxis proX;
    @FXML
    NumberAxis proY;
    @FXML
    BarChart<String, Number> chart ;
    @FXML
    private Label pmEmailID;
    @FXML
    private Label pmNameID;
    @FXML
    private Label budgetCouter;
    @FXML
    private Label employeeCounter;
    @FXML
    private Label projeectsCounter;



    @FXML
    public void SwitchToDsashboard(ActionEvent event) throws IOException {
        System.out.println("dashBoard");



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
    public void SwitchToProject(ActionEvent event) throws IOException {

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO generalize this code
        pmEmailID.setText("Hossam_pm@gmail.com");
        pmNameID.setText("Hossam");
        employeeCounter.setText("50");
        budgetCouter.setText("837$");
        projeectsCounter.setText("7");
        Random r = new Random();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series.setName("project progresss");
        series1.setName("project x");


        series.getData().add(new XYChart.Data<>("pro_3", r.nextDouble(0, 101)));
        series.getData().add(new XYChart.Data<>("pro_4", r.nextDouble(0, 101)));
        series1.getData().add(new XYChart.Data<>("pro_x1", r.nextDouble(0, 101)));
        series1.getData().add(new XYChart.Data<>("pro_x2", r.nextDouble(0, 101)));

        chart.getData().addAll(series, series1);
    }
}
