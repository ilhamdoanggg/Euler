import java.util.Scanner;

public class Solution {

    // Method to calculate the greatest common divisor (GCD)
    public static long gcd(long a, long b){
        while (b != 0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to calculate the least common multiple (LCM)
    public static long lcm(int n){
        long ans = 1;
        for(long i = 1; i <= n; i++){
            ans = (ans * i) / gcd(ans, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(lcm(n));
        }
        in.close(); // Close the scanner to prevent resource leak
    }
}
