
import java.util.*;
public class Main {
    public static void main(String args[]) 
	{
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();

        int[] arr = new int[n];
        int[] brr = new int[m];
        for (int i = 0; i < n; i++)
		 {
            arr[i] = s.nextInt();
        }
        for (int i = 0; i < m; i++)
		 {
            brr[i] = s.nextInt();
        }

        int[][] dp = new int[n][m];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }

		int lcs = lcs(arr, brr, 0, 0, dp);
		int size = Math.min(n, m);
        System.out.println(Math.min(lcs+k, size));
    }
    public static int lcs(int[] arr, int[] brr, int i, int j, int[][] dp) {
        if (i == arr.length || j == brr.length) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int ans = 0;
        if (arr[i] == brr[j])
            ans = 1 + lcs(arr, brr, i+1, j+1, dp);
        else {
            int one = lcs(arr, brr, i+1, j, dp);
			
            int two = lcs(arr, brr, i, j+1, dp);
            ans = Math.max(one, two);
        }
        
        return dp[i][j] = ans;
    }
}