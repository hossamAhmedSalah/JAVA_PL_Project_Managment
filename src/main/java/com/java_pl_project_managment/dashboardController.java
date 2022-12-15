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
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import com.java_pl_project_managment.util.Account;

public class dashboardController extends Account implements Initializable {
    
    public dashboardController() throws SQLException {
    }

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
    }
    @FXML
    public void SwitchToProject(ActionEvent event) throws IOException {
        System.out.println("project");
        App.setRoot("fxml/ProjectsPM");
    }
    @FXML
    public void SwitchToReport(ActionEvent event) throws IOException{
        System.out.println("Report view");
        App.setRoot("fxml/Report");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        pmEmailID.setText(Account.email);
        pmNameID.setText(Account.username);
        int n;
        try{
            rs = statement.executeQuery("select count(*) as cnt from em");
            rs.next();
            n = rs.getInt("cnt");
            employeeCounter.setText(Integer.toString(n));

            rs = statement.executeQuery("select count(*) as cnt from project");
            rs.next();
            n = rs.getInt("cnt");
            projeectsCounter.setText(Integer.toString(n));

            budgetCouter.setText("837$");
        }
        catch(Exception e){
            System.out.println("خخخخخخخخخخخخخخخخخ");
        }
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
