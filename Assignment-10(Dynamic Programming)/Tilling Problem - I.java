import java.util.*;
public class Main {
    public static void main (String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		long[] dp = new long[n+1];
		System.out.print(count(n, dp));
    }
	public static long count(int n, long[] dp) {
     	if (n <= 2) return n;
		if (dp[n] != 0) return dp[n];
		long horizontal = count(n-2, dp);
		long vertical = count(n-1, dp);

		return dp[n] = horizontal + vertical;
	}
}