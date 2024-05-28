import java.util.Scanner;

public class Main {
    static final int MAX = 500001;
    static int[] divs = new int[MAX];

    static void precompute() {
        for (int i = 1; i < MAX; i++) {
            for (int j = i * 2; j < MAX; j += i) {
                divs[j] += i;
            }
        }
    }

    public static void main(String[] args) {
        precompute();

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int sum = 0;
            for (int i = 1; i < n; i++) {
                int divSum = divs[i];
                if (divSum < MAX && divs[divSum] == i && divSum != i) {
                    sum += i;
                }
            }
            System.out.println(sum);
        }
        scanner.close();
    }
}
