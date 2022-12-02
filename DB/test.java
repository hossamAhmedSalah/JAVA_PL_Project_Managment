import java.util.*;
public class test {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter name ");
        String name = input.nextLine();

        System.out.println("Please enter age ");
        int age = input.nextInt();

        SQLConnection connect = new SQLConnection();
        connect.insert("insert into test values('"+ name + "',"+ age + ")");
        
        input.close();
    }
}
