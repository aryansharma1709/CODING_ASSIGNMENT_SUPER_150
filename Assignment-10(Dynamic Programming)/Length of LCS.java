import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String a = s.next();
		String b = s.next();

		int[][] dp = new int[a.length()][b.length()];
		for (int[] r : dp) {
			Arrays.fill(r, -1);
		}
		System.out.println(lcs(a, b, 0, 0, dp));
    }
	public static int lcs(String a, String b, int i, int j, int[][] dp) {
		if (i == a.length() || j == b.length()) return 0;

		if (dp[i][j] != -1)	return dp[i][j];

		int ans = 0;
		if (a.charAt(i) == b.charAt(j))
			ans = 1 + lcs(a, b, i+1, j+1, dp);
		else {
			int one = lcs(a, b, i+1, j, dp);
			int two = lcs(a, b, i, j+1, dp);
			ans = Math.max(two, one);
		}
		return dp[i][j] = ans;
    }
}