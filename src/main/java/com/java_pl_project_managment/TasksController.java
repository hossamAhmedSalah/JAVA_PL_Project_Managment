package com.java_pl_project_managment;

import com.java_pl_project_managment.util.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TasksController extends Employee implements Initializable {

//    @FXML
//    private Label completeBtn;
//
//    @FXML
//    private TableColumn<?, ?> deadColumn;
//
//    @FXML
//    private TableColumn<?, ?> desColumn;
//
//    @FXML
//    private Label employeeBtn;
//
//    @FXML
//    private TableColumn<?, ?> idColumn;
//
//    @FXML
//    private TableColumn<?, ?> nameColumn;
//
//    @FXML
//    private TableColumn<?, ?> proColumn;
//
//    @FXML
//    private Button remove;
//
//    @FXML
//    private Label reportBtn;
//
//    @FXML
//    private Button submit;
//
//    @FXML
//    private TableColumn<?, ?> taskColumn;
//
//    @FXML
//    private Label tasksBtn;
//
//    @FXML
//    private Label vacationBtn;
@FXML
private Button AssignTask;


    @FXML
    private TableView<emTasks> tlEm;
    @FXML
    private TableColumn<emTasks, String> EmployeeEmail;
    @FXML
    private TableColumn<emTasks, String> projectName;
    @FXML
    private TableColumn<emTasks, String> taskDeadLine;
    @FXML
    private TableColumn<emTasks, String> taskDesc;
    @FXML
    private TableColumn<emTasks, String> taskName;

    @FXML
    private TableColumn<emTasks, String> taskState;

    @FXML
    private Label completeBtn;


    @FXML
    private Label employeeBtn;

    @FXML
    private TextField proNametxt;

    @FXML
    private Button removeTask;

    @FXML
    private Label reportBtn;

    @FXML
    private Button searchButton;
    @FXML
    private TextField EmEmailtxt;
    @FXML
    private TextField taskDesctxt;
    @FXML
    private TextField taskNametxt;

    @FXML
    private TextField taskSearchBar;

    @FXML
    private Label tasksBtn;

    @FXML
    private Button updateTask;

    @FXML
    private Label vacationBtn;

    @FXML
    private Label welcomLable;
    ObservableList<emTasks> olist = FXCollections.observableArrayList();
    private void load() throws SQLException{
        rs = statement.executeQuery("select * from tasks");
        String[] data = {"Not Started","Completed","In progress"};
        while(rs.next()){
            olist.add(new emTasks(
                    rs.getString("task_name"),
                    rs.getString("task_desc"),
                    rs.getString("pro_name"),
                    rs.getString("em_email"),
                    data[rs.getInt("task_state")]


            ));
        }
    }

    public TasksController() throws SQLException {
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
            load();
        }
        catch(Exception ignored){

        }
        taskName.setCellValueFactory(new PropertyValueFactory<emTasks,String>("task_name"));
        taskDesc.setCellValueFactory(new PropertyValueFactory<emTasks,String>("task_desc"));
        taskState.setCellValueFactory(new PropertyValueFactory<emTasks,String>("task_state"));
        projectName.setCellValueFactory(new PropertyValueFactory<emTasks,String>("pro_name"));
        EmployeeEmail.setCellValueFactory(new PropertyValueFactory<emTasks,String>("em_email"));

       tlEm.setItems(olist);

    }
}
