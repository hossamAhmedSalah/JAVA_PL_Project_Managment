package com.java_pl_project_managment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import com.java_pl_project_managment.util.Employee;

public class dashboardController extends Employee implements Initializable {
    
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
    private PieChart pieChart;
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
        pmEmailID.setText(Employee.email);
        pmNameID.setText(Employee.username);
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

            rs = statement.executeQuery("select sum(salary) as sum from account");
            rs.next();
            n = rs.getInt("sum");
            budgetCouter.setText(Integer.toString(n)+"$");
        }
        catch(Exception e){
            System.out.println("استر يا رب ايرور فى الكونكشن");
        }


        try {
            loadBarChartData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList<PieChart.Data> pieChartData2 =
                FXCollections.observableArrayList(
                        new PieChart.Data("Not Started", 80),
                        new PieChart.Data("in_progress", 100),
                        new PieChart.Data("Completed", 10)
                );

        pieChart.setData(pieChartData2);


    }

    private void loadBarChartData() throws SQLException{
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("project progresss");

        rs = statement.executeQuery("select pro_name, comp_percent from project");
        while(rs.next()){

            series.getData().add(new XYChart.Data<>(rs.getString("pro_name"),  rs.getDouble("comp_percent")));
        }

        chart.getData().add(series);


    }




    private ObservableList<PieChart.Data> loadPieChartData() throws SQLException{
        ResultSet notStarted = statement.executeQuery("select count(pro_state)  from project where pro_state = 0");
        ResultSet Completed = statement.executeQuery("select count(pro_state) from  project where pro_state = 1");
        ResultSet inProgress = statement.executeQuery("select count(pro_state) from  project where pro_state = 2");
        int s = notStarted.getInt((0));
        int p =  inProgress.getInt(0);
        int c = Completed.getInt(0);
        double allPro = s+p+c;


        return FXCollections.observableArrayList(
//                        new PieChart.Data("Not_Started",(s/allPro)*100),
//                        new PieChart.Data("in_progress", (c/allPro)*100),
//                        new PieChart.Data("Completed",(p/allPro)*100)
        new PieChart.Data("Not_Started",10),
        new PieChart.Data("in_progress", 20),
        new PieChart.Data("Completed",70)



        );

//        pieChart.setTitle("project states");
//        pieChart.setData(pieChartData);



    }
    @FXML
    void logOut(ActionEvent event) {
        try {
            App.setRoot("fxml/main");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
