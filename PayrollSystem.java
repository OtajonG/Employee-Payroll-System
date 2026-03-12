import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class PayrollSystem {
    // This needs to be static to be used in the main method
    static Employee loggedInStaff = null; 
    static HashMap<Integer, Employee> stafflist = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("********** <<WELCOME TO THE PAYROLL SYSTEM! (dashboard)>> **********");

        // --- REGISTRATION (Only happens once at start) ---
        

        
        // Repeat the above block for each employee registration
        for (int i =1; i <= 5; i++){
            System.out.println("**************** PLEASE REGISTER MINIMUM 5 EMPLOYEES ****************");
            System.out.println("\n[REGISTRATION " + i + "/5]");
            System.out.println("Enter Employee Name: " );
            String newStaffname = scanner.nextLine().toUpperCase();
            if (newStaffname.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
                i--; // Decrement to repeat this iteration
                continue;
            }
            
            int generatedID = 1000 + random.nextInt(9000);
            System.out.println("Your Employee IDs`: " + generatedID);

            System.out.println("Enter Employee Email: ");
            String email = scanner.nextLine();
            if (email.isEmpty() || !email.contains("@")) {
                System.out.println("Invalid email. Please try again.");
                i--; // Decrement to repeat this iteration
                continue;
            }
                if(i == 1){
                    //position 1 : Manager (8000 is just an example, you can set it as you wish)
                    stafflist.put(generatedID, new EMPSalary(newStaffname, generatedID, email, 8000.00, "Manager"));
                } else if(i == 2){
                    //position 2 : Admin (5000 is just an example, you can set it as you wish)
                    stafflist.put(generatedID, new EMPSalary(newStaffname, generatedID, email, 5000.00, "Admin"));
                } else {
                    //position 3, 4 and 5 : Chef, Waiter and Cleaner (All are Associate)(3000 is just an example, you can set it as you wish)
                    stafflist.put(generatedID, new EMPSalary(newStaffname, generatedID, email, 3000.00, "Cheff"));
                System.out.println("System: " + newStaffname + "added as level " + i + " employee.");
                }
            HourlyEmployee hourC = new HourlyEmployee(newStaffname, generatedID, email);
            stafflist.put(generatedID, hourC);

            
            
        }
        //new staff directory table
        System.out.println("\n**************** STAFF DIRECTORY ****************");
        System.out.printf("%-10s | %-20s | %-30s\n", "NO.", "NAME", "EMAIL");
        int count = 1;
        for (Employee emp : stafflist.values()) {
            System.out.printf("%-10s | %-20s | %-30s\n", count++, emp.getName(), emp.getEmail());
        }
        System.out.println("***********************************************");
        System.out.println("NOTE: Please use the generated Employee ID to clock in and out. Thank you!");

        // --- THE MENU ---
        int choice = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Clock In (Login)");
            System.out.println("2. Clock Out");
            System.out.println("3. View Current Balance");
            System.out.println("4. Generate Pay Slip & Exit");
            System.out.print("Enter your choice: ");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            }

            switch (choice) {
                case 1: // LOGIN & CLOCK IN
                    if (loggedInStaff == null) {
                        System.out.print("Enter your Staff Id to clock in: ");
                        int idInput = scanner.nextInt();
                        scanner.nextLine();

                        if (stafflist.containsKey(idInput)) {
                            loggedInStaff = stafflist.get(idInput);
                            System.out.println("******Welcome " + loggedInStaff.getName() + "!******");
                            ((HourlyEmployee) loggedInStaff).clockIn();
                        } else {
                            System.out.println("Invalid Staff ID.");
                        }
                    } else {
                        System.out.println(loggedInStaff.getName() + " is already clocked in!");
                    }
                    break;

                case 2: // CLOCK OUT (No ID needed if logged in)
                    if (loggedInStaff != null) {
                        ((HourlyEmployee) loggedInStaff).calculatePay();
                        loggedInStaff = null; // Clear session
                        System.out.println("******Successfully clocked out.******");
                    } else {
                        System.out.println("Please Clock In (Option 1) first!");
                    }
                    break;

                case 3: // BALANCE (No ID needed)
                    if (loggedInStaff != null) {
                        double bal = ((HourlyEmployee) loggedInStaff).getCurrentBalance();
                        System.out.printf("******Current Balance for %s: $%.2f******\n", loggedInStaff.getName(), bal);
                    } else {
                        System.out.println("Please login first!");
                    }
                    break;

                case 4: // FINAL SLIP
                    if (loggedInStaff != null) {
                        ((HourlyEmployee) loggedInStaff).generatePaySlip();
                        System.out.println("******Exiting the system... Goodbye!******");
                        
                    } else {
                        System.out.println("Login required to generate slip.");
                        System.out.println("Going back to Login...");
                        choice = 0; // Redirect to login
                    }
                    break;
            }
        } while (choice != 4);
        scanner.close();
    }
}