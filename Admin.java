import java.sql.SQLException;

public class Admin extends Account{
    Admin(){

    }
    Admin(Account a){
    }
    protected void sign_up(String name, String email, String password, String type){
        // this.name = name;
        // this.email = email;
        // this.password = password;
        // this.type = type;

        try{
            statement.execute("insert into Account values('" + name + "','" + email + "','" + password + "','" + type + "')");
            System.out.println("Account created Successfully");
        }catch(SQLException e){
            System.out.println("Account already exists");
        }

        try{
            statement.execute("");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
