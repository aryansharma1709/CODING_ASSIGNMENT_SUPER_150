import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        for (int x : b) {
            if (map.containsKey(x) && map.get(x) > 0) {
                list.add(x);
                map.put(x, map.get(x) - 1);
            }
        }
        
        Collections.sort(list);
        System.out.println(list);
    }
}
