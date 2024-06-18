import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int[] result = findCoefficientsWithMaxPrimes(n);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] findCoefficientsWithMaxPrimes(int n) {
        int maxPrimes = 0;
        int bestA = 0, bestB = 0;

        for (int i = -n; i <= n; i++) {
            for (int j = -n; j <= n; j++) {
                int primeCount = countConsecutivePrimes(i, j);
                if (primeCount > maxPrimes) {
                    maxPrimes = primeCount;
                    bestA = i;
                    bestB = j;
                }
            }
        }

        return new int[]{bestA, bestB};
    }

    private static int countConsecutivePrimes(int a, int b) {
        int k = 0;
        while (isPrime(k * k + a * k + b)) {
            k++;
        }
        return k;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
