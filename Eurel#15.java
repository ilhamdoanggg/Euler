import java.util.Scanner;

public class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt() + 1;
            int m = scanner.nextInt() + 1;
            long[][] paths = new long[n][m];
            calculatePaths(paths);
            System.out.println(paths[n - 1][m - 1]);
        }
        scanner.close();
    }

    public static void calculatePaths(long[][] paths) {
        int n = paths.length;
        int m = paths[0].length;

        for (int i = 0; i < n; i++) {
            paths[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            paths[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                paths[i][j] = (paths[i - 1][j] + paths[i][j - 1]) % MOD;
            }
        }
    }
}
