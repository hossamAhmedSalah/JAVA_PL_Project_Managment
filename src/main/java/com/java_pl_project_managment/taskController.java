package com.java_pl_project_managment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class taskController extends tasks implements Initializable{

    public taskController() throws SQLException {
    }

    @FXML
    private TableView<tasks> task_name;
    @FXML
    private TableColumn<tasks, String> Pro_name;
    @FXML
    private TableColumn<tasks, String> task_desc;
    @FXML
    private TableColumn<tasks, String> task_state;
    @FXML
    private TableColumn<tasks, String> tl_email;
    private TableView<tasks> tasksTableView ;
    ObservableList<tasks> obs = FXCollections.observableArrayList();

    private void load() throws SQLException{
        String[][] array = super.Employee;
        for(int i = 0 ; i < array.length ;i++){
            obs.add(new tasks(array[i][0], array[i][1], array[i][2], array[i][3], array[i][4]));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            load();
        }
        catch(Exception e){

        }
        Pro_name.setCellValueFactory(new PropertyValueFactory<tasks,String>("pro_name"));
        task_desc.setCellValueFactory(new PropertyValueFactory<tasks,String>("task_desc"));
        // task_name.setCellValueFactory(new PropertyValueFactory<tasks,String>("task_name"));
        task_state.setCellValueFactory(new PropertyValueFactory<tasks,String>("task_state"));
        tl_email.setCellValueFactory(new PropertyValueFactory<tasks,String>("tl"));

        tasksTableView.setItems(obs);
    }


   
    }
