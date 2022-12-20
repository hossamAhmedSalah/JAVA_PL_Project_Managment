package com.java_pl_project_managment;

import com.java_pl_project_managment.util.Employee;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MonthdataControoler extends Employee implements Initializable {
    public MonthdataControoler() throws SQLException {
}

    @FXML
    private TableView<workhours> table;

    @FXML
    private TableColumn<workhours, String> date;

    @FXML
    private TableColumn<workhours, String> hours;

    @FXML
    private Label totalh;
    @FXML
    private Label netv;

    @FXML
    private Label penv;
    @FXML
    private Label bonv;

    @FXML
    private Label salaryv;
    ObservableList<workhours> list = FXCollections.observableArrayList();



    @FXML
    void getvalues() throws SQLException {
        String[][] work= getWorkHours(Employee.email);
        for(int i=0;i<work.length;i++)
            list.add(new workhours (work[i][1],work[i][0]));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            getvalues();
        }
        catch(Exception e){
            System.out.println("error");
        }
        date.setCellValueFactory(new PropertyValueFactory<workhours, String>("date" ));
        hours.setCellValueFactory(new PropertyValueFactory<workhours, String>("hours" ));
        table.setItems(list);
        hours.setResizable(false);
        date.setResizable(false);
        totalh.setAlignment(Pos.CENTER);
        salaryv.setAlignment(Pos.CENTER);
        netv.setAlignment(Pos.CENTER);
        bonv.setAlignment(Pos.CENTER);
        penv.setAlignment(Pos.CENTER);
        salaryv.setText(String.valueOf(super.salary));
        netv.setText(String.valueOf(super.netSalary));
        bonv.setText(String.valueOf(super.bonus));
        penv.setText(String.valueOf(super.penalty));
        try {
            totalh.setText(String.valueOf(super.getTotalMonthHours(this.email)));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void switch_to_mdata(ActionEvent event) throws IOException {
        App.setRoot("fxml/monthdata");
    }
    public void switch_to_vacation(ActionEvent event) throws IOException {
        App.setRoot("fxml/vacationEM");
    }
    public void gotoTasks(ActionEvent event) throws IOException {
        App.setRoot("fxml/task-view1");
    }
}

