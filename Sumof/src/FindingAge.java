import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;


    public class FindingAge{
        public static void main(String[] args) {
            // Create a Scanner object to read input from the user
            Scanner scanner = new Scanner(System.in);


            System.out.println("Enter your birth year  ");
            int year = scanner.nextInt();

            System.out.println("Enter your birth month ");
            int month = scanner.nextInt();

            System.out.println("Enter your birth day ");
            int day = scanner.nextInt();


            LocalDate birthDate = LocalDate.of(year, month, day);


            LocalDate currentDate = LocalDate.now();





            System.out.println("You are " + period.getYears() + " years, "
                    + period.getMonths() + " months, and "
                    + period.getDays() + " days old.");


            scanner.close();
        }
    }




