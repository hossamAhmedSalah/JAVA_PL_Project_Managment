import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLConnection {
    String connectionUrl;

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    SQLConnection(){
        this.connectionUrl =  
                "jdbc:sqlserver://pl2project.mssql.somee.com;"
                        + "database=pl2project;"
                        + "user=gimmepp_SQLLogin_1;"
                        + "password=qj54fx9pff;"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();) {
            System.out.println("Connected Successfully...");
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            System.out.println("Could not Connect...");
            e.printStackTrace();
        }
    }
    
    public void insert(String s){
        // ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();) {
                statement.execute(s);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }   
    }

    public String[] select(String s){
        String[] ans = new String[100];
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
            Statement statement = connection.createStatement();) {
                resultSet = statement.executeQuery(s);
                int i = 0;
                while (resultSet.next()) {
                    ans[i] = resultSet.getString(2);
                    i++;
                }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }   
        return ans;
    }

}

//o2bcn7KZuMuVW0CD