import java.util.Scanner;
import java.util.Arrays;

public class Solutions {
    private static final int M = 10005;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] precomputedResults = precomputeResults();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(precomputedResults[n - 1]);
        }
        scanner.close();
    }

    private static int[] precomputeResults() {
        int[] anss = new int[M];
        int ans = 0;
        int maxCycleLength = 0;
        for (int i = 2; i < M; i++) {
            int cycleLength = findCycleLength(i);
            if (maxCycleLength < cycleLength) {
                maxCycleLength = cycleLength;
                ans = i;
            }
            anss[i] = ans;
        }
        return anss;
    }

    private static int findCycleLength(int n) {
        int num = 1;
        int den = n;
        int[] remainders = new int[n + 1];
        Arrays.fill(remainders, -1);
        remainders[1] = 0;
        int index = 0;

        while (true) {
            while (num < den) {
                index++;
                num *= 10;
            }
            int remainder = num % den;
            num = remainder;

            if (remainder == 0) {
                return 0;
            }

            if (remainders[remainder] != -1) {
                return index - remainders[remainder];
            } else {
                remainders[remainder] = index;
            }
        }
    }
}
