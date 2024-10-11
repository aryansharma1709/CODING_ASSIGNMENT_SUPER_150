import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int sum = 0;
        int mod = 1000000007;
        HashMap<Integer, Integer> m = new HashMap<>();
        
        int s = 0, e = 0;
        while (e < n) {
            m.put(a[e], m.getOrDefault(a[e], 0) + 1);
            while (m.size() < e - s + 1 && s <= e) {
                m.put(a[s], m.get(a[s]) - 1);
                if (m.get(a[s]) == 0)
                    m.remove(a[s]);
                s++;
            }
            
            int len = e - s + 1;
            sum += (len * (len + 1) / 2) % mod;
            sum %= mod;
			e++;
        }

        System.out.println(sum);
    }
}
