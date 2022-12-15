package com.java_pl_project_managment;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

private static Scene scene;
@FXML
BarChart<String , Number> chart;

    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("fxml/dashboard"));
       // scene.getStylesheets().add(getClass().getResource("style/app.css").toExternalForm());
        stage.setTitle("Project Managment System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch();
    }
}