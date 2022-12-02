public class test {
    public static void main(String[] args){
        SQLConnection connect = new SQLConnection();
        connect.insert("insert into test values('hamid',18)");

        int n = 3;
        while(n-->0)
            System.out.println("returned: " + connect.select("select * from test")[n]);
    }
}
