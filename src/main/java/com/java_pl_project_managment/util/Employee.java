package com.java_pl_project_managment.util;

import com.java_pl_project_managment.util.DB.SQLConnection;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.*;

public class Employee extends Account implements TaskEM, penalitiesEM,VacationEM{

        private Calendar startTimer,endTimer;
        public String[][] workHours;
        public double Salary;
        public double netSalary;
        public double bonus;
        public double penalty;
        //SQLConnection conn = new SQLConnection();
        private String[] v_state = {"Rejected","Accepted","Pending"};
        private String[] taskstring = {"not started","completed","in progress"};

    public Employee() throws SQLException {
        Salary = super.salary;
        netSalary=viewNetSalary(this.email);
        workHours=getWorkHours(this.email);
        bonus=viewBonus(this.email);
        penalty=viewPenalities(this.email);
    }
    public void setSalary (String email, double salary) throws SQLException {
        query("update Account set salary ="+salary+" where email='"+email+"'");
    }
    public double getSalary(String email) throws SQLException{
        double emp_salary=0;
        rs = statement.executeQuery("select salary from Account where email='"+email+"'");
        if (rs.next()) emp_salary = rs.getDouble("salary");
        return emp_salary;
    }

    public double[] getsalaries(String[] emails) throws SQLException{
        double[] salaries= new double[emails.length];
        for (int i=0;i<emails.length;i++) {
            rs = statement.executeQuery("select salary from Account where email='"+emails[i]+"'");
           while (rs.next()) salaries[i]= rs.getDouble("salary");
        }
        return salaries;
    }
    public void setStartWorkTimer(){
        this.startTimer=Calendar.getInstance();
    }
    public void setEndWorkTimer(){
        this.endTimer= Calendar.getInstance();
    }
    public String[] calculateWorkHoursInAday(String email) throws SQLException {
        String[] DayHour = new String[2];
        int TimeWork = startTimer.get(Calendar.HOUR_OF_DAY) - endTimer.get(Calendar.HOUR_OF_DAY);
        DayHour[0] = TimeWork + "";
        DayHour[1] = startTimer.get(Calendar.YEAR) + "-" + startTimer.get(Calendar.MONTH) + "-" + startTimer.get(Calendar.DAY_OF_MONTH);
        query("insert into workhours values('" + email + "'," + DayHour[0] + ",'" + DayHour[1] + "')");
        return DayHour;
    }

    public void setWorkHours(String email ,String[][] workHours) throws SQLException{
        for (int i=0;i<workHours.length;i++)
         query("insert into workhours values('" + email + "'," + workHours[i][0] + ",'" + workHours[i][1] +"')");
        //column index 0 is for "hours", 1 for date "yyyy-mm-dd"
    }

    public String[][] getWorkHours(String email) throws SQLException {
        int rows=0;
        rs = statement.executeQuery("select count(*) as rows_n from workhours where email='"+email+"'");
        if (rs.next()) rows = rs.getInt("rows_n");
        //System.out.println(rows);
        String[][] workHours= new String[rows][2];
        rs =statement.executeQuery("select number_of_hours, date_of_day from workhours where email='"+email+"'");
        for (int i=0;rs.next();i++){
            for(int j=0;j<2;j++){
                workHours[i][j] = rs.getString(j+1);
            }
        }

        return workHours;

    }

    public int getTotalMonthHours(String email) throws SQLException{
        int TotalHours=0;
        rs=statement.executeQuery("select sum(number_of_hours) as total_hours from workhours where email='"+email+"'");
        if (rs.next()) TotalHours=rs.getInt("total_hours");
        return TotalHours;
    }
    //request and return vacation id *input email must be in em table (only em rule can request vacation)*
    public int requestVacation(String email, String fromDateX,String toDateY) throws SQLException {
        // *** remove email from parameters & interface proto
        int v_id=0;
        //SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String dx= fromDateX;
        String dy= toDateY;
        //System.out.println(dx);
        //System.out.println(dy);
        query("insert into vacation values('"+email+"','"+dx+"','"+dy+"',"+2+")");
        rs = statement.executeQuery("select v_id from vacation where(em_email='"+email+"' and s_date='"+dx+"' and e_date='"+dy+"')");
        if(rs.next()) v_id = rs.getInt("v_id");
        return v_id;
    }
    public String showVacationState(int request_id) throws SQLException {
        String state="";
        rs = statement.executeQuery("select v_state as v from vacation where v_id="+request_id);
        if (rs.next()) state = v_state[rs.getInt("v")];
        return state;
    }

    public double viewPenalities(String email) throws SQLException{
        double pen =0.0;
        rs = statement.executeQuery("select amount from penalties where em_email='"+email+"'");
        if (rs.next()) pen = rs.getDouble("amount");
        if (pen>0)
            return pen;
        else
            return 0;

    }

    public double viewBonus(String email) throws SQLException{
        double bon=0.0;
        rs = statement.executeQuery("select amount from penalties where em_email='"+email+"'");
        if(rs.next()) bon = rs.getDouble("amount");
        if (bon<0)
            return Math.abs(bon);
        else
            return 0;
    }

    public double viewNetSalary(String email) throws SQLException{
        double netsal= getSalary(email)-viewPenalities(email)+viewBonus(email);
        return netsal;
    }
    public String[][] viewEmployeeTasks(String email) throws SQLException{
        int rows=0;
        rs = statement.executeQuery("select count(*) as rows_n from tasks where em_email='"+email+"'");
        if(rs.next()) rows = rs.getInt("rows_n");
        String[][] emptasks= new String[rows][4];
        rs = statement.executeQuery("select task_name, task_desc,task_state, pro_name from tasks where em_email='"+email+"'");
        for (int i=0;rs.next();i++){
            for(int j=0;j<4;j++){
                if (j==2)
                    emptasks[i][j] = taskstring[rs.getInt(j+1)];
                else
               emptasks[i][j] = rs.getString(j+1);
            }
        }
        return emptasks;
    }
    public void finishTask(String TaskName) throws SQLException{
        query("update tasks set task_state=1 where task_name='"+TaskName+"'");
    }
    public void pendingTask (String TaskName) throws SQLException{
        query("update tasks set task_state=2 where task_name='"+TaskName+"'");
    }

}
