package com.java_pl_project_managment;

import com.java_pl_project_managment.util.*;

import java.sql.SQLException;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
// implements Initializable
public class adminController extends Admin {
    private ObservableList<project> idk;
    
    TableView<ObservableList<String>> pro_table = createTableView(Admin.projects);

    public adminController() throws SQLException {
    }

    private TableView<ObservableList<String>> createTableView(String[][] projects) {
        TableView<ObservableList<String>> tableView = new TableView<>();
        tableView.setItems((ObservableList<ObservableList<String>>) buildData(projects));
 
        for (int i = 0; i < projects[0].length; i++) {
            final int curCol = i;
            final TableColumn<ObservableList<String>, String> column = new TableColumn<>(
                    "Col " + (curCol + 1)
            );
            column.setCellValueFactory(
                    param -> new ReadOnlyObjectWrapper<>(param.getValue().get(curCol))
            );
            tableView.getColumns().add(column);
        }
 
        return tableView;
    }

    private TableView<ObservableList<String>> buildData(String[][] projects) {
        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
 
        for (String[] row : projects) {
            data.add(FXCollections.observableArrayList(row));
        }
 
        return (TableView<ObservableList<String>>) data;
    }

    
    
    // @FXML
    // private TableView<project> pro_table;

    // @FXML 
    // private TableColumn<project, String> pro_name;
    // @FXML 
    // private TableColumn<project, String> pro_desc;
    // @FXML 
    // private TableColumn<project, String> deadline;
    // @FXML 
    // private TableColumn<project, String> status;
    // @FXML 
    // private TableColumn<project, String> pm;
    // @FXML 
    // private TableColumn<project, String> tl;

    // Admin a = new Admin();    

    

    // @Override
    // public void initialize(URL location, ResourceBundle resources) {

    //     pro_name.setCellValueFactory(new PropertyValueFactory<project,String>("pro_name"));
    //     pro_desc.setCellValueFactory(new PropertyValueFactory<project,String>("pro_desc"));
    //     deadline.setCellValueFactory(new PropertyValueFactory<project,String>("deadline"));
    //     status.setCellValueFactory(new PropertyValueFactory<project,String>("status"));
    //     pm.setCellValueFactory(new PropertyValueFactory<project,String>("pm"));
    //     tl.setCellValueFactory(new PropertyValueFactory<project,String  >("tl"));

    //     try{
    //         data();
    //     }
    //     catch(SQLException e){
    //         System.out.println("خخخخخخخخخخخخخ");
    //     }
    // }

    // public void data() throws SQLException{
    //     idk = FXCollections.observableArrayList();
    //     for(int i=0;i<Admin.projects.length;i++){
    //         idk.add(new project(i));    
    //     }
    //     pro_table.setItems(idk);
    // }
}

//hamid_ad@gmail.com