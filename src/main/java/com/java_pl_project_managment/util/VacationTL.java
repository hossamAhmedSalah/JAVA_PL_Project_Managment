package com.java_pl_project_managment.util;

import java.sql.SQLException;

public interface VacationTL {
    public void givePenality(String email_em,double amount,String description) throws SQLException;

    public void Bouns(String email_em,double amount,String description) throws SQLException;

}
