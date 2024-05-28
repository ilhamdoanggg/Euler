import java.util.Scanner;

public class Solution {

    public static long prime(long n) {
        long maxPrime = -1; 
        
        // Handle the factor of 2
        while (n % 2 == 0) { 
            maxPrime = 2; 
            n /= 2; 
        } 
        
        // Handle odd factors
        for (int i = 3; i <= Math.sqrt(n); i += 2) { 
            while (n % i == 0) { 
                maxPrime = i; 
                n /= i; 
            } 
        } 
        
        // If n is still greater than 2, then n is prime
        if (n > 2) {
            maxPrime = n;
        }
        
        return maxPrime;
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                long n = in.nextLong();
                System.out.println(prime(n));
            }
        }
    }
}
