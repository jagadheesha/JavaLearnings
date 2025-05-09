import java.util.*;

public class ArrayList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 6);

        int min = Collections.min(numbers);
        int max = Collections.max(numbers);

        List<Integer> missingNumbers = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (!numbers.contains(i)) {
                missingNumbers.add(i);
            }
        }

        System.out.println("Missing numbers: " + missingNumbers);
    }
}


