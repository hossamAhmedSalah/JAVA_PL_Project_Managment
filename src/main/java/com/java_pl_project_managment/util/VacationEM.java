package com.java_pl_project_managment.util;
import java.sql.SQLException;
import java.util.*;
public interface VacationEM {
    //** remember to remove email
    public int requestVacation(String email,String fromDateX,String toDateY) throws SQLException;
    public String showVacationState(int request_id) throws SQLException;
}
