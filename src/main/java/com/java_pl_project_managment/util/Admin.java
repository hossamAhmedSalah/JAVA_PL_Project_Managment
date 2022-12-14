package com.java_pl_project_managment.util;

import java.sql.*;

public class Admin extends Account{
    public String[][] projects;

    public Admin() throws SQLException{

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
        if(data[4].toLowerCase().equals("em"))
            str2 += "','"+data[8]+"')";
        else str2 += "')";
        statement.execute(str2);
        return true;
    }

    public boolean delete(String ed) throws SQLException{
        String strole = "delete from "+ Account.role +" where "+ Account.role +"_email= '"+ed+"'";
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

    public boolean update(String[] eu) throws SQLException{
        String[] d = {"email","username","password","gender","imgurl","salary"};
        for(int i=1;i<eu.length;i++){
            if(!eu[i].equals(null)){
                try{
                    statement.execute("update account set "+d[i]+" = "+"'"+eu[i]+"' where email= "+"'"+eu[0]+"';");
                }
                catch(Exception e){
                    return false;
                }
            }
        }
        return true;
    }

    public String[][] view_project() throws SQLException{
        projects = new String[r_count("project")][7];

        rs = statement.executeQuery("select * from project");
        int i=0;
        while(rs.next()){
            projects[i][0] = rs.getString("pro_name");
            projects[i][1] = rs.getString("pro_desc");
            projects[i][2] = rs.getString("deadline");
            projects[i][3] = rs.getString("pro_state");
            projects[i][4] = rs.getString("comp_percent");
            projects[i][5] = rs.getString("pm_email");
            projects[i][6] = rs.getString("tl_email");
            i++;
        }
        return projects;
    }
}