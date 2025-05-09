abstract class Salary {
    float basicpay;
    float hra;
    float da;

    public Salary(float basicpay, float hra, float da) {
        this.basicpay = basicpay;
        this.hra = hra;
        this.da = da;
    }

    public float getBasicpay() {
        return basicpay;
    }

    public void setBasicpay(float basicpay) {
        this.basicpay = basicpay;
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
