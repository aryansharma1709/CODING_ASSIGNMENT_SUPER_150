import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String a = s.next();
		String b = s.next();
		String c = s.next();

		int[][][] dp = new int[a.length()][b.length()][c.length()];
		for (int[][] r : dp) 
		{
			for (int[] rr : r)
			 {
				Arrays.fill(rr, -1);
			}
		}
		System.out.println(lcs(a, b, c, 0, 0, 0, dp));
    }
	public static int lcs(String a, String b, String c, int i, int j, int k, int[][][] dp) {
		if (a.length() == i || b.length() == j || c.length() == k) return 0;

		if (dp[i][j][k] != -1) return dp[i][j][k];

		int ans = 0;
		if (a.charAt(i) == b.charAt(j) && b.charAt(j) == c.charAt(k))
			ans = 1 + lcs(a, b, c, i+1, j+1, k+1, dp);
		else {
			int one = lcs(a, b, c, i+1, j, k, dp);
			int two = lcs(a, b, c, i, j+1, k, dp);
			int three = lcs(a, b, c, i, j, k+1, dp);
			ans = Math.max(one, Math.max(two, three));
		}
		return dp[i][j][k] = ans;
	}
}