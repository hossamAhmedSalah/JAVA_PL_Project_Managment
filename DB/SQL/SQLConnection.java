package SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class SQLConnection {
    protected String connectionUrl;
    protected Connection connection;
    protected Statement statement;
    protected ResultSet rs = null;

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    protected SQLConnection(){
        this.connectionUrl =  
                "jdbc:sqlserver://pl2project.mssql.somee.com;"
                        + "database=pl2project;"
                        + "user=gimmepp_SQLLogin_1;"
                        + "password=qj54fx9pff;"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;";

        try{
            connection = DriverManager.getConnection(connectionUrl);
            statement = connection.createStatement();
            // System.out.println("Connected Successfully...");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println("Could not Connect...");
            e.printStackTrace();
        }
    }
    
    //execute sql query, returns nothing, takes in table name
    public void query(String s){
        try{
            statement.execute(s);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }   
    }

    //execute sql query, returns table, takes in query + table name
    public String[][] select(String s, String tbl){
        int row = this.r_count(tbl);
        int col = this.c_count(tbl);

        String[][] ans = new String[row][col];
        try{
            rs = statement.executeQuery(s + tbl);
            int i = 0;
            while (rs.next()){
                for(int j=1;j<=col;j++){
                    ans[i][j-1] = rs.getString(j);
                }
                i++;
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }   
        return ans;
    }

    public int c_count(String s){
        int n = -1;
        String str = "select * from " + s;
        ResultSet rs = null;
        try{
                rs = statement.executeQuery(str);
                ResultSetMetaData rsmd = rs.getMetaData();
                n = rsmd.getColumnCount();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }   
        return n;
    }
    public int r_count(String s){
        int n = -1;
        String str = "select count(*) as cnt from " + s;
        ResultSet rs = null;
        try{
                rs = statement.executeQuery(str);
                rs.next();
                n = rs.getInt("cnt");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }   
        return n;
    }


}

//o2bcn7KZuMuVW0CD