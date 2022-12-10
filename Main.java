import java.sql.*;

public class Main{
    public static void main(String[] args) throws SQLException{
        Account a1 = new Account("bo@g.com","145");
        System.out.println(a1.toString());
    }
}
