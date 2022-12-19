package com.java_pl_project_managment;

import com.java_pl_project_managment.util.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
public class adminController extends Admin implements Initializable{

    public adminController() throws SQLException {
    }

    @FXML
    private TableView<project> pro_table;
    @FXML
    private TableColumn<project, String> Pro_name;
    @FXML
    private TableColumn<project, String> Pro_desc; 
    @FXML
    private TableColumn<project, String> Deadline;
    @FXML 
    private TableColumn<project, String> Status; 
    @FXML
    private TableColumn<project, String> Pm;
    @FXML 
    private TableColumn<project, String> Tl;

    @FXML
    private Button goToResult;
    @FXML
    private TextField searchBar;

    Alert a = new Alert(AlertType.NONE);

    ObservableList<project> obs = FXCollections.observableArrayList();

    private void load() throws SQLException{
        String[][] kek = Admin.projects;
        for(int i=0;i<kek.length;i++){
            obs.add(new project(kek[i][0],kek[i][1],kek[i][2],kek[i][3],kek[i][4],kek[i][5]));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            load();
        }
        catch(Exception e){
            System.out.println("kolo msh tmam");
        }
        Pro_name.setCellValueFactory(new PropertyValueFactory<project,String>("pro_name"));
        Pro_desc.setCellValueFactory(new PropertyValueFactory<project,String>("pro_desc"));
        Deadline.setCellValueFactory(new PropertyValueFactory<project,String>("deadline"));
        Status.setCellValueFactory(new PropertyValueFactory<project,String>("status"));
        Pm.setCellValueFactory(new PropertyValueFactory<project,String>("pm"));
        Tl.setCellValueFactory(new PropertyValueFactory<project,String>("tl"));

        pro_table.setItems(obs);
    }

    @FXML
    private void viewP(MouseEvent event) throws IOException{
        // App.setRoot("fxml/admin");
    }
    @FXML
    private void addU(MouseEvent event) throws IOException{
        App.setRoot("fxml/modifyUsers");
    }

    @FXML
    private void search(ActionEvent event){
        String proname = searchBar.getText();
        if(!pro_table.getItems().stream().anyMatch(item-> item.getPro_name().toLowerCase().equals(proname.toLowerCase()))){
            a.setAlertType(AlertType.ERROR);
            a.setContentText(proname + " not found");
            a.setHeaderText("");
            a.showAndWait();
            return;
        }

        pro_table.getItems().stream().filter(item-> Objects.equals(item.getPro_name().toLowerCase(), proname.toLowerCase())).findAny().ifPresent(item -> {pro_table.getSelectionModel().select(item);pro_table.scrollTo(item);});
    }

    @FXML
    private void logOut(ActionEvent event){
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
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}