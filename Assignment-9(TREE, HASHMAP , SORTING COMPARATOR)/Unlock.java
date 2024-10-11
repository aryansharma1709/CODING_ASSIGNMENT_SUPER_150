import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            m.put(a[i], i);
        }

        int i = 0;
        while (i < n && k > 0) {
            int t = m.get(n - i);
            if (i == t) { 
                i++;
                continue;
            } 
			else {  
                int temp = a[i];
                a[i] = a[t];
                a[t] = temp;

                m.put(a[t], t);
                m.put(a[i], i);
                i++;
                k--;
            }
        }

        for (int j = 0; j < n; j++) {
            System.out.print(a[j] + " ");
        }
	}
}
