import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static final int MAX = 1000000;

    public static void main(String args[]) throws IOException {
        List<Integer> primes = generatePrimes();
        Map<Integer, Long> sumMap = calculatePrimeSums(primes);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine());

            while (!sumMap.containsKey(x)) {
                x--;
            }

            long sum = sumMap.get(x);
            System.out.println(sum);
        }
    }

    public static List<Integer> generatePrimes() {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        for (int i = 3; i <= MAX; i += 2) {
            boolean isPrime = true;

            for (int p : primes) {
                if (p * p > i) {
                    break;
                }
                if (i % p == 0) {
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

    public static Map<Integer, Long> calculatePrimeSums(List<Integer> primes) {
        Map<Integer, Long> sums = new HashMap<>();
        long sum = 0;

        for (int p : primes) {
            sum += p;
            sums.put(p, sum);
        }

        return sums;
    }
}
