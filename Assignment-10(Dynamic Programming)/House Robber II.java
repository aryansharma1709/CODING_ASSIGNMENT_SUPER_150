import java.util.*;
public class Main {
    public static void main (String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
         {
            arr[i] = s.nextInt();
        }

        if (n == 1) {
            System.out.print(arr[0]);
            return;
        }
        else if (n == 2) {
            System.out.print(Math.max(arr[0], arr[1]));
            return;
        }
        int a1 = rob(arr, 0, n-2);
        int a2 = rob(arr, 1, n-1);
        System.out.print(Math.max(a1, a2));
    }
    public static int rob(int[] arr, int si, int ei)
     {
        int[] dp = new int[arr.length];
        dp[si] = arr[si];
        dp[si+1] = Math.max(arr[si], arr[si+1]);

        for (int i = si+2; i <= ei; i++) 
        {
            int rob = arr[i] + dp[i-2];
            int not_rob = dp[i-1];
            dp[i] = Math.max(rob, not_rob);
        }
        return dp[ei];
    }
}