package com.java_pl_project_managment.util;

import java.sql.*;

public class Admin extends Account{
    protected String email;
    public String username;
    public String role;
    public Admin(Account u) throws SQLException{
        this.email = u.email;
        this.username = u.username;
        this.role = u.role;
    }

    public boolean add(String[] data) throws SQLException{
        String str1 = "insert into Account values('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"'"+")";
        try{
            statement.execute(str1);
        }
        catch(Exception e){
            System.out.println("key found cant insert");
            return false;
        }

        String str2 = "insert into "+ data[4] + " values('"+data[0];
        if(data[4].toLowerCase().equals("EM"))
            str2 += "','"+data[8]+"')";
        else str2 += "')";
        statement.execute(str2);
        return true;
    }

    public boolean delete(String ed) throws SQLException{
        String strole = "delete from "+ role +" where "+ role +"_email= '"+ed+"'";
        String str = "delete from account where email= '"+ed+"'";
        try{
            statement.execute(strole);
        }
        catch (Exception e){
            return false;
        }
        statement.execute(str);
        return true;
    }

}
