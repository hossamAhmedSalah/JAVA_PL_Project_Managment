package com.java_pl_project_managment;

import javafx.beans.property.SimpleStringProperty;

public class tasks {

    private SimpleStringProperty task_name;
    private SimpleStringProperty task_desc;
    private SimpleStringProperty task_state;
    private SimpleStringProperty pro_name;
    private SimpleStringProperty tl_email;
    private SimpleStringProperty em_email;

    public tasks(){
    }

    public tasks(String task_name, String task_desc, String task_state, String pro_name, String tl_email ,String em_email){
        this.pro_name = new SimpleStringProperty(pro_name);
        this.task_desc = new SimpleStringProperty(task_desc);
        this.task_name = new SimpleStringProperty(task_name);
        this.tl_email = new SimpleStringProperty(tl_email);
        this.task_state = new SimpleStringProperty(task_state);
        this.em_email = new SimpleStringProperty(em_email);
    }


    public String getTask_name() {
        return task_name.get();
    }

    public String getTl_email() {
        return tl_email.get();
    }

    public String getEm_email() {
        return em_email.get();
    }

    public String getPro_name() {
        return pro_name.get();
    }

    public String getTask_state() {
        return task_state.get();
    }

    public String getTask_desc() {
        return task_desc.get();
    }

    public void setTask_name(String task_name) {
        this.task_name.set(task_name);
    }

    public void setTask_state(String task_state) {
        this.task_state.set(task_state);
    }

    public void setTask_desc(String task_desc) {
        this.task_desc.set(task_desc);
    }

    public void setPro_name(String pro_name) {
        this.pro_name.set(pro_name);
    }

    public void setTl_email(String tl_email) {
        this.tl_email.set(tl_email);
    }

    public void setEm_email(String em_email) {
        this.em_email.set(em_email);
    }

    public SimpleStringProperty task_nameProperty() {
        return task_name;
    }

    public SimpleStringProperty task_descProperty() {
        return task_desc;
    }

    public SimpleStringProperty task_stateProperty() {
        return task_state ;
    }

    public SimpleStringProperty pro_nameProperty() {
        return pro_name;
    }

    public SimpleStringProperty tl_emailProperty() {
        return tl_email;
    }

    public SimpleStringProperty em_emailProperty() {
        return em_email;
    }

}
