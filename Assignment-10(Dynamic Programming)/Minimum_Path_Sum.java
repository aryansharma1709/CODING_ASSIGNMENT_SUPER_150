import java.util.*;
public class Main {
    public static void main (String args[]) {
        Scanner s=new Scanner(System.in);
        int m=s.nextInt();
        int n=s.nextInt();

        int[][] grid=new int[m][n];
        for (int i=0;i<m; i++) 
        {
            for (int j=0; j<n; j++)
            {
                grid[i][j]=s.nextInt();
            }
        }

        int[][] dp=new int[m][n];
        for (int[] r: dp)
        {
            Arrays.fill(r, -1);
        }
        System.out.println(path(grid, 0, 0, dp));
    }
    public static int path(int[][] grid, int cr, int cc, int[][] dp) {
        if (cr == grid.length-1 && cc == grid[0].length-1) return grid[cr][cc];
        if (cr >= grid.length || cc >= grid[0].length) return Integer.MAX_VALUE;
        if (dp[cr][cc] != -1) return dp[cr][cc];
        
        int right = path(grid, cr, cc+1, dp);
        int down = path(grid, cr+1, cc, dp);

        return dp[cr][cc] = Math.min(right, down) + grid[cr][cc];
    }
}