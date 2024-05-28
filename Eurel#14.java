import java.util.*;

public class Main {
    
    static final int M = 5_000_005;
    static List<Integer> chain = new ArrayList<>(Collections.nCopies(M, -1));
    
    static int comp(int at) {
        int ans = 0;
        long i = at;
        while (true) {
            if (i <= at && chain.get((int) i) != -1) {
                ans += chain.get((int) i);
                break;
            }
            if (i % 2 == 0) {
                i /= 2;
                ans++;
            } else {
                i = 3 * i + 1;
                ans++;
            }
        }
        chain.set(at, ans);
        return ans;
    }
    
    public static void main(String[] args) {
        chain.set(1, 0);
        for (int i = 2; i < M; i++) {
            comp(i);
        }
        
        List<Integer> maxs = new ArrayList<>(Collections.nCopies(M, 0));
        maxs.set(1, 1);
        for (int i = 2; i < M; i++) {
            if (chain.get(maxs.get(i - 1)) <= chain.get(i)) {
                maxs.set(i, i);
            } else {
                maxs.set(i, maxs.get(i - 1));
            }
        }
        
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            System.out.println(maxs.get(n));
        }
        scanner.close();
    }
}
