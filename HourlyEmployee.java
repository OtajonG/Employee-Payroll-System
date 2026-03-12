public class HourlyEmployee extends Employee {
    private long startTime;
    private final double HourlyRate = 15.00; 

    public HourlyEmployee(String name, int id, String email) {
        super(name, id, email);
    }

    public void clockIn() {
        this.startTime = System.currentTimeMillis();
        // Use new java.util.Date() so it prints a real time, not trillions
        System.out.println("Clocked in at: " + new java.util.Date());
    }
    
    @Override
    public void calculatePay() {
        if (this.startTime == 0) {
            System.out.println("No start time recorded. Please Clock In first.");
            return;
        }
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - this.startTime; 
        
        // 1 hour = 3,600,000 milliseconds
        double hours = timeElapsed / 3600000.0; 
        double totalPay = hours * HourlyRate;

        System.out.printf("Time worked : %.4f hours\n", hours);
        System.out.printf("Money Earned : $%.2f\n", totalPay);
    }

    public double getCurrentBalance() {
        if (this.startTime == 0) {
            return 0.0;
        }
        long currentTime = System.currentTimeMillis();
        
        // FIXED MATH: Must match calculatePay exactly
        double hours = (currentTime - this.startTime) / 3600000.0; 
        return hours * HourlyRate;
    }

    public void generatePaySlip() {
        System.out.println("\n******************************************");
        System.out.println("            OFFICIAL PAY SLIP             ");
        System.out.println("******************************************");
        System.out.println("Staff Name:  " + getName());
        System.out.println("Staff ID:    " + getEmployeeID());
        System.out.println("Email:       " + getEmail());
        System.out.println("Date:        " + new java.util.Date());
        System.out.println("------------------------------------------");
        
        calculatePay(); 
        
        System.out.println("------------------------------------------");
        System.out.println("   Thank you for your hard work today!    ");
        System.out.println("******************************************\n");
    }
}