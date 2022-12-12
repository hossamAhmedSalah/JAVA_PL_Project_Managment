package com.java_pl_project_managment.util;

import com.java_pl_project_managment.util.DB.SQLConnection;
import java.sql.*;

public class Employee extends Account{
    public String TL_name;
    
    SQLConnection conn = new SQLConnection();

    Employee(Account a) throws SQLException{
        conn.rs = conn.statement.executeQuery("select TL_email from employee inner join tl on employee.tl_id = tl.tl_id where employee.em_email = " + a.email);
        while(conn.rs.next()){
            TL_name = conn.rs.getString("tl_email");
        }
    }
}
