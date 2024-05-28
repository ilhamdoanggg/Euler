import java.util.Scanner;

public class Main {
    static final int MAX_DIGITS = 5000;

    static void multiply(int[] result, int x, int size) {
        int carry = 0;
        for (int i = 0; i < size; i++) {
            int prod = result[i] * x + carry;
            result[i] = prod % 10;
            carry = prod / 10;
        }
        while (carry != 0) {
            result[size] = carry % 10;
            carry /= 10;
            size++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] result = new int[MAX_DIGITS];
            result[0] = 1;
            int size = 1;

            for (int i = 1; i <= n; i++) {
                multiply(result, i, size);
                size = findSize(result);
            }

            int sum = 0;
            for (int i = 0; i < size; i++) {
                sum += result[i];
            }
            System.out.println(sum);
        }
        scanner.close();
    }

    static int findSize(int[] result) {
        int size = MAX_DIGITS;
        for (int i = MAX_DIGITS - 1; i >= 0; i--) {
            if (result[i] != 0) {
                size = i + 1;
                break;
            }
        }
        return size;
    }
}
