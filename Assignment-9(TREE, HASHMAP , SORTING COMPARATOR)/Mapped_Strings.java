import java.util.*;
public class Main {
    public static void main(String args[]) {
        // Your Code Here
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		List<String> l = new ArrayList<>();
        solveFun(s, "", l);
		Collections.sort(l);

		for (String str : l) {
			System.out.println(str);
		}
    }
    public static void solveFun(String que, String ans, List<String> l) {
        if (que.length() == 0) {
            l.add(ans);
            return;
        }

        for (int i = 1; i <= que.length(); i++) {
            String temp = que.substring(0, i);
            int val = Integer.valueOf(temp);
            if (val > 0 && val <= 26) {
                char ch = (char)(val + 64);
                solveFun(que.substring(i), ans+ch, l);
            }
        }
    }
}