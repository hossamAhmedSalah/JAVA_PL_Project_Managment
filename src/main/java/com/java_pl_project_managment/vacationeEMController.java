package com.java_pl_project_managment;

import com.java_pl_project_managment.util.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;

public class vacationeEMController extends Employee {
    String state="";
    @FXML
    private DatePicker fomdate;

    @FXML
    private DatePicker todate;

    private String datex="2020-12-1",datey="2020-12-3";
    private int req_id;
    @FXML
    private TextField input_text;

    @FXML
    private Button checkbutton;
    int scanid;


    public vacationeEMController() throws SQLException {
    }

    public void getstart(ActionEvent event){
        LocalDate start = fomdate.getValue();
        String dates = start.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.datex=dates;
    }
    public void getend(ActionEvent event){
        LocalDate end = todate.getValue();
        String datee = end.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.datey = datee;
    }

    public void sendrequest(ActionEvent event) throws SQLException {
        query("insert into vacation values('"+email+"','"+datex+"','"+datey+"',"+2+")");
        rs = statement.executeQuery("select v_id from vacation where(em_email='"+email+"' and s_date='"+datex+"' and e_date='"+datey+"')");
        if(rs.next()) req_id = rs.getInt("v_id");
        Alert sent_req =new Alert(Alert.AlertType.WARNING);
        sent_req.setTitle("send request");
        sent_req.setContentText("id of your request is "+req_id);
        sent_req.setHeaderText("Request sent successfully!");
        sent_req.show();
    }

    public void checkreq(ActionEvent event) throws SQLException {
        String[] v_state = {"Rejected","Accepted","Pending"};
        try {
            rs = statement.executeQuery("select v_state as v from vacation where v_id=" + Integer.parseInt(input_text.getText()));
            if(rs.next()) state = v_state[rs.getInt("v")];
            Alert check =new Alert(Alert.AlertType.WARNING);
            check.setTitle("vacation state");
            check.setHeaderText("your vacation is "+state);
            check.show();
        }
        catch (NumberFormatException e){
            Alert input_int =new Alert(Alert.AlertType.WARNING);
            input_int.setTitle("error");
            input_int.setHeaderText("invalid input");
            input_int.setContentText("enter an integer value");
            input_int.show();
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

