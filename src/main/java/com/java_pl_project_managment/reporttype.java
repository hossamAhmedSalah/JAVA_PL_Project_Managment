package com.java_pl_project_managment;

import javafx.beans.property.SimpleStringProperty;

public class reporttype {
    private SimpleStringProperty emp_email;
    private SimpleStringProperty report_des;
    public reporttype(String emp_email ,String report_des){
        this.emp_email = new SimpleStringProperty(emp_email);
        this.report_des = new SimpleStringProperty(report_des);
    }

    public String getEmp_email() {
        return emp_email.get();
    }

    public SimpleStringProperty emp_emailProperty() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email.set(emp_email);
    }

    public String getReport_des() {
        return report_des.get();
    }

    public SimpleStringProperty report_desProperty() {
        return report_des;
    }

    public void setReport_des(String report_des) {
        this.report_des.set(report_des);
    }
}
