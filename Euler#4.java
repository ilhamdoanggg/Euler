import java.util.Scanner;

public class Solution {

    // Method to check if a number is a palindrome
    public static boolean isPalindrome(int x) {
        int n = x;
        int p = 1;
        while (n != 0) {
            n /= 10;
            p *= 10;
        }
        int r = 1;
        p /= 10;
        while (p > r) {
            if ((x / p) % 10 != (x / r) % 10) {
                return false;
            }
            p /= 10;
            r *= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int maxPalindrome = 0;
            for (int i = 1; i < 1000; i++) {
                for (int j = 1; j < 1000; j++) {
                    int product = i * j;
                    if (product < n && isPalindrome(product)) {
                        maxPalindrome = Math.max(maxPalindrome, product);
                    }
                }
            }
            System.out.println(maxPalindrome);
        }
        scanner.close();
    }
}
