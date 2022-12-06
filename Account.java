import java.sql.SQLException;

public class Account extends SQLConnection{
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
            if(name=="emp"){
                Employee em = new Employee(this);
            }
            System.out.println(name);
        }
    }

    private void log_in(String email,String pass){
        try{
            rs = statement.executeQuery("select * from login where email = '" + email + "' and password = '" + password + "'");
            while(rs.next()){
                this.name = rs.getString("name");
                this.email = rs.getString("email");
                this.password = rs.getString("password");
                this.type = rs.getString("type");
            }
        }catch(SQLException e){
            System.out.println("Wrong Email or Password");
        }
    }

    public void sign_up(String name, String email, String password, String type){
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;

        try{
            statement.execute("insert into login values('" + name + "','" + email + "','" + password + "','" + type + "')");
            System.out.println("Account created Successfully");
        }catch(SQLException e){
            System.out.println("Account already exists");
        }
    }
}
