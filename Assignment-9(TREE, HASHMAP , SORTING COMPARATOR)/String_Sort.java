import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.startsWith(s2)) 
                	return s2.length() - s1.length(); 
            	else if (s2.startsWith(s1)) 
                	return s1.length() - s2.length(); 
            	
                return s1.compareTo(s2);
            }
        });

        for (String str : arr) {
            System.out.println(str);
        }
    }
}