package com.java_pl_project_managment.util.DB;

import java.util.*;
import com.java_pl_project_managment.util.User;
import java.sql.*;

public class test {
    public static void main(String[] args) throws SQLException{
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter login credentials...");
        System.out.print("Email: ");
        String email = in.next();
        System.out.print("Password: ");
        String pass = in.next();

        User a1 = new User(email,pass);
        System.out.println(a1.toString());

        in.close();
    }
}