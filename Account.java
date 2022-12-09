import java.sql.SQLException;
import SQL.SQLConnection;

public class Account extends SQLConnection{
    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected String type;

    Account(){
    }

    Account(String e, String p){
        email = e;
        password = p;
        log_in(e,p);
        if(this.name!=null){
            System.out.println("Welcome " + name);
        }
        else System.out.println("Wrong email or password");
    }

    private void log_in(String email,String pass){
        try{
            rs = statement.executeQuery("select * from Account where email = '" + email + "' and password = '" + password + "'");
            while(rs.next()){
                this.id = rs.getInt("id");
                this.name = rs.getString("name");
                this.email = rs.getString("email");
                this.password = rs.getString("password");
                this.type = rs.getString("type");
            }
        }catch(SQLException e){
            System.out.println("Wrong Email or Password");
        }
    }
}
