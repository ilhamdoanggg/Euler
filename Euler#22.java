import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStrings = scanner.nextInt();
        String[] strings = new String[numberOfStrings];
        HashMap<Character, Integer> charValues = new HashMap<>();

        // Input strings
        for (int i = 0; i < numberOfStrings; i++) {
            strings[i] = scanner.next();
        }

        // Sort strings
        Arrays.sort(strings);

        // Calculate character values
        for (char c = 'A'; c <= 'Z'; c++) {
            charValues.put(c, c - 'A' + 1);
        }

        // Process queries
        int numberOfQueries = scanner.nextInt();
        while (numberOfQueries-- > 0) {
            String query = scanner.next();
            long sum = calculateSum(query, strings, charValues);
            System.out.println(sum);
        }

        scanner.close();
    }

    private static long calculateSum(String query, String[] strings, HashMap<Character, Integer> charValues) {
        long sum = 0;
        for (int i = 0; i < strings.length; i++) {
            if (query.equals(strings[i])) {
                for (char c : strings[i].toCharArray()) {
                    sum += charValues.get(c) * (i + 1);
                }
            }
        }
        return sum;
    }
}
