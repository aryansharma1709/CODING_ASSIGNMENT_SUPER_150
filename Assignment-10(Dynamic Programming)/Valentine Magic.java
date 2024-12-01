
import java.util.*;
public class Main {
    public static void main(String args[])
	 {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();

		int[] boys = new int[n];
		int[] girls = new int[m];
		for (int i = 0; i < n; i++)
		 {
			boys[i] = s.nextInt();
		}
		for (int i = 0; i < m; i++)
		 {
			girls[i] = s.nextInt();
		}

		Arrays.sort(boys);
		Arrays.sort(girls);

		int[][] dp = new int[n][m];
		for (int[] r: dp) {
			Arrays.fill(r, -1);
		}
		System.out.print(pair(boys, girls, 0, 0, dp));
    }
	public static int pair(int[] boys, int[] girls, int i, int j, int[][] dp) 
	{
		if (i == boys.length) return 0;
		if (j == girls.length) return 10000000;

		if (dp[i][j] != -1)	return dp[i][j];

		int paired = Math.abs(boys[i] - girls[j]) + pair(boys, girls, i+1, j+1, dp);
		int not_paired = pair(boys, girls, i, j+1, dp);

		return dp[i][j] = Math.min(paired, not_paired);
	}
}