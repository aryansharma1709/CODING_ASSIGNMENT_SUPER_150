import java.util.*;
public class Main {
    public static void main (String args[])
	 {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();

		long[] dp=new long[n+1];
		Arrays.fill(dp, -1);
		System.out.print(count(n, dp));
    }
	public static long count(int n, long[] dp)
	 {
		if (n == 0)return 1;
		if (n < 0)return 0;

		if (dp[n] != -1)return dp[n];

		long ways = 0;
		ways += count(n-1, dp);
		ways += count(n-3, dp);
		ways += count(n-4, dp);
		return dp[n] = ways;
	}
}