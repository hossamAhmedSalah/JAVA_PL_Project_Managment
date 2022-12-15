package com.java_pl_project_managment.util.DB;

import java.sql.*;

public class test{
    public static void main(String[] args)  throws SQLException{
        SQLConnection conn = new SQLConnection();
        String[][] meow = conn.table("account");

        for(String[] s: meow){
            for(String ss: s){
                System.out.print(ss+" ");
            }
            System.out.println();
        }
        
    }
}
