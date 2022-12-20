package com.java_pl_project_managment;
import com.java_pl_project_managment.reporttype;
import com.java_pl_project_managment.util.Account;
import com.java_pl_project_managment.util.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
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
    @FXML
    private TextField reportSearchBar;

    Alert m = new Alert(Alert.AlertType.WARNING);

    ObservableList<reporttype> reportlist = FXCollections.observableArrayList();
    private void reportload() throws SQLException{
        rs = statement.executeQuery("select * from report");
        while(rs.next()){
            reportlist.add(new reporttype(rs.getString("em_email"),
                    rs.getString("report_desc")));
        }
    }


    @FXML
    void Refresh(ActionEvent event) {
        try{
            App.setRoot("fxml/Tlreport");
        }
        catch (IOException e){
            System.out.println("cant switch");
        }
    }
    @FXML
    void removeTask(ActionEvent event) {
        if (!reporttable.getSelectionModel().isEmpty()){
            int id = reporttable.getSelectionModel().getSelectedIndex();
            // saving the name of thr deleted task to use later in db update
            String e_mail= reporttable.getItems().get(id).getEmp_email();
            String rep= reporttable.getItems().get(id).getReport_des();
            System.out.println(e_mail+" report have been deleted");

            try {
                query("delete from report where em_email = '"+e_mail+"' and report_desc = '"+rep+"'");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                App.setRoot("fxml/TLreport");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        else {
            m.setTitle("there is no report to delete");
            m.show();
        }
    }

    @FXML
    void search(ActionEvent event) {

        String keyWord = reportSearchBar.getText();
        if(!reporttable.getItems().stream().anyMatch(item-> item.getEmp_email().toLowerCase().equals(keyWord.toLowerCase()))){
            m.setAlertType(AlertType.ERROR);
            m.setContentText(keyWord + " not found");
            m.setHeaderText("");
            m.showAndWait();
            return;
        }

        reporttable.getItems().stream().filter(item-> Objects.equals(item.getEmp_email().toLowerCase(), keyWord.toLowerCase())).findAny().ifPresent(item -> {reporttable.getSelectionModel().select(item);reporttable.scrollTo(item);});
 
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
        EmployeeEmailreport.setCellValueFactory(new PropertyValueFactory<reporttype,String>("emp_email"));
        Descreport.setCellValueFactory(new PropertyValueFactory<reporttype,String>("report_des"));

        reporttable.setItems(reportlist);
    }
    @FXML
    void SwitchToReport(MouseEvent event) throws IOException {
        App.setRoot("fxml/TLreport");
    }
    @FXML
    void logOUT(ActionEvent event) throws IOException {
        App.setRoot("fxml/main");
        Account.email = null;
    }

}
