import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		while (t-- > 0)
		 {
			int n=s.nextInt();
			System.out.println(ugly(n));
		}
    }
	public static long ugly(int n) {
		long[] dp = new long[n+1];
		dp[1] = 1L;

		int i2 = 1, i3 = 1, i5 = 1;
		for (int i = 2; i <= n; i++) 
		{
			long mul2 = dp[i2] * 2;
			long mul3 = dp[i3] * 3;
			long mul5 = dp[i5] * 5;

			long min = Math.min(mul2, Math.min(mul3, mul5));
			dp[i] = min;

			if (min == mul2)
				i2++;
			if (min == mul3)
				i3++;
			if (min == mul5)
				i5++;
		}

		return dp[n];
	}
}