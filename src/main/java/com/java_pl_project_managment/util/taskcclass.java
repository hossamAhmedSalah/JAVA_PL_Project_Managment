package com.java_pl_project_managment.util;

import javafx.beans.property.SimpleStringProperty;

public class taskcclass {
    private SimpleStringProperty Description;
    private SimpleStringProperty Task_Name;
    private SimpleStringProperty dead_line;
    private SimpleStringProperty Employee_ID;
    private SimpleStringProperty Project_ID;
    private SimpleStringProperty taskColumn;

    public taskcclass(String Description,String Task_Name,String dead_line,String Employee_ID,String Project_ID){
        this.dead_line = new SimpleStringProperty(dead_line);
        this.Description = new SimpleStringProperty(Description);
        this.Task_Name = new SimpleStringProperty(Task_Name);
        this.Employee_ID = new SimpleStringProperty(Employee_ID);
        this.Project_ID = new SimpleStringProperty(Project_ID);
    }

    public String getDescription() {
        return Description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return Description;
    }

    public String getTask_Name() {
        return Task_Name.get();
    }

    public SimpleStringProperty task_NameProperty() {
        return Task_Name;
    }

    public String getDead_line() {
        return dead_line.get();
    }

    public SimpleStringProperty dead_lineProperty() {
        return dead_line;
    }

    public String getEmployee_ID() {
        return Employee_ID.get();
    }

    public SimpleStringProperty employee_IDProperty() {
        return Employee_ID;
    }

    public String getProject_ID() {
        return Project_ID.get();
    }

    public SimpleStringProperty project_IDProperty() {
        return Project_ID;
    }

    public String getTaskColumn() {
        return taskColumn.get();
    }

    public SimpleStringProperty taskColumnProperty() {
        return taskColumn;
    }

    public void setDescription(String description) {
        this.Description.set(description);
    }

    public void setTask_Name(String task_Name) {
        this.Task_Name.set(task_Name);
    }

    public void setDead_line(String dead_line) {
        this.dead_line.set(dead_line);
    }

    public void setEmployee_ID(String employee_ID) {
        this.Employee_ID.set(employee_ID);
    }

    public void setProject_ID(String project_ID) {
        this.Project_ID.set(project_ID);
    }

    public void setTaskColumn(String taskColumn) {
        this.taskColumn.set(taskColumn);
    }
}
