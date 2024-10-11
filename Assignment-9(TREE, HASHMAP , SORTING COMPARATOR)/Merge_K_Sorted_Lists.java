import java.util.*;
public class Main {
	static class Tuple{
        int val;
        int row;
        int col;
        public Tuple(int v, int r, int c) {
            val = v;
            row = r;
            col = c;
        }
    }
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);	// Merge K-sorted arrays
		int k = sc.nextInt();
		int n = sc.nextInt();

		int[][] arr = new int[k][n];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		PriorityQueue<Tuple> pq = new PriorityQueue<>(new Comparator<Tuple>() {     // min-Heap
            @Override
            public int compare(Tuple o1, Tuple o2) {
                return o1.val - o2.val;
            }
        });
        
        for (int i = 0; i < k; i++) {
            pq.add(new Tuple(arr[i][0], i, 0));
        }
        
        while (!pq.isEmpty()) {
            Tuple rv = pq.poll();
            System.out.print(rv.val + " ");
            
            if (rv.col+1 < n)
                pq.add(new Tuple(arr[rv.row][rv.col+1], rv.row, rv.col+1));
        }

    }
}