package com.java_pl_project_managment.util;

import com.java_pl_project_managment.util.DB.SQLConnection;
import java.sql.*;


public class Account extends SQLConnection{
    protected String email;
    private String password;
    public String username;
    public String role;
    public String gender;
    public String imgUrl;
    public double salary;

    public Account() throws SQLException{
    }

    public boolean Login(String e,String p) throws SQLException{
        rs = statement.executeQuery("select * from Account where email = '" + e + "' and password = '" + p + "'");
        while(rs.next()){
            this.username = rs.getString("username");
            this.email = rs.getString("email");
            this.password = rs.getString("password");
            this.role = rs.getString("role");
            this.gender = rs.getString("gender");
            this.imgUrl = rs.getString("imgurl");
            this.salary = rs.getDouble("salary");
            break;
        }
        return (this.username!=null);
    }

    public String toString(){
        return "\nName: " + username + "\nEmail: " + email + "\nRole: " + role + "\n";
    }

}