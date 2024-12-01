import java.util.*;
public class Main {
    public static void main(String args[]) {
		Scanner s= new Scanner(System.in);
		int n = s.nextInt();

		HashMap<Integer, Long> dp = new HashMap<>();
		System.out.print(gold(n, dp));
    }
	public static long gold(int n, HashMap<Integer, Long> dp) {
		if (n == 0)	return 0;

		if (dp.containsKey(n))	return dp.get(n);

		long exchange = gold(n/2, dp) + gold(n/3, dp) + gold(n/4, dp);
		long no_exchange = n;

		dp.put(n, Math.max(exchange, no_exchange));
		return Math.max(exchange, no_exchange);
	}
}