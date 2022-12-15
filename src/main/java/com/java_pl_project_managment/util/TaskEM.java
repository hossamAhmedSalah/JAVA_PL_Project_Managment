package com.java_pl_project_managment.util;

import java.sql.SQLException;

public interface TaskEM {
    public String[][] viewEmployeeTasks(String email) throws SQLException;
    public void finishTask(String TaskName) throws SQLException;
    public void pendingTask (String TaskName) throws SQLException;
}

