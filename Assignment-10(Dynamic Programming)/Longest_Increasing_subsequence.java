import java.util.*;
public class Main {
    public static void main (String args[])
     {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for (int i =0; i <n; i++) 
        {
            arr[i]=s.nextInt();
        }

        int[] dp=new int[n];
        dp[0]=arr[0];
        int len=1;

        for (int i=1; i<n; i++)
        {
            if(arr[i]>dp[len-1])
            {
                dp[len] =arr[i];
                len++;
            }
            else
             {
                int idx=binSearch(dp, 0, len-1, arr[i]);
                dp[idx] = arr[i];
            }
        }
        System.out.print(len);
    }
    public static int binSearch(int[] dp, int si, int ei, int target) 
    {
        while(si<=ei)
         {
            int mid=si+(ei-si)/2;
            if(dp[mid]>=target)
                ei=mid-1;
            else
                si=mid+1;
        }
        return si;   
    }
}
