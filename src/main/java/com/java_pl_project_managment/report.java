package com.java_pl_project_managment;
import com.java_pl_project_managment.reporttype;
import com.java_pl_project_managment.util.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class report extends Employee implements Initializable {
    @FXML
    private TableColumn<reporttype ,String> Descreport;

    @FXML
    private TableColumn<reporttype,String> EmployeeEmailreport;
    @FXML
    private TableView<reporttype> reporttable;
    @FXML
    private Button searchButton;

    ObservableList<projectH> reportlist = FXCollections.observableArrayList();
    private void reportload() throws SQLException{
        rs = statement.executeQuery("select * from project");
        while(rs.next()){
            reportlist.add(new reporttype(rs.getString("em_email"),
                    rs.getString("report_desc")));
        }
    }
//yarab



    @FXML
    void Refresh(ActionEvent event) {

    }
    @FXML
    void removeTask(ActionEvent event) {

    }

    @FXML
    void search(ActionEvent event) {

    }
    public report() throws SQLException {
    }

    @FXML
    void SwitchToAssignTask(MouseEvent event) throws IOException {
        App.setRoot("fxml/Tl_Tasks");
    }

    @FXML
    void SwitchToPenalty(MouseEvent event) throws IOException {
        App.setRoot("fxml/TLPenalty");
    }

    @FXML
    void SwitchToVacation(MouseEvent event) throws IOException {
        App.setRoot("fxml/TLVacation");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            reportload();
        }
        catch(Exception e){
            System.out.println("مشكلللللللله");
        }
        EmployeeEmailreport.setCellValueFactory(new PropertyValueFactory<reporttype,String>("Employee Email"));
        Descreport.setCellValueFactory(new PropertyValueFactory<reporttype,String>("Descreport"));
    }
}
