import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            HashSet<Integer> s = new HashSet<>();
            
            for (int i = 0; i < n; i++) {
                s.add(sc.nextInt());
            }
            
            int q = sc.nextInt();
            while (q-- > 0) {
                if (s.contains(sc.nextInt()))
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
    }
}
