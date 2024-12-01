import java.util.*;
public class Main{
    public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int t = s.nextInt();
		while(t-- >0)
		 {
			int n=s.nextInt();

			HashMap<String, Long> dp=new HashMap<>();
			System.out.println(countFun(n, '0', dp));
		}
    }
	public static long countFun(int n, char prev, HashMap<String, Long> dp) 
	{
		if (n==0)return 1;

		if (dp.containsKey(n+" "+prev))return dp.get(n+" "+prev);

		long ones=0;
		long zeros=0;
		if (prev!='1')
		ones=countFun(n-1, '1', dp);
		zeros = countFun(n-1, '0', dp);
		dp.put(n+" "+prev, ones+zeros);
		return ones+zeros;
	}
}
