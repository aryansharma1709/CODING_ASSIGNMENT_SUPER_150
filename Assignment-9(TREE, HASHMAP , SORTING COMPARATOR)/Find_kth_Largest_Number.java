import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();          // min-Heap
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        
        for (int i = k; i < n; i++) {
            if (arr[i] > pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        System.out.println(pq.peek());
    }
}