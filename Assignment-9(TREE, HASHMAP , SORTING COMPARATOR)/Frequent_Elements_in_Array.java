import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();				// can also be done using 'Bucket-Sort'
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {   // max-Heap
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }

        List<Integer> l = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            l.add(pq.poll()[0]);
        }
        Collections.sort(l);

		for (int ele : l) {
			System.out.print(ele + " ");
		}
    }
}