import java.util.*;

public class Main {
    static String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"};
    static String[] decim = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static String hun = "Hundred";
    static String thous = "Thousand";
    static String mill = "Million";
    static String bill = "Billion";
    static List<String> ans = new ArrayList<>();

    static void solve(long n) {
        if (n <= 20) {
            ans.add(units[(int) n]);
        } else if (n < 100) {
            ans.add(decim[(int) (n / 10)]);
            solve(n % 10);
        } else if (n < 1000) {
            solve(n / 100);
            ans.add(hun);
            solve(n % 100);
        } else if (n < 1e6) {
            solve(n / 1000);
            ans.add(thous);
            solve(n % 1000);
        } else if (n < 1e9) {
            long h = (long) 1e6;
            solve(n / h);
            ans.add(mill);
            solve(n % h);
        } else {
            long h = (long) 1e9;
            solve(n / h);
            ans.add(bill);
            solve(n % h);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            if (n == 0) {
                System.out.println("Zero");
            } else {
                ans.clear();
                solve(n);
                System.out.print(ans.get(0));
                for (int i = 1; i < ans.size(); i++) {
                    if (!ans.get(i).equals("")) {
                        System.out.print(" " + ans.get(i));
                    }
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}
