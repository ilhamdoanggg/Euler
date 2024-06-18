import java.util.Scanner;

public class Main {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            long n = scanner.nextLong();
            long k = (n - 1) / 2 - 1;
            long result = calculateResult(k);
            System.out.println(result % MOD);
        }

        scanner.close();
    }

    private static long calculateResult(long k) {
        long result = 1 + 24 * (k % MOD) + 18 * modMul(k, k + 1);
        assert result > 0;
        result %= MOD;

        if ((k + 1) % 3 == 0) {
            result += modMul(8 * ((k + 1) / 3) % MOD, modMul(k, 2 * k + 1));
        } else if (k % 3 == 0) {
            result += modMul(8 * (k + 1) % MOD, modMul(k / 3, 2 * k + 1));
        } else {
            assert (2 * k + 1) % 3 == 0;
            result += modMul(8 * (k + 1) % MOD, modMul(k, (2 * k + 1) / 3));
        }

        result = (result % MOD + 24) % MOD;
        assert result > 0;

        return result;
    }

    private static long modMul(long a, long b) {
        return (a % MOD) * (b % MOD) % MOD;
    }
}
