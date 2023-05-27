import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number {
    public static void main(String[] args) {
        String filePath = "src/file.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }

            String textContent = sb.toString();

            List<Integer> integers = extractIntegers(textContent);
            printNumbersSeparatedByCommas(integers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> extractIntegers(String text) {
        List<Integer> integers = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            integers.add(number);
        }

        return integers;
    }

    public static void printNumbersSeparatedByCommas(List<Integer> numbers) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.size(); i++) {
            sb.append(numbers.get(i));

            if (i < numbers.size() - 1) {
                sb.append(",");
            }
        }

        System.out.println(sb.toString());
    }
}
