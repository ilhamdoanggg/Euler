import java.util.Scanner;

public class Main {
    
    public static int init(String s, int from, int k){
        int akt = 1;
        for(int i = from; i < from + k; i++){
            akt *= Character.getNumericValue(s.charAt(i));
        }
        return akt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();
            int res = 0;
            for(int i = 0; i < n - k; i++){
                res = Math.max(res, init(s, i, k));
            }
            System.out.println(res);
        }
        scanner.close();
    }
}
