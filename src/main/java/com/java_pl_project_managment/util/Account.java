package com.java_pl_project_managment.util;

import com.java_pl_project_managment.util.DB.SQLConnection;
import java.sql.*;

public class Account extends SQLConnection{
    protected static String email;
    private static String password;
    protected static String username;
    protected static String role;
    protected static String gender;
    protected static String imgUrl;
    protected static double salary;

    public Account() throws SQLException{
    }

    public boolean Login(String e,String p) throws SQLException{
        rs = statement.executeQuery("select * from Account where email = '" + e + "' and password = '" + p + "'");
        while(rs.next()){
            username = rs.getString("username");
            email = rs.getString("email");
            password = rs.getString("password");
            role = rs.getString("role");
            gender = rs.getString("gender");
            imgUrl = rs.getString("imgurl");
            salary = rs.getDouble("salary");
            break;
        }
        return (username!=null);
    }

    public String toString(){
        return "\nName: " + username + "\nEmail: " + email + "\nRole: " + role + "\n";
    }
}