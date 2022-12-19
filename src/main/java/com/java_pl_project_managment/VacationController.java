package com.java_pl_project_managment;

import com.java_pl_project_managment.util.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private TableColumn<VacationTable, String> EndDate;

    @FXML
    private TableColumn<VacationTable,String > StartDate;

    @FXML
    private TableColumn<VacationTable,String> VacationState;

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
        StartDate.setCellValueFactory(new PropertyValueFactory<VacationTable,String>("StartDate"));
        EndDate.setCellValueFactory(new PropertyValueFactory<VacationTable,String>("EndDate"));
        em_email.setCellValueFactory(new PropertyValueFactory<VacationTable,String>("em_email"));
        VacationState.setCellValueFactory(new PropertyValueFactory<VacationTable,String>("VacationState"));


        try{
            load();
        }
        catch(Exception e){
            System.out.println("ايرور");
        }
        VacationTable.setItems(list);
    }
    private void load() throws SQLException {
        String[] data = {"Rejected","Accepted","Pending"};
        rs = statement.executeQuery("select * from vacation");
        while(rs.next()){
            list.add(new VacationTable(
                    rs.getString("em_email"),
                    rs.getInt("v_id"),
                    String.valueOf(rs.getDate("s_date")),
                    String.valueOf(rs.getDate("e_date")),
                    data[rs.getInt("v_state")]
            ));
        }
    }
    @FXML
    void logOUT(ActionEvent event) throws IOException {
        App.setRoot("fxml/main");
    }

    void acceptV(ActionEvent event) {
        Alert x = new Alert(Alert.AlertType.WARNING); //
        if (!VacationTable.getSelectionModel().isEmpty()){
            int id = VacationTable.getSelectionModel().getSelectedIndex();
            // saving the name of thr deleted task to use later in db update
            String e_mail= VacationTable.getItems().get(id).getEm_email();
            System.out.println(e_mail+" have been accepted");

            // VacationTable.getItems().remove(id);
            try {
                query("update vacation set v_state = 1 where em_email = '"+e_mail+"'");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                App.setRoot("fxml/TLVacation");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        else {
            x.setTitle("there is no vacation to accept for now");
            x.show();
        }
    }

    @FXML
    void declineV(ActionEvent event) {
        Alert x = new Alert(Alert.AlertType.WARNING);
        if (!VacationTable.getSelectionModel().isEmpty()){
            int id = VacationTable.getSelectionModel().getSelectedIndex();
            // saving the name of thr deleted task to use later in db update
            String e_mail= VacationTable.getItems().get(id).getEm_email();
            System.out.println(e_mail+" have been rejected");

            // VacationTable.getItems().remove(id);
            try {
                query("update vacation set v_state = 0 where em_email = '"+e_mail+"'");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                App.setRoot("fxml/TLVacation");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        else {
            x.setTitle("there is no vacation to decline for now");
            x.show();
        }
    }

}