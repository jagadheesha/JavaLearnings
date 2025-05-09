import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CommonValues {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 4, 5, 6, 7};


        Set<Integer> set1 = new HashSet<>();


        for (int num : a) {
            set1.add(num);
        }


        Set<Integer> commonValues = new HashSet<>();


        for (int num : b) {
            if (set1.contains(num)) {
                commonValues.add(num);
            }
        }


        System.out.println("Common values in the arrays: " + commonValues);
    }
}
