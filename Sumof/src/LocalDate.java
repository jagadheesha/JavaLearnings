import java.time.LocalDate;            // For date without time
import java.time.LocalTime;            // For time without date
import java.time.LocalDateTime;        // For both date and time without timezone
import java.time.ZonedDateTime;        // For date and time with timezone
import java.time.format.DateTimeFormatter;  // For formatting date and time
import java.time.Instant;              // For a point in time (timestamp)
import java.time.Duration;             // For measuring time between two dates/times
import java.time.temporal.ChronoUnit;  // For date and time units like days, hours



public class LocalDate{
    public static void Main(String[] args) {
        LocalDate localDate=LocalDate.now();
        System.out.println(localDate.getYear());
    }

