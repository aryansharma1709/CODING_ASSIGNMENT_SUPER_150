import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
        String a = s.next();
        String b = s.next();

		String[][] dp = new String[a.length()][b.length()];
        System.out.println(lcs(a, b, 0, 0, dp));
    }
    public static String lcs(String a, String b, int i, int j, String[][] dp) {
        if (i == a.length() || j == b.length())  return "";

		if (dp[i][j] != null)	return dp[i][j];

        String ans = "";
        if (a.charAt(i) == b.charAt(j))
            ans = a.charAt(i) + lcs(a, b, i+1, j+1, dp);
        else {
            String one = lcs(a, b, i+1, j, dp);
            String two = lcs(a, b, i, j+1, dp);
            ans = (one.length() >= two.length()) ? one : two;
        }

        return dp[i][j] = ans;
    }
}