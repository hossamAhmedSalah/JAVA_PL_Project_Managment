package com.java_pl_project_managment;

import javafx.fxml.FXML;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;

public class VacationController {
    @FXML
    public void SwitchToVacation(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        App.setRoot("fxml/TLVacation");
    }
    @FXML
    public void SwitchToPenalty(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        App.setRoot("fxml/TLPenalty");
    }
}
