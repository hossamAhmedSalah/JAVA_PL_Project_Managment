import java.sql.SQLException;

public class Employee extends SQLConnection{
    protected String name;
    protected String kek;
    protected int id;
    
    Employee(){
    }

    Employee(Account e){
        this.id = e.id;
        this.name = e.name;
    }

    public String[] getTasks(){
        String tbl = "tasks";
        String cnt = "select count(" + this.id + ") as cnt from " + tbl;
        int row = 0;
        try{
            rs = statement.executeQuery(cnt);
            while(rs.next()){
                row = rs.getInt("cnt");
            }
            // System.out.println("ROWS = "+row);
            // System.out.println("ID = "+this.id);
        }catch(SQLException e){
            e.printStackTrace();
        }

        String[] ans = new String[row];
        try{
            rs = statement.executeQuery("select [task] from tasks where em_id = "+this.id);
            // System.out.println("id = "+this.id);
            int i = 0;
            while(rs.next()){
                ans[i] = rs.getString("task");
                // System.out.println("ans "+ i + "= "+ans[i]);
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
// t@g.com