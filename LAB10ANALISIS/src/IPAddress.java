import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address: ");
        String ipAddress = scanner.nextLine();

        if (isValidIPAddress(ipAddress)) {
            System.out.println(ipAddress + " is a valid IP address.");
        } else {
            System.out.println(ipAddress + " is not a valid IP address.");
        }
    }

    public static boolean isValidIPAddress(String ipAddress) {
        String pattern = "^(?:\\d{1,3}\\.){3}\\d{1,3}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(ipAddress);

        return matcher.matches();
    }
}
