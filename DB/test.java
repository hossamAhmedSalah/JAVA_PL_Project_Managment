import java.util.*;
import java.sql.*;

public class test {
    public static void main(String[] args) throws SQLException{
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter login credentials...");
        System.out.print("Email: ");
        String email = in.next();
        System.out.print("Password: ");
        String pass = in.next();

        Account a1 = new Account(email,pass);
        System.out.println(a1.toString());

        in.close();
    }
}