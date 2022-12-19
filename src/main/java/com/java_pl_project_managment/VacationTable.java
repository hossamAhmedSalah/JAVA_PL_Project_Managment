package com.java_pl_project_managment;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class VacationTable {
    private String em_email;
    private int v_id;
    private String StartDate;
    private String EndDate;
    private String VacationState;

    public VacationTable(String em_email,int v_id,String StartDate,String EndDate,String VacationState){
        this.em_email = em_email;
        this.EndDate = EndDate;
        this.VacationState = VacationState;
        this.v_id = v_id;
        this.StartDate = StartDate;

    }

    public String getEm_email() {
        return em_email;
    }

    public int getV_id() {
        return v_id;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public String getVacationState() {
        return VacationState;
    }

    public void setEm_email(String em_email) {
        this.em_email = em_email;
    }

    public void setV_id(int v_id) {
        this.v_id = v_id;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public void setVacationState(String vacationState) {
        VacationState = vacationState;
    }
}

