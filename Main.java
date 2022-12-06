import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Account a = new Account();

        while(a.name==null){
            System.out.println("Please enter email");
            String str = input.next();
            System.out.println("Please enter password");
            String pass = input.next();
            a = new Account(str,pass);
        }


        Employee e = new Employee();
        Admin ad = new Admin();
        // System.out.println("em".compareTo(a.type));
        switch (a.type) {
            case "employee":
                e = new Employee(a);
                String[] task = e.getTasks();
                for(int i=0;i<task.length;i++){
                    System.out.println(task[i]);
                }
                break;
            case "admin":
                break;
            default:
                break;
        }
        input.close();
    }
}
