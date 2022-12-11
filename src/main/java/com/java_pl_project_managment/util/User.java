package com.java_pl_project_managment.util;

import com.java_pl_project_managment.util.DB.SQLConnection;
import java.sql.*;
import java.util.Scanner;


public class User extends SQLConnection{
    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected String type;

    public User() throws SQLException{
    }

    public User(String e, String p) throws SQLException{
        Scanner in = new Scanner(System.in);
        this.email = e;
        this.password = p;
        
        while(!Login(email,password)){
            System.out.println("Wrong email or password!!");
            System.out.print("Re-enter Email: ");
            this.email = in.next();
            System.out.print("Re-enter Password: ");
            this.password = in.next();
        }

        in.close();
    }

    private boolean Login(String e,String p) throws SQLException{
        rs = statement.executeQuery("select * from Account where email = '" + e + "' and password = '" + p + "'");
        while(rs.next()){
            this.id = rs.getInt("id");
            this.name = rs.getString("name");
            this.email = rs.getString("email");
            this.password = rs.getString("password");
            this.type = rs.getString("type");
            break;
        }
        return (this.name!=null);
    }

    public String toString(){
        return "\nName: " + name + "\nEmail: " + email + "\nRole: " + type + "\n";
    }
}