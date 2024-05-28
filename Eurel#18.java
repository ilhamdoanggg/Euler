import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[][] triangle = new int[n][];
            for (int i = 0; i < n; i++) {
                triangle[i] = new int[i + 1];
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = scanner.nextInt();
                }
            }
            System.out.println(maximumPathSum(triangle));
        }
        scanner.close();
    }

    public static int maximumPathSum(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        
        return dp[0][0];
    }
}
