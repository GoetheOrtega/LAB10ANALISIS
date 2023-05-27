import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a date in the format dd/mm/yyyy: ");
        String date = scanner.nextLine();

        if (isValidDate(date)) {
            System.out.println(date + " is a valid date.");
        } else {
            System.out.println(date + " is not a valid date.");
        }
    }

    public static boolean isValidDate(String date) {
        String pattern = "^(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[0-2])/([1-9]\\d{3}|[2-9]\\d{3})$";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(date);

        if (matcher.matches()) {
            int day = Integer.parseInt(matcher.group(1));
            int month = Integer.parseInt(matcher.group(2));
            int year = Integer.parseInt(matcher.group(3));

            if (month == 2 && (day > 29 || (day == 29 && !isLeapYear(year)))) {
                return false;
            }

            return true;
        }

        return false;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
