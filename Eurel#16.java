import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> v = new ArrayList<>();
        List<Integer> two = new ArrayList<>(Collections.singletonList(1));
        v.add(1);
        int power = 0;
        while (power <= 1e4) {
            int digSum = 0;
            int carry = 0;
            for (int i = 0; i < two.size(); i++) {
                carry += two.get(i) * 2;
                two.set(i, carry % 10);
                digSum += two.get(i);
                carry /= 10;
            }
            while (carry != 0) {
                two.add(carry % 10);
                digSum += carry % 10;
                carry /= 10;
            }
            v.add(digSum);
            power++;
        }
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(v.get(n));
        }
        scanner.close();
    }
}
