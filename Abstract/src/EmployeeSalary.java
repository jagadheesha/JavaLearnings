public class EmployeeSalary extends Salary {


    public EmployeeSalary(float basicPay, float hra, float da) {
        super(basicPay, hra, da);
    }
    @Override
    public float calculateTotalSalary() {
        return basicPay + hra + da;
    }
}


