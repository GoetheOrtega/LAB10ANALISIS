import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecimalNumbers {
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

            List<Double> decimalNumbers = extractDecimalNumbers(textContent);

            System.out.println("Decimal numbers array:");
            double[][] numberMatrix = buildNumberMatrix(decimalNumbers);
            displayMatrix(numberMatrix);

            double sum = calculateSum(decimalNumbers);
            System.out.println("Sum of numbers: " + sum);

            double max = findMaximum(decimalNumbers);
            System.out.println("Maximum number: " + max);

            int seriesNumber = decimalNumbers.size();
            System.out.println("Series number of the last number: " + seriesNumber);

            String resultString = replaceNumbersWithWord(textContent, "number");
            System.out.println("Resulting string: " + resultString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Double> extractDecimalNumbers(String text) {
        List<Double> decimalNumbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("[-+]?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            double number = Double.parseDouble(matcher.group().replace(",", "."));
            decimalNumbers.add(number);
        }

        return decimalNumbers;
    }

    public static double[][] buildNumberMatrix(List<Double> numbers) {
        int rows = numbers.size();
        double[][] matrix = new double[rows][1];

        for (int i = 0; i < rows; i++) {
            matrix[i][0] = numbers.get(i);
        }

        return matrix;
    }

    public static void displayMatrix(double[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double calculateSum(List<Double> numbers) {
        double sum = 0.0;

        for (double number : numbers) {
            sum += number;
        }

        return sum;
    }

    public static double findMaximum(List<Double> numbers) {
        double max = Double.MIN_VALUE;

        for (double number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }

    public static String replaceNumbersWithWord(String text, String word) {
        Pattern pattern = Pattern.compile("[-+]?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(word);
    }
}
