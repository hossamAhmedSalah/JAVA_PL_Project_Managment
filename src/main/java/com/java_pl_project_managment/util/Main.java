package com.java_pl_project_managment.util;

import java.sql.*;

public class Main{
    public static void main(String[] args) throws SQLException{
        User a1 = new User("t@g.com","69");
        System.out.println(a1.toString());
        Employee e = new Employee(a1);
        System.out.println(e.TL_name);
    }    
}
