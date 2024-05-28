import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            BigInteger num = new BigInteger(scanner.next());
            sum = sum.add(num);
        }
        String k = sum.toString();
        System.out.println(k.substring(0, Math.min(10, k.length())));
        scanner.close();
    }
}
