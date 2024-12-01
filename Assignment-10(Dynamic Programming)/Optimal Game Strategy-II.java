import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
		 {
			arr[i] = s.nextInt();
		}

		int[][] dp = new int[n][n];
		for (int[] r : dp) {
			Arrays.fill(r, -1);
		}
		System.out.print(game(arr, 0, n-1, dp));
    }
	public static int game(int[] arr, int i, int j, int[][] dp) 
	{	
		if (i > j)	return 0;

		if (dp[i][j] != -1)	return dp[i][j];

		int first = arr[i] + Math.min(game(arr, i+2, j, dp), game(arr, i+1, j-1, dp));
		int end = arr[j] + Math.min(game(arr, i+1, j-1, dp), game(arr, i, j-2, dp));

		return dp[i][j] = Math.max(first, end);
	}
}