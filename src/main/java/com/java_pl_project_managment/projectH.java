package com.java_pl_project_managment;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class projectH {
    // I would show the Date as a String
    private SimpleStringProperty date;
    private SimpleStringProperty description;
    private SimpleStringProperty pmEmail;
    private SimpleStringProperty tlEmail;
    private SimpleStringProperty proName;
    private SimpleStringProperty state;
    private SimpleDoubleProperty progress;

    public projectH(String date, String description, String pmEmail, String tlEmail, String proName, String state, double progress) {
        this.date = new SimpleStringProperty(date);
        this.description = new SimpleStringProperty(description);
        this.pmEmail = new SimpleStringProperty(pmEmail);
        this.tlEmail = new SimpleStringProperty(tlEmail);
        this.proName = new SimpleStringProperty(proName);
        this.state = new SimpleStringProperty(state);
        this.progress = new SimpleDoubleProperty(progress);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getPmEmail() {
        return pmEmail.get();
    }

    public void setPmEmail(String pmEmail) {
        this.pmEmail.set(pmEmail);
    }

    public String getTlEmail() {
        return tlEmail.get();
    }

    public void setTlEmail(String tlEmail) {
        this.tlEmail.set(tlEmail);
    }

    public String getProName() {
        return proName.get();
    }

    public void setProName(String proName) {
        this.proName.set(proName);
    }

    public String getState() {
        return state.get();
    }

    public void setState(String state) {
        this.state.set(state);
    }

    public double getProgress() {
        return progress.get();
    }

    public void setProgress(Double progress) {
        this.progress.set(progress);
    }

    public StringProperty dateProperty() {
        return date;
    }
    public StringProperty descriptionProperty() {
        return description;
    }
    public StringProperty pmEmailProperty() {
        return pmEmail;
    }
    public StringProperty tlEmailProperty() {
        return tlEmail;
    }
    public StringProperty proNameProperty() {
        return proName;
    }
    public StringProperty stateProperty() {
        return state;
    }
    public DoubleProperty progressProperty() {
        return progress;
    }
    
}