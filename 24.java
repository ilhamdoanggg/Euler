import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    static int num;
    static Vector<Integer> vis = new Vector<>();
    static Map<Long, Integer> want = new HashMap<>();
    static Vector<String> ans = new Vector<>();
    static String s = "abcdefghijklm";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int T = t;

        ans.setSize(T);

        for (int i = 1; i < 15; i++) {
            vis.add(1);
        }

        while (t-- > 0) {
            long n = scanner.nextLong();
            want.put(n, T - t - 1);
            vis.clear();
            for (int i = 0; i < 13; i++) {
                vis.add(0);
            }
            System.out.println(solve(n, "", 12));
        }
        scanner.close();
    }

    static void comp(String a) {
        if (a.length() == s.length()) {
            num++;
            if (want.containsKey((long) num)) {
                ans.set(want.get((long) num), a);
            }
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (vis.get(i) == 0) {
                vis.set(i, 1);
                comp(a + s.charAt(i));
                vis.set(i, 0);
            }
        }
    }

    static Vector<Integer> f = new Vector<>();
    static {
        for (int i = 0; i < 15; i++) {
            f.add(1);
        }
        for (int i = 1; i < 15; i++) {
            f.set(i, f.get(i - 1) * i);
        }
    }

    static String solve(long n, String a, int fact) {
        if (a.length() == s.length()) {
            return a;
        }
        int ind = 0;
        while (n > f.get(fact)) {
            n -= f.get(fact);
            ind++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (vis.get(i) == 0) {
                ind--;
                if (ind == -1) {
                    vis.set(i, 1);
                    return solve(n, a + s.charAt(i), fact - 1);
                }
            }
        }
        assert (1 == 0);
        return "";
    }
}
