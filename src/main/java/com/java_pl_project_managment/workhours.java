package com.java_pl_project_managment;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class workhours {
    private SimpleStringProperty date;
    private SimpleStringProperty hours;

    public workhours(String date, String hours) {
        this.date = new SimpleStringProperty(date);
        this.hours = new SimpleStringProperty(hours);
    }

    public String gethours() {
        return hours.get();
    }

    public String getdate() {
        return date.get();
    }

    public void sethours(String hours){
        this.hours.set(hours);
    }
    public void setdate(String date){
        this.hours.set(date);
    }

    public StringProperty dateProperty() {
        return date;
    }

    public StringProperty hoursProperty() {
        return hours;
    }


}
