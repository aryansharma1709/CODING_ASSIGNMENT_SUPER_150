import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner s=new Scanner(System.in);
        int t =s.nextInt();
        while(t-- > 0)
		 {
            int n =s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
			 {
                arr[i] = s.nextInt();
            }
            
            int[] dp = new int[n];
            Arrays.fill(dp, -1);
            System.out.println(rob(arr, 0, dp));            
        }
    }
    public static int rob(int[] arr, int idx, int[] dp) 
	{
        if (idx >= arr.length) return 0;
        
        if (dp[idx] != -1) return dp[idx];
        
        int rob = arr[idx] + rob(arr, idx+2, dp);
        int not_rob = rob(arr, idx+1, dp);
        
        return dp[idx] = Math.max(rob, not_rob);
    }
}