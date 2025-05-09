 import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"abc");
        map.put(2,"def");
        map.put(3,"ghi");
        map.put(4,"jkl");
        map.put(5,"mno");

        int sumOfKeys = 0;
        for (int key : map.keySet()) {
            sumOfKeys += key;
        }


        System.out.println("Sum of keys in the HashMap: " + sumOfKeys);


    }
}