package com.java_pl_project_managment.util.DB;

import java.sql.*;

public class SQLConnection {
    public String connectionUrl;
    public Connection connection;
    public Statement statement;
    public ResultSet rs = null;

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public SQLConnection() throws SQLException{
        this.connectionUrl =  
                "jdbc:sqlserver://pl2project.mssql.somee.com;"
                        + "database=pl2project;"
                        + "user=gimmepp_SQLLogin_1;"
                        + "password=qj54fx9pff;"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;";

        connection = DriverManager.getConnection(connectionUrl);
        statement = connection.createStatement();
        System.out.println("Connected Successfully...");
    }
    
    //execute sql query, returns nothing, takes in table name
    public void query(String s) throws SQLException{
        statement.execute(s);
    }

    //execute sql query, returns table, takes in table name
    public String[][] table(String tbl) throws SQLException{
        int row = this.r_count(tbl);
        int col = this.c_count(tbl);

        String[][] ans = new String[row][col];

        rs = statement.executeQuery("select * from " + tbl);
        int i = 0;
        while(rs.next()){
            for(int j=1;j<=col;j++){
                ans[i][j-1] = rs.getString(j);

            }
            i++;
        } 
        return ans;
    }

    public int c_count(String s) throws SQLException{
        int n = -1;
        String str = "select * from " + s;
        ResultSet rs = null;

        rs = statement.executeQuery(str);
        ResultSetMetaData rsmd = rs.getMetaData();
        n = rsmd.getColumnCount();

        return n;
    }
    public int r_count(String s) throws SQLException{
        int n = -1;
        String str = "select count(*) as cnt from " + s;
        ResultSet rs = null;
        rs = statement.executeQuery(str);
        rs.next();
        n = rs.getInt("cnt");  

        return n;
    }

}

//o2bcn7KZuMuVW0CD