package com.java_pl_project_managment.util;

import java.sql.SQLException;

public class project extends Admin{

    private String pro_name; 
    private String pro_desc; 
    private String deadline; 
    private String status; 
    private String pm; 
    private String tl;

    public project(int n) throws SQLException {
        pro_name = Admin.projects[n][0];
        pro_desc = Admin.projects[n][1];
        deadline = Admin.projects[n][2];
        status = Admin.projects[n][3]; 
        pm = Admin.projects[n][4];
        tl = Admin.projects[n][5];
    }
}
