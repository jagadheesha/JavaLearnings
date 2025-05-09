import java.util.ArrayList;

public class CustomCollection {
    public static void main(String[] args) {

        ArrayList<student> a1=new ArrayList<student>();

        a1.add(new student(1,"sathish"));
        a1.add(new student(2,"ravi"));
        a1.add(new student(3,"sujitha"));
        a1.add(new student(4,"hari"));
        a1.add(new student(5,"sujith"));

        System.out.println(a1);

    }
}
class student{
    int rollNo;
    String name;

    public student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }
}
