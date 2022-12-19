package com.java_pl_project_managment;

import javafx.beans.property.SimpleStringProperty;

public class emTasks {
    private SimpleStringProperty task_name;
    private SimpleStringProperty task_desc;
    private SimpleStringProperty pro_name;
    private SimpleStringProperty em_email;
    private SimpleStringProperty state;

    public emTasks(String task_name, String task_desc,String pro_name,  String em_email, String state) {
        this.pro_name = new SimpleStringProperty(pro_name);
        this.task_desc = new SimpleStringProperty(task_desc);
        this.task_name = new SimpleStringProperty(task_name);
        this.state = new SimpleStringProperty(state);
        this.em_email = new SimpleStringProperty(em_email);
    }



    public String getState() {
        return state.get();
    }

    public SimpleStringProperty stateProperty() {
        return state;
    }

    public void setState(String state) {
        this.state.set(state);
    }


    public String getTask_name() {
        return task_name.get();
    }

    public SimpleStringProperty task_nameProperty() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name.set(task_name);
    }

    public String getTask_desc() {
        return task_desc.get();
    }

    public SimpleStringProperty task_descProperty() {
        return task_desc;
    }

    public void setTask_desc(String task_desc) {
        this.task_desc.set(task_desc);
    }

    public String getPro_name() {
        return pro_name.get();
    }

    public SimpleStringProperty pro_nameProperty() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name.set(pro_name);
    }


    public String getEm_email() {
        return em_email.get();
    }

    public SimpleStringProperty em_emailProperty() {
        return em_email;
    }

    public void setEm_email(String em_email) {
        this.em_email.set(em_email);
    }
}
