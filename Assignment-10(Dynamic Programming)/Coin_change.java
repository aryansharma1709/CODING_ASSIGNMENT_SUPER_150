import java.util.*;
public class Main {
    public static void main(String args[]) 
	{
       
		Scanner s=new Scanner(System.in);
        int amount = s.nextInt();
        int n=s.nextInt();
        int[] arr=new int[n];
        for (int i=0; i<n; i++)
		{
            arr[i]=s.nextInt();
        }

        int[][] dp=new int[n][amount+1];
        for (int[] r:dp)
		{
            Arrays.fill(r, -1);   
        }
        System.out.println(coinFun(arr, 0, amount, dp));
    }
	public static int coinFun(int[] arr, int idx, int amount, int[][] dp)
	 {
        if(amount == 0)return 1;
        if(idx == arr.length)return 0;
        if(dp[idx][amount]!= -1)return dp[idx][amount];

        int take=0, not_take=0;
        if(amount >= arr[idx])
            take =coinFun(arr, idx, amount-arr[idx], dp);
        not_take = coinFun(arr, idx+1, amount, dp);

        return dp[idx][amount]=take + not_take;
    }
}
