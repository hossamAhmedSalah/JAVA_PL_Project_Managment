import java.sql.*;
import java.util.Scanner;
public class Account extends SQLConnection{
    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected String type;

    Account() throws SQLException{
    }

    Account(String email, String pass) throws SQLException{
        Scanner in = new Scanner(System.in);
        this.email = email;
        this.password = pass;
        
        while(!log_in(email,pass)){
            System.out.println("Wrong email or password!!");
            System.out.println("Please re-enter Email ");
            email = in.next();
            System.out.println("Please re-enter Password ");
            pass = in.next();
        }
        
        in.close();
    }

    private boolean log_in(String email,String pass) throws SQLException{
        rs = statement.executeQuery("select * from Account where email = '" + email + "' and password = '" + password + "'");
        while(rs.next()){
            this.id = rs.getInt("id");
            this.name = rs.getString("name");
            this.email = rs.getString("email");
            this.password = rs.getString("password");
            this.type = rs.getString("type");
            break;
        }
        return (this.name!=null);
    }
    public String toString(){
        return "\nName: " + name + "\nEmail: " + email + "\nRole: " + type + "\n";
    }
}
