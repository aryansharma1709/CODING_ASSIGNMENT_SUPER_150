import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> m = new HashMap<>();
        for (int x : a) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }

        int maxF = 0;
        int maxE = 0;
        for (int k : m.keySet()) {
            if (m.get(k) > maxF) {
                maxE = k;
                maxF = m.get(k);
            }
        }

        System.out.println(maxE);
    }
}
