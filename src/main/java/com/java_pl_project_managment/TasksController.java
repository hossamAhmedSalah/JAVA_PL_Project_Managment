package com.java_pl_project_managment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class TasksController {

    @FXML
    private Label completeBtn;

    @FXML
    private TableColumn<?, ?> deadColumn;

    @FXML
    private TableColumn<?, ?> desColumn;

    @FXML
    private Label employeeBtn;

    @FXML
    private TableColumn<?, ?> idColumn;

    @FXML
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> proColumn;

    @FXML
    private Button remove;

    @FXML
    private Label reportBtn;

    @FXML
    private Button submit;

    @FXML
    private TableColumn<?, ?> taskColumn;

    @FXML
    private Label tasksBtn;

    @FXML
    private Label vacationBtn;

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

}
