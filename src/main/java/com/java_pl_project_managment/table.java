package com.java_pl_project_managment;


import com.java_pl_project_managment.util.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import com.java_pl_project_managment.util.Employee;

public class table extends Employee implements Initializable {
    
    public table() throws SQLException {
    }

    @FXML
    private TableView<projectH> pro_table;

    @FXML
    private TableColumn<projectH, String> colDeadLine;

    @FXML
    private TableColumn<projectH, String> colDesc;

    @FXML
    private TableColumn<projectH, String> colPm;

    @FXML
    private TableColumn<projectH, String> colProName;

    @FXML
    private TableColumn<projectH, Double> colProgress;

    @FXML
    private TableColumn<projectH, String> colSate;

    @FXML
    private TableColumn<projectH, String> colTl;
    @FXML
    private Button sendReport;
    @FXML
    private Button createProject;

    @FXML
    private DatePicker dateDeadLine;

    @FXML
    private Button refreshButton;

    @FXML
    private TextField textDesc;

    @FXML
    private TextField textPmEmail;

    @FXML
    private TextField textProName;

    @FXML
    private TextField textTlEmail;
    @FXML
    private Label pmEmailID;
    @FXML
    private Label pmNameID;
    @FXML
    private TextField textProgress;

    @FXML
    private TextField textState;
    @FXML
    private Button DeleteProject;
    @FXML
    private TextField searchBar;
    @FXML
    private Button goToResult;


    ObservableList<projectH> list = FXCollections.observableArrayList();


    private void load() throws SQLException{
        rs = statement.executeQuery("select * from project");
        while(rs.next()){
            list.add(new projectH(rs.getString("deadline"),
            rs.getString("pro_desc"),
            rs.getString("pm_email"),
            rs.getString("pm_email"),
            rs.getString("pro_name"),
            rs.getString("pro_state"),
            rs.getDouble("comp_percent")));
        }
    }

    // new projectH("2022-12-20", "project managment system", "Hossam@gmail.com","Hossam_tl@gmail.com", "PL2", "in_progress", 60.0),
    // new projectH("2022-12-22", "project Super market system", "sellEvery@gmail.com","sellEvery_tl@gmail.com", "stera", "not Started", 0.0),
    // new projectH("2022-12-20", "project xv ship", "Hossam@gmail.com","Hossam_tl@gmail.com", "max", "in_progress", 60.0),
    // new projectH("2022-12-30", "project Super market system", "sellEvery@gmail.com","sellEvery_tl@gmail.com", "daxiy", "not Started", 0.0),
    // new projectH("2023-1-8", "project hyper system", "Hossam@gmail.com","Hossam_tl@gmail.com", "haxi", "in_progress", 60.0)


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pmEmailID.setText(Employee.email);
        pmNameID.setText(Employee.username);
        try{
            load();
        }
        catch(Exception e){
            System.out.println("مشكلللللللله");
        }
        colProName.setCellValueFactory(new PropertyValueFactory<projectH, String>("proName" ));
        colDeadLine.setCellValueFactory(new PropertyValueFactory<projectH, String>("date"));
        colDesc.setCellValueFactory(new PropertyValueFactory<projectH, String>("description"));
        colPm.setCellValueFactory(new  PropertyValueFactory<projectH, String>("pmEmail"));
        colTl.setCellValueFactory(new PropertyValueFactory<projectH, String>("tlEmail"));
        colSate.setCellValueFactory(new PropertyValueFactory<projectH, String>("state"));
        colProgress.setCellValueFactory(new PropertyValueFactory<projectH, Double>("progress"));
        pro_table.setItems(list);
    }
    public void createProject(ActionEvent event){
        Alert b = new Alert(Alert.AlertType.WARNING);
        b.setTitle("progress should be a number");

        String projectName, DeadLine, Description, tl_Email, pm_Email, stateX;
        double progress, state = 0;
        projectName = textProName.getText() ;
        DeadLine = String.valueOf(dateDeadLine.getValue());
        Description = textDesc.getText();
        tl_Email = textTlEmail.getText();
        pm_Email = textPmEmail.getText();
        stateX =  textState.getText();//Double.parseDouble(textState.getText());
        try {
            progress = Double.parseDouble(textProgress.getText());
        } catch (NumberFormatException e) {
            b.show();
            throw new RuntimeException(e);
        }



        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Can't create");

        if(projectName.equals("") || DeadLine.equals("") || Description.equals("") || tl_Email.equals("") || pm_Email.equals("") || textProgress.getText().equals("")|| stateX.equals("")){
            a.setContentText("fill all fields please");
            a.show();
        }
        else if(isProNameExist(projectName)){
            a.setContentText("This project already exist");
            a.show();
        }
        else {
            projectH pro = new projectH(DeadLine, Description, pm_Email, tl_Email, projectName, (Double.parseDouble(stateX)+""), progress);
            System.out.printf("project name : %s\tDeadLine : %s\tDescription: %s\ttl_Email : %s\tpm_Email : %s",projectName, DeadLine, Description, tl_Email, pm_Email);
            ObservableList<projectH> addProjectH = pro_table.getItems();
            addProjectH.add(pro);


            try {
                query("insert into project values('"+ projectName+"', '"+
                                                         Description+ "', '"+
                                                         DeadLine + "' ,"+
                                                         Double.parseDouble(stateX)+", "+
                                                         progress+", '"+
                                                         pm_Email+"' ,'"+
                                                         tl_Email+"')"  );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            pro_table.setItems(addProjectH);
            dateDeadLine.setValue(null);
            textDesc.setText("");
            textProName.setText("");
            textTlEmail.setText("");
            textState.setText("");
            textProgress.setText("");
            textPmEmail.setText(pmEmailID.getText());

        }





    }

    private boolean isProNameExist(String projectName) {
        pro_table.getItems().stream().filter(item-> Objects.equals(item.getProName(), projectName)).findAny().ifPresent(item->{pro_table.getSelectionModel().select(item); pro_table.scrollTo(item);});

        return pro_table.getItems().stream().anyMatch(item-> item.getProName().toLowerCase().equals(projectName.toLowerCase()));

    }

    @FXML
    void deleteProjrct(ActionEvent event) {
        Alert x = new Alert(Alert.AlertType.WARNING);
        if (!pro_table.getSelectionModel().isEmpty()){
            int id = pro_table.getSelectionModel().getSelectedIndex();
            // saving the name of thr deleted project to use later in db deletion
            String pro_name_d = pro_table.getItems().get(id).getProName();
            System.out.println(pro_name_d+" have been deleted");

            pro_table.getItems().remove(id);
            try {
                query("delete from project where pro_name = '"+pro_name_d+"'" );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
        else {
            x.setTitle("there is no projects to delete");
            x.show();
        }

    }
    @FXML
    void search(ActionEvent event) {
        Alert m = new Alert(Alert.AlertType.WARNING);

        m.setTitle("Search failed");

        String keyWord = searchBar.getText();
        if(isProNameExist(keyWord)){
            pro_table.getItems().stream().filter(item-> Objects.equals(item.getProName().toLowerCase(), keyWord.toLowerCase())).findAny().ifPresent(item->{pro_table.getSelectionModel().select(item); pro_table.scrollTo(item);});

        }
        else {

            m.setHeaderText("This project doesn't exist");
            m.show();
        }

    }
    @FXML
    void goToResult(ActionEvent event) {

    }
    @FXML
    void refreshTable(ActionEvent event) {
       // pro_table.refresh();
        try {
            App.setRoot("fxml/ProjectsPM");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    public void SwitchToDsashboard(ActionEvent event) throws IOException{
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

}