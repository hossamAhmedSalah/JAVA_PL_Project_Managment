package com.java_pl_project_managment;

import com.java_pl_project_managment.util.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
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
        try {
            loadPieChartData();
        } catch (SQLException e) {
            System.out.println("pie error");
            throw new RuntimeException(e);
        }
        
        // ObservableList<PieChart.Data> pieChartData2 =
        //         FXCollections.observableArrayList(
        //                 new PieChart.Data("Not Started", 80),
        //                 new PieChart.Data("in_progress", 100),
        //                 new PieChart.Data("Completed", 10)
        //         );

        // pieChart.setData(pieChartData2);


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




    private void loadPieChartData() throws SQLException{
        ObservableList<PieChart.Data> pp = FXCollections.observableArrayList();

        rs = statement.executeQuery("select count(pro_state) as cnt from project where pro_state = 0");
        rs.next();
        int s = rs.getInt("cnt");
        rs = statement.executeQuery("select count(pro_state) as cnt from  project where pro_state = 1");
        rs.next();
        int c =  rs.getInt("cnt");
        rs = statement.executeQuery("select count(pro_state) as cnt from  project where pro_state = 2");
        rs.next();
        int p = rs.getInt("cnt");

        int allPro = s+p+c;


        pp.add(0,new PieChart.Data("Not_Started",((double)s/allPro) * 100));
        pp.add(1,new PieChart.Data("in_progress", ((double)p/allPro) * 100));
        pp.add(2,new PieChart.Data("Completed",((double)c/allPro) * 100));

        pieChart.setData(pp);
    }

    @FXML
    void logOut(ActionEvent event) {
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
