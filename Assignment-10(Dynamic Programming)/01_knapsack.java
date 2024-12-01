import java.util.*;
public class Main {
    public static void main(String args[]) 
	{
		Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int cap=s.nextInt();

        int[] wt=new int[n];
        int[] val = new int[n];
        for (int i = 0; i < n; i++)
		{
            wt[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++)
		{
            val[i] = s.nextInt();
        }

        int[][] dp = new int[cap+1][n];
        for (int[] r: dp)
		 {
            Arrays.fill(r, -1);
        }
        System.out.println(knapSack1(wt, val, cap, 0, dp));
    }
    public static int knapSack1(int[] wt, int[] val, int cap, int idx, int[][] dp) {
        if (cap == 0 || idx == wt.length) return 0;
        if (dp[cap][idx] != -1) return dp[cap][idx];

        int pick = 0, not_pick = 0;
        if (cap >= wt[idx])
            pick = val[idx] + knapSack1(wt, val, cap-wt[idx], idx+1, dp);
        not_pick = knapSack1(wt, val, cap, idx+1, dp);

        return dp[cap][idx] = Math.max(pick, not_pick);
    }
}