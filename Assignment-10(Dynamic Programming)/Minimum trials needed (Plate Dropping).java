import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0)
		 {
			int k = s.nextInt();
			int n = s.nextInt();

			int[][] dp = new int[n+1][k+1];
			for (int[] r : dp) {
				Arrays.fill(r, -1);
			}
			System.out.println(trial(n, k, dp));
		}
    }
	public static int trial(int f, int p, int[][] dp) {
		if (f == 0 || f == 1) return f;

		if (p == 1)	return f;		

		if (dp[f][p] != -1)	return dp[f][p];

		int ans = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
			int breaks = trial(k-1, p-1, dp);
			int not_break = trial(f-k, p, dp);

			int temp = 1 + Math.max(breaks, not_break);  
			ans = Math.min(ans, temp);
        }

        return dp[f][p] = ans;
	}
}