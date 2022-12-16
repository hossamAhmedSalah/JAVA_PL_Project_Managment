package com.java_pl_project_managment;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class PenaltyTableFill {
    private SimpleStringProperty DescriptionCol;
    private SimpleDoubleProperty PenaltyCol;
    private SimpleStringProperty EmployeeIdCol;

    public PenaltyTableFill(String Description,Double amount,String employee_em){
        this.DescriptionCol = new SimpleStringProperty(Description);
        this.PenaltyCol = new SimpleDoubleProperty(amount);
        this.EmployeeIdCol = new SimpleStringProperty(employee_em);
    }

    public void setDescriptionCol(String descriptionCol) {
        this.DescriptionCol.set(descriptionCol);
    }

    public void setPenaltyCol(double penaltyCol) {
        this.PenaltyCol.set(penaltyCol);
    }

    public void setEmployeeIdCol(String employeeIdCol) {
        this.EmployeeIdCol.set(employeeIdCol);
    }

    public String getDescriptionCol() {
        return DescriptionCol.get();
    }

    public SimpleStringProperty descriptionColProperty() {
        return DescriptionCol;
    }

    public double getPenaltyCol() {
        return PenaltyCol.get();
    }

    public SimpleDoubleProperty penaltyColProperty() {
        return PenaltyCol;
    }

    public String getEmployeeIdCol() {
        return EmployeeIdCol.get();
    }

    public SimpleStringProperty employeeIdColProperty() {
        return EmployeeIdCol;
    }
}
