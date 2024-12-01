import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner ss= new Scanner(System.in);
		int t = ss.nextInt();
		while (t-- > 0)
		 {
			String s = ss.next();

			if (isPalindrome(s)) {
				System.out.println(0);
				continue;
			}

        	int[] dp = new int[s.length()];
        	Arrays.fill(dp, -1);
        	System.out.println(partition(s, 0, dp));
		}
    }
	public static int partition(String s, int idx, int[] dp) {
        if (idx == s.length() || isPalindrome(s.substring(idx))) return 0;

        if (dp[idx] != -1) return dp[idx];

        int minCuts = Integer.MAX_VALUE;
        for (int i = idx+1; i < s.length(); i++)
		 {
            if (isPalindrome(s.substring(idx, i)))
			 {
                int ans = 1 + partition(s, i, dp);
                minCuts = Math.min(minCuts, ans);
            }
        }

        return dp[idx] = minCuts;
    }
    public static boolean isPalindrome(String s) 
	{
        int left = 0, right = s.length()-1;
        while (left < right)
		 {
            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }
        return true;
	}
}