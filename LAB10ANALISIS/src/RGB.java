import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RGB {
    private static Map<String, String> colorNames;

    static {
        colorNames = new HashMap<>();
        colorNames.put("#FFFFFF", "White");
        colorNames.put("#000000", "Black");
        colorNames.put("#FF0000", "Red");
        colorNames.put("#FF3421", "Red");
        colorNames.put("#00FF00", "Green");
        colorNames.put("232323", "Black");
        colorNames.put("#FD2", "Blue");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a color in RGB format (example: #FFFFFF): ");
        String color = scanner.nextLine();

        if (isValidRGBColor(color)) {
            System.out.println(color + " is a valid RGB color.");

            String colorName = getColorName(color);
            if (colorName != null) {
                System.out.println("The color is: " + colorName);
            } else {
                System.out.println("No name found for the color.");
            }
        } else {
            System.out.println(color + " is not a valid RGB color.");
        }
    }

    public static boolean isValidRGBColor(String color) {
        String pattern = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(color);

        return matcher.matches();
    }

    public static String getColorName(String color) {
        return colorNames.get(color);
    }
}

