package com.java_pl_project_managment;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class project{

    private SimpleStringProperty pro_name; 
    private SimpleStringProperty pro_desc; 
    private SimpleStringProperty deadline; 
    private SimpleStringProperty status; 
    private SimpleStringProperty pm; 
    private SimpleStringProperty tl;

    public project(String pro_name, String pro_desc, String deadline, String status, String pm, String tl){
        this.pro_name = new SimpleStringProperty(pro_name);
        this.pro_desc = new SimpleStringProperty(pro_desc);
        this.deadline = new SimpleStringProperty(deadline);
        this.status = new SimpleStringProperty(status);
        this.pm = new SimpleStringProperty(pm);
        this.tl = new SimpleStringProperty(tl);
    }

    public String getPro_name() {
        return pro_name.get();
    }
    public String getPro_desc() {
        return pro_desc.get();
    }
    public String getDeadline() {
        return deadline.get();
    }
    public String getStatus() {
        return status.get();
    }
    public String getPm() {
        return pm.get();
    }
    public String getTl() {
        return tl.get();
    }

    public void setPro_name(String pro_name) {
        this.pro_name.set(pro_name);
    }
    public void setPro_desc(String pro_desc) {
        this.pro_desc.set(pro_desc);
    }
    public void setDeadline(String deadline) {
        this.deadline.set(deadline);
    }
    public void setStatus(String status) {
        this.status.set(status);
    }
    public void setPm(String pm) {
        this.pm.set(pm);
    }
    public void setTl(String tl) {
        this.tl.set(tl);
    }

    public StringProperty pro_nameProperty() {
        return pro_name;
    }
    public StringProperty pro_descProperty() {
        return pro_desc;
    }
    public StringProperty deadlineProperty() {
        return deadline;
    }
    public StringProperty statusProperty() {
        return status;
    }
    public StringProperty pmProperty() {
        return pm;
    }
    public StringProperty tlProperty() {
        return tl;
    }
}
