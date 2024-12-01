import java.util.*;
public class Main {
	static class Seller {
		int apple;
		int mango;
		int orange;
		public Seller(int app, int mng, int org) {
			apple = app;
			mango = mng;
			orange = org;
		}
	}
    public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();

			Seller[] arr = new Seller[n];
			for (int i = 0; i < n; i++) {
				arr[i] = new Seller(s.nextInt(), s.nextInt(), s.nextInt());
			}

			System.out.println(cost(arr, n));	
		}
    }
	public static int cost(Seller[] arr, int n) 
	{
		int[][] dp = new int[n+1][4];	
		dp[1][1] = arr[0].apple;
		dp[1][2] = arr[0].mango;
		dp[1][3] = arr[0].orange;

		for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j == 1) 
					dp[i][j] = arr[i-1].apple + Math.min(dp[i-1][2], dp[i-1][3]);
				else if (j == 2) 
					dp[i][j] = arr[i-1].mango + Math.min(dp[i-1][1], dp[i-1][3]);
				else 
					dp[i][j] = arr[i-1].orange + Math.min(dp[i-1][1], dp[i-1][2]);
			}
		}

		return Math.min(dp[n][1], Math.min(dp[n][2], dp[n][3]));
	}
}