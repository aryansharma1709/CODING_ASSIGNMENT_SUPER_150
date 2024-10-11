import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());// max-Heap
        int q = sc.nextInt();
        int k = sc.nextInt();
        
        while (q-- > 0) {
            int query = sc.nextInt();
            if (query == 1) {
                long x = sc.nextLong();
                long y = sc.nextLong();
                long dist = x*x + y*y;
                
                if (pq.size() < k)
                    pq.add(dist);
                else {
                    if (dist < pq.peek()) {
                        pq.poll();
                        pq.add(dist);
                    }
                }
            }
            else
                System.out.println(pq.peek());
        }
    }
}