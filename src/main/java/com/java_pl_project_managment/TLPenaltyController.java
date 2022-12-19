package com.java_pl_project_managment;

import com.java_pl_project_managment.util.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private TextArea descriptionOfPenalty_TextField;
    @FXML
    private TextField AmountOf;

    @FXML
    private TextField employeeGmail;
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
    private TableColumn<PenaltyTableFill, String> DescriptionCol;

    @FXML
    private TableColumn<PenaltyTableFill, String> EmployeeIdCol;

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

        EmployeeIdCol.setCellValueFactory(new PropertyValueFactory<PenaltyTableFill, String>("EmployeeIdCol"));
        PenaltyCol.setCellValueFactory(new PropertyValueFactory<PenaltyTableFill, Double>("PenaltyCol"));
        DescriptionCol.setCellValueFactory(new PropertyValueFactory<PenaltyTableFill, String>("DescriptionCol"));
        try {
            load();
        } catch (Exception e) {
            System.out.println("error");
        }
        PenaltyTable.setItems(list);

    }

    private void load() throws SQLException {
        rs = statement.executeQuery("select * from penalties");
        while (rs.next()) {
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
        PenaltyTable.getItems().stream().filter(item -> Objects.equals(item.getEmployeeIdCol().toLowerCase(), keyWord.toLowerCase())).findAny().ifPresent(item -> {
            PenaltyTable.getSelectionModel().select(item);
            PenaltyTable.scrollTo(item);
        });
        Alert searchError = new Alert(Alert.AlertType.ERROR);
        if (Objects.equals(searchBar_penalty.getText(), "")) {
            searchError.setTitle("Cannot Search");
            searchError.setContentText("Please Type an email");
            searchError.show();
        }
    }

    @FXML
    void logOUT(ActionEvent event) throws IOException {
        App.setRoot("fxml/main");
    }

    @FXML
    void SetPenalty(ActionEvent event) {

        Alert PenaltyError = new Alert(Alert.AlertType.WARNING);
        PenaltyError.setTitle("Penalty should be a number");

        String EM_email,descriptionOfPenalty;
        double Amount;
        EM_email = employeeGmail.getText();
        descriptionOfPenalty = descriptionOfPenalty_TextField.getText();
        Amount = Double.parseDouble(AmountOf.getText());
        try {

        } catch (NumberFormatException e) {
            PenaltyError.show();
            throw new RuntimeException(e);
        }


        Alert CantAdd = new Alert(Alert.AlertType.WARNING);
        CantAdd.setTitle("Can't create");


        if (employeeGmail.equals("") || descriptionOfPenalty_TextField.equals("")) {
            CantAdd.setContentText("fill all fields please");
            CantAdd.show();

        } else {
            PenaltyTableFill Penalty = new PenaltyTableFill(descriptionOfPenalty,Amount,EM_email);
            ObservableList<PenaltyTableFill> tableFill = PenaltyTable.getItems();
            tableFill.add(Penalty);
            System.out.println("kolo tmam");


            try {
                query("update  penalties set Amount = "+Amount+" where em_email ='"+EM_email+"'");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("kolo tmam1");

            try{
                query("update  penalties set p_desc = '"+descriptionOfPenalty+"' where em_email ='"+EM_email+"'");

            } catch (SQLException e){
                throw  new RuntimeException(e);
            }
            System.out.println("kolo tmam2");

            PenaltyTable.setItems(tableFill);
            employeeGmail.setText("");
            descriptionOfPenalty_TextField.setText("");
            AmountOf.setText("");



        }
    }
    @FXML
    void Refresh(ActionEvent event) throws IOException {
        App.setRoot("fxml/TLPenalty");
    }


}
