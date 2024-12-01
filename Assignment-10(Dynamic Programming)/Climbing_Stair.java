import java.util.*;
public class Main {
    public static void main (String args[]) 
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();

		int[] dp=new int[n+1];
		Arrays.fill(dp, -1);
		System.out.print(jump(n, dp));
    }
	public static int jump(int n, int[] dp) {
		if (n <= 1)	return 1;

		if (dp[n] != -1) return dp[n];

		int oneStep = jump(n-1, dp);
		int twoStep = jump(n-2, dp);

		return dp[n] = oneStep + twoStep;
	}
}