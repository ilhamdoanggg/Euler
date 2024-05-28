import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int n = scanner.nextInt();
            long maxProduct = findMaxProduct(n);
            System.out.println(maxProduct);
        }
        scanner.close();
    }

    public static long findMaxProduct(int n) {
        long maxProduct = -1;
        for (long i = 1; i < n; i++) {
            long j = (n * n - 2 * n * i) / (2 * n - 2 * i);
            long k = n - i - j;
            if (isPythagoreanTriplet(i, j, k)) {
                maxProduct = Math.max(maxProduct, i * j * k);
            }
        }
        return maxProduct;
    }

    public static boolean isPythagoreanTriplet(long i, long j, long k) {
        return i * i + j * j == k * k && j > 0 && k > 0;
    }
}
