import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long findSum(long n)
    {
        long one = 2;
        long two = 8;
        long temp = 0;
        long sum = 0;
        while(one < n)
        {
            sum += one;
            temp = two;
            two = 4 * two + one;
            one = temp;
         }
         return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            System.out.println(findSum(n));
        }
    }
}
