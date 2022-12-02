import java.util.*;
public class test {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        SQLConnection connect = new SQLConnection();

        System.out.print("Please enter name: ");
        String name = input.nextLine();

        System.out.print("Please enter age: ");
        int age = input.nextInt();

        connect.insert("insert into test values('"+ name + "',"+ age + ")");
        
        int n = connect.rcount("select count(name) as cnt from test;");
        // System.out.println(n);

        String[] arr = new String[n];
        arr = connect.select("Select [name] from test");
        for(int i=0;i<n;i++){
            System.out.println(i+1 + " " + arr[i]);
        }
        input.close();
    }
}