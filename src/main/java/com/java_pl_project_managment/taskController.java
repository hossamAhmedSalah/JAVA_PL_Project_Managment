package com.java_pl_project_managment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.java_pl_project_managment.util.Account;
import com.java_pl_project_managment.util.Employee;

public class taskController extends Employee implements Initializable{

    public taskController() throws SQLException {
    }

    @FXML
    private TableView<tasks> tasksTableView;
    @FXML
    private TableColumn<tasks, String> task_name;
    @FXML
    private TableColumn<tasks, String> pro_name;
    @FXML
    private TableColumn<tasks, String> task_desc;
    @FXML
    private TableColumn<tasks, String> task_state;
    @FXML
    private TableColumn<tasks, String> tl_email;
    @FXML
    private TableColumn<tasks, String> em_email;

    ObservableList<tasks> obs = FXCollections.observableArrayList();

    private void load() throws SQLException{
        rs = statement.executeQuery("select * from tasks");
        String[] data = {"Not Started","Completed","In progress"};
        while(rs.next()){
            obs.add(new tasks(rs.getString("task_name"), rs.getString("task_desc"), data[rs.getInt("task_state")], rs.getString("pro_name"), rs.getString("tl_email"), rs.getString("em_email")));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            load();
        }
        catch(Exception e){

        }
        pro_name.setCellValueFactory(new PropertyValueFactory<tasks,String>("pro_name"));
        task_desc.setCellValueFactory(new PropertyValueFactory<tasks,String>("task_desc"));
        task_name.setCellValueFactory(new PropertyValueFactory<tasks,String>("task_name"));
        task_state.setCellValueFactory(new PropertyValueFactory<tasks,String>("task_state"));
        tl_email.setCellValueFactory(new PropertyValueFactory<tasks,String>("tl_email"));
        em_email.setCellValueFactory(new PropertyValueFactory<tasks,String>("em_email"));

        tasksTableView.setItems(obs);
    }
    @FXML
    public void finishTask(ActionEvent event) throws SQLException,IOException{
        Alert x = new Alert(Alert.AlertType.WARNING);
        if (!tasksTableView.getSelectionModel().isEmpty()){
            int id = tasksTableView.getSelectionModel().getSelectedIndex();
            // saving the name of thr deleted task to use later in db update
            String task_name= tasksTableView.getItems().get(id).getTask_name();
            System.out.println(task_name+" have been finished");

            try {
                query("update tasks set task_state = 1 where task_name = '"+task_name+"'");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            App.setRoot("fxml/task-view1");

        }
        else {
            x.setTitle("there is no tasks to do for now");
            x.show();
        }


    }
    @FXML
    void refreshTask(ActionEvent event) throws IOException {
        App.setRoot("fxml/task-view1");

    }

    public void gotoTasks(ActionEvent event) throws IOException {
        App.setRoot("fxml/task-view1");
    }

    public void switch_to_mdata(ActionEvent event) throws IOException {
        App.setRoot("fxml/monthdata");
    }
    public void switch_to_vacation(ActionEvent event) throws IOException {
        App.setRoot("fxml/vacationEM");
    }
    @FXML
    void logOUT(ActionEvent event) throws IOException {
        App.setRoot("fxml/main");
        Account.email = null;

    }

}
