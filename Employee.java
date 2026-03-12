import java.util.Scanner;
public abstract class Employee {
    
       

    private String name;
    private int id;
    private String email;

    Scanner scanner = new Scanner(System.in);


    public Employee(String name, int id, String email){
        this.name = name;
        this.id = id;
        this.email = email;
    }
    public String getName(){
        return name;
    }
    public int getEmployeeID(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public abstract void calculatePay();
    
    

}
