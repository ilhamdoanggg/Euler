import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static List<Long> generatePrimes(int limit) {
        List<Long> primes = new ArrayList<>();
        primes.add(2L);
        for (long i = 3; i <= limit; i += 2) {
            boolean isPrime = true;

            for (long prime : primes) {
                if (prime * prime > i) {
                    break;
                }
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static long findNthPrime(List<Long> primes, int n) {
        return primes.get(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Long> primes = generatePrimes(1000000);

        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            long nthPrime = findNthPrime(primes, n);
            System.out.println(nthPrime);
        }

        scanner.close();
    }
}
