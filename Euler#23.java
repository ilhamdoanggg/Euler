import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX = 100005;
        int[] divisorSum = new int[MAX];
        ArrayList<Integer> abundantNumbers = new ArrayList<>();

        precalculateDivisorSums(divisorSum, abundantNumbers);

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            boolean isSumOfTwoAbundantNumbers = isSumOfTwoAbundant(divisorSum, abundantNumbers, n);
            System.out.println(isSumOfTwoAbundantNumbers ? "YES" : "NO");
        }
        scanner.close();
    }

    private static void precalculateDivisorSums(int[] divisorSum, ArrayList<Integer> abundantNumbers) {
        for (int i = 1; i < divisorSum.length; i++) {
            divisorSum[i] = getDivisorSum(i);
            if (divisorSum[i] > i) {
                abundantNumbers.add(i);
            } else {
                divisorSum[i] = -1;
            }
        }
    }

    private static int getDivisorSum(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }
        return sum;
    }

    private static boolean isSumOfTwoAbundant(int[] divisorSum, ArrayList<Integer> abundantNumbers, int n) {
        for (int i = 0; i < abundantNumbers.size(); i++) {
            int first = abundantNumbers.get(i);
            if (n - first >= 0 && divisorSum[n - first] != -1) {
                return true;
            }
        }
        return false;
    }
}
