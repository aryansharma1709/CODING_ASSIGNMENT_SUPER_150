import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        System.out.print(count(n));
    }
    public static int count(int n) {
        if (n == 1) return 0;
        if (n < 1)  return Integer.MAX_VALUE;

        int ans = 0;
        if (n % 2 == 0) 
            ans = 1 + count(n/2);
        else {
            int add = 1 + count(n+1);
            int sub = 1 + count(n-1);
            ans = Math.min(add, sub);
        }
        return ans;
    }
}