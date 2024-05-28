import java.util.*;

public class Main {

    public static long[] generatePrimes(int max) {
        long[] primes = new long[max + 1];
        Arrays.fill(primes, 1);
        primes[0] = primes[1] = 0;
        for (int i = 2; i * i <= max; i++) {
            if (primes[i] == 1) {
                for (int j = i * i; j <= max; j += i) {
                    primes[j] = 0;
                }
            }
        }
        return primes;
    }

    public static int countDivisors(long num, long[] primes) {
        int count = 1;
        for (int i = 2; i < primes.length && num > 1; i++) {
            if (primes[i] == 1) {
                int exp = 0;
                while (num % i == 0) {
                    num /= i;
                    exp++;
                }
                count *= (exp + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 1000;
        long[] primes = generatePrimes(max);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int i = 1;
            long num = 1;
            while (true) {
                i++;
                num = i * (i + 1) / 2;
                if (countDivisors(num, primes) > n) {
                    System.out.println(num);
                    break;
                }
            }
        }
        scanner.close();
    }
}
