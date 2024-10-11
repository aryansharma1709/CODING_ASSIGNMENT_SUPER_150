import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> ans = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int num = arr[i];
                map.put(num, map.getOrDefault(num, 0) + 1);
                List<Integer> temp = new ArrayList<>(map.keySet());

                Collections.sort(temp, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer a, Integer b) {
                        int freqA = map.get(a);
                        int freqB = map.get(b);
                        if (freqA == freqB) 
                            return a - b;
                        return freqB - freqA;
                    }
                });
                
                for (int j = 0; j < Math.min(k, temp.size()); j++) {
                    ans.add(temp.get(j));
                }
            }
            
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}