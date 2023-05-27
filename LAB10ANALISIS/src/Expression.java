import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();

        String regexPattern = ".*abcd2023111111102023.*";
        Pattern pattern = Pattern.compile(regexPattern);

        Matcher matcher = pattern.matcher(inputString);

        if (matcher.matches()) {
            String result = inputString.replaceAll("2023", "Happy New Year");
            System.out.println("Resulting string: " + result);
        } else {
            System.out.println("The string does not match the specified pattern.");
        }
    }
}
