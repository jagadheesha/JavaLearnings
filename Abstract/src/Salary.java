abstract class Salary {
    float basicPay;
    float hra;
    float da;

    public Salary(float basicPay, float hra, float da) {
        this.basicPay = basicPay;
        this.hra = hra;
        this.da = da;
    }

     public float getBasicPay() {
         return basicPay;
     }

     public void setBasicPay(float basicPay) {
         this.basicPay = basicPay;
     }

     public float getHra() {
         return hra;
     }

     public void setHra(float hra) {
         this.hra = hra;
     }

     public float getDa() {
         return da;
     }

     public void setDa(float da) {
         this.da = da;
     }
    public abstract float calculateTotalSalary();

 }
