import java.util.*;
public class Main {
    public static void main(String args[]) {
    
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int w = s.nextInt();

		int[] prr = new int[w];
		for (int i = 0; i < w; i++)
		 {
			prr[i] = s.nextInt();
		}
		
        int[][] dp = new int[w+1][w+1];
        for(int[] r : dp){
            Arrays.fill(r, -1);
        }
        System.out.println(minMoney1(prr, 0, w, dp));
    }

   public static int minMoney1(int[] prr, int idx, int wt, int[][] dp) {
        if (wt == 0)    return 0;
        if (idx == prr.length)    return 10000000;
        if (dp[idx][wt] != -1)  return dp[idx][wt];
        

        int buy = 10000000;
        if (wt >= idx+1 && prr[idx] != -1) 
            buy = prr[idx] + minMoney1(prr, idx, wt-idx-1, dp);
        int not_buy = minMoney1(prr, idx+1, wt, dp);

        return dp[idx][wt] = Math.min(buy, not_buy);
	}
}