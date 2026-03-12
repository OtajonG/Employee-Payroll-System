public class EMPSalary extends Employee {
    private double monthlySalary;
    private String position;

    public EMPSalary(String name, int id, String email, double monthlySalary, String position) {
        super(name, id, email);
        this.monthlySalary = monthlySalary;
        this.position = position;
    }
    @Override
    public void calculatePay(){
        System.out.println("\n********************" + position + " SALARY DETAILS********************");
        System.out.printf("Monthly Salary: $%.2f\n", monthlySalary);
        System.out.println("Status: Full-time");
    }
}