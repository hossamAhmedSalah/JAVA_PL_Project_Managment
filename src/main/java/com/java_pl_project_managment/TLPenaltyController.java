package com.java_pl_project_managment;

import com.java_pl_project_managment.util.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class TLPenaltyController extends Employee implements Initializable {

    @FXML
    private Label completeBtn;

    @FXML
    private Label employeeBtn;
    @FXML
    private TextField searchBar_penalty;

    @FXML
    private Label reportBtn;

    @FXML
    private TextField search;

    @FXML
    private Label tasksBtn;

    @FXML
    private Label vacationBtn;


    @FXML
    private TableColumn<PenaltyTableFill,String> DescriptionCol;

    @FXML
    private TableColumn<PenaltyTableFill,String > EmployeeIdCol;

    @FXML
    private TableColumn<PenaltyTableFill, Double> PenaltyCol;

    @FXML
    private TableView<PenaltyTableFill> PenaltyTable;

    public TLPenaltyController() throws SQLException {
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

    ObservableList<PenaltyTableFill> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        EmployeeIdCol.setCellValueFactory(new PropertyValueFactory<PenaltyTableFill,String>("EmployeeIdCol"));
        PenaltyCol.setCellValueFactory(new PropertyValueFactory<PenaltyTableFill,Double>("PenaltyCol"));
        DescriptionCol.setCellValueFactory(new PropertyValueFactory<PenaltyTableFill,String>("DescriptionCol"));
        try{
            load();
        }
        catch(Exception e){
            System.out.println("error");
        }
        PenaltyTable.setItems(list);

    }
    private void load() throws SQLException {
        rs = statement.executeQuery("select * from penalties");
        while(rs.next()){
            list.add(new PenaltyTableFill(
                    rs.getString("p_desc"),
                    rs.getDouble("amount"),
                    rs.getString("em_email")
            ));
        }
    }

    @FXML
    void MakeAsearch(ActionEvent event) {
        String keyWord = searchBar_penalty.getText();
        PenaltyTable.getItems().stream().filter(item-> Objects.equals(item.getEmployeeIdCol().toLowerCase(), keyWord.toLowerCase())).findAny().ifPresent(item->{PenaltyTable.getSelectionModel().select(item); PenaltyTable.scrollTo(item);});

    }
}
