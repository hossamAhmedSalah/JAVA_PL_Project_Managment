package com.java_pl_project_managment;

import com.java_pl_project_managment.util.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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

    ObservableList<project> obs = FXCollections.observableArrayList();

    private void load() throws SQLException{
        Admin a = new Admin();
        a.view_project();
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
            System.out.println("خخخخخخخخخخخخخخ");
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
        App.setRoot("fxml/admin");
    }
    @FXML
    private void addU(MouseEvent event) throws IOException{
        App.setRoot("fxml/addUser");
    }
    @FXML
    private void deleteU(MouseEvent event) throws IOException{
        App.setRoot("fxml/deleteUser");
    }
    @FXML
    private void updateU(MouseEvent event) throws IOException{
        App.setRoot("fxml/updateUser");
    }

}