package com.java_pl_project_managment.util;

import java.sql.*;

public class Admin extends Account{
    protected static String[][] projects;

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
            str2 += "','"+data[7]+"')";
        else str2 += "')";
        statement.execute(str2);
        return true;
    }

    public boolean delete(String ed) throws SQLException{
        rs = statement.executeQuery("select role from account where email = '"+ed+"'");
        rs.next();
        String rr = rs.getString("role");
        String strole = "delete from "+ rr +" where "+ rr +"_email= '"+ed+"'";
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
            if(!eu[i].equals("")){
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

    public void view_project() throws SQLException{
        projects = new String[r_count("project")][6];
        String str[] = {"Not started" ,"Completed", "Finished"};

        String ex = "select pro_name,pro_desc,deadline,pro_state,comp_percent,a1.username as PM,a2.username as TL from project "+
                    "INNER JOIN account as a1 "+
                    "on a1.email = project.pm_email "+
                    "INNER JOIN account as a2 "+
                    "on a2.email = project.tl_email";
        
        rs = statement.executeQuery(ex);
        int i=0;
        while(rs.next()){
            projects[i][0] = rs.getString("pro_name");
            projects[i][1] = rs.getString("pro_desc");
            projects[i][2] = rs.getDate("deadline").toString();
            projects[i][3] = str[rs.getInt("pro_state")]+" "+rs.getString("comp_percent")+"%";
            projects[i][4] = rs.getString("PM");
            projects[i][5] = rs.getString("TL");
            i++;
        }
    }
}