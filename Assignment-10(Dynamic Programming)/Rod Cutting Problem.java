import java.util.*;
public class Main {
    public static void main (String args[]) {    
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] prr = new int[n];
        for (int i = 0; i < n; i++) 
        {
            prr[i] = s.nextInt();
        }                                 

        int len = s.nextInt();
        System.out.print(cost(prr, len));
    }
    public static int cost(int[] prr, int len) {
        int[][] dp = new int[len+1][len+1];    
        
        for (int i = 1; i < dp.length; i++)
         {
            for (int j = 1; j < dp[0].length; j++) 
            {
                
                int cut = 0, not_cut = 0;
                if (j >= i) 
                    cut = prr[i-1] + dp[i][j-i];
                not_cut = dp[i-1][j];
                
                dp[i][j] = Math.max(cut, not_cut);
            }
        }
        return dp[len][len];
    }
}