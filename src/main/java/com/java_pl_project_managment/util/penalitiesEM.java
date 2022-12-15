package com.java_pl_project_managment.util;

import java.sql.SQLException;

public interface penalitiesEM {
    public double viewPenalities(String email) throws SQLException;
    public double viewBonus(String email) throws SQLException;
}
