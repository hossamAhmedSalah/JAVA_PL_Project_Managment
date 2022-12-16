package com.java_pl_project_managment;

import javafx.fxml.FXML;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;

public class TLPenaltyController {
    @FXML
    public void SwitchToVacation(MouseEvent mouseEvent) throws IOException {
        App.setRoot("fxml/TLVacation");
    }
    @FXML
    public void SwitchToPenalty(MouseEvent mouseEvent) throws IOException {
        App.setRoot("fxml/TLPenalty");
    }
    public void SwitchToAssignTask(MouseEvent mouseEvent) throws IOException {
        App.setRoot("fxml/Tl_Tasks");
    }
}
