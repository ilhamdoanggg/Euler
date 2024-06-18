import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] ar = new int[5001];
        Vector<Integer> a = new Vector<>();
        Vector<Integer> b = new Vector<>();
        a.add(1);
        b.add(1);
        calculateFibonacciDigits(ar, a, b);
        printFibonacciDigits(t, ar, scanner);
        scanner.close();
    }

    static void calculateFibonacciDigits(int[] ar, Vector<Integer> a, Vector<Integer> b) {
        int k = 1;
        while (true) {
            int len = b.size();
            if (len > 5000) break;
            if (ar[len] == 0) ar[len] = k;
            add(b, a);
            Vector<Integer> temp = a;
            a = b;
            b = temp;
            k++;
        }
    }

    static void add(Vector<Integer> a, Vector<Integer> b) {
        int carry = 0;
        int len = 0;

        for (; len < b.size(); len++) {
            if (len == a.size()) a.add(0);
            int sum = a.get(len) + b.get(len) + carry;
            carry = sum / 10;
            a.set(len, sum % 10);
        }

        while (carry != 0) {
            if (len == a.size()) a.add(0);
            int sum = a.get(len) + carry;
            carry = sum / 10;
            a.set(len, sum % 10);
            len++;
        }
    }

    static void printFibonacciDigits(int t, int[] ar, Scanner scanner) {
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(ar[n]);
        }
    }
}
