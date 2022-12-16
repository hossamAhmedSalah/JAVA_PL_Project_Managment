package com.java_pl_project_managment;

import com.java_pl_project_managment.util.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class VacationController extends Employee implements Initializable {
    @FXML
    private TableColumn<VacationTable, Date> EndDate;

    @FXML
    private TableColumn<VacationTable,Date > StartDate;

    @FXML
    private TableColumn<VacationTable,Integer> VacationState;

    @FXML
    private TableView<VacationTable> VacationTable;

    @FXML
    private Label completeBtn;

    @FXML
    private TableColumn<VacationTable, String> em_email;

    @FXML
    private Label employeeBtn;

    @FXML
    private Label reportBtn;

    @FXML
    private Label tasksBtn;

    @FXML
    private TableColumn<VacationTable,Integer > v_id;

    @FXML
    private Label vacationBtn;

    public VacationController() throws SQLException {
    }

    @FXML
    public void SwitchToVacation(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        App.setRoot("fxml/TLVacation");
    }
    @FXML
    public void SwitchToPenalty(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        App.setRoot("fxml/TLPenalty");
    }

    public void SwitchToAssignTask(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        App.setRoot("fxml/Tl_Tasks");
    }
    ObservableList<VacationTable> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        v_id.setCellValueFactory(new PropertyValueFactory<VacationTable,Integer>("v_id"));
        StartDate.setCellValueFactory(new PropertyValueFactory<VacationTable,Date>("StartDate"));
        EndDate.setCellValueFactory(new PropertyValueFactory<VacationTable,Date>("EndDate"));
        em_email.setCellValueFactory(new PropertyValueFactory<VacationTable,String>("em_email"));
        VacationState.setCellValueFactory(new PropertyValueFactory<VacationTable,Integer>("VacationState"));


        try{
            load();
        }
        catch(Exception e){
            System.out.println("ايرور");
        }
        VacationTable.setItems(list);
    }
    private void load() throws SQLException {
        rs = statement.executeQuery("select * from vacation");
        while(rs.next()){
            list.add(new VacationTable(
                    rs.getString("em_email"),
                    rs.getInt("v_id"),
                    rs.getDate("StartDate"),
                    rs.getDate("EndDate"),
                    rs.getInt("VacationState")
            ));
        }
    }
}
