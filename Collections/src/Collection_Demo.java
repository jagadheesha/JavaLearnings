import java.util.ArrayList;
public class Collection_Demo {
    public static void main(String[] args) {
        ArrayList a1 =new ArrayList();
        a1.add(12);
        a1.add(12.30f);
        a1.add(true);
        a1.add(false);
        a1.add(1343456);
        a1.add("hi");
        a1.add('a');
        System.out.println(a1);
        ArrayList a2 = new ArrayList()  ;
        a2.add("java");
        a2.add("naveen");

        a1.addAll(a2);
        System.out.println(a1);

    }
}
