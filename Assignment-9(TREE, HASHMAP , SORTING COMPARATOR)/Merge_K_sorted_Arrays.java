import java.util.*;
public class Main {
	static class Tup {
        int v;
        int r;
        int c;
        public Tup(int v, int r, int c) {
            this.v = v;
            this.r = r;
            this.c = c;
        }
    }
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);	// Merge K-sorted arrays
		int k = sc.nextInt();
		int n = sc.nextInt();

		int[][] a = new int[k][n];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		PriorityQueue<Tup> pq = new PriorityQueue<>(new Comparator<Tup>() {     // min-Heap
            @Override
            public int compare(Tup o1, Tup o2) {
                return o1.v - o2.v;
            }
        });
        
        for (int i = 0; i < k; i++) {
            pq.add(new Tup(a[i][0], i, 0));
        }
        
        while (!pq.isEmpty()) {
            Tup t = pq.poll();
            System.out.print(t.v + " ");
            
            if (t.c + 1 < n)
                pq.add(new Tup(a[t.r][t.c + 1], t.r, t.c + 1));
        }
    }
}
