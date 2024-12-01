import java.util.*;
public class Main {
    public static void main(String args[])
	 {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int m=s.nextInt();
		int count=sum(n, m, 0);
		System.out.println();
		System.out.print(count);
    }
	public static int sum(int n, int m, int path)
	{
		if (n==0) 
		{
			System.out.print(path + " ");
			return 1;
		}
		if(n<0)return 0;

		int count=0;
		for (int i=1; i<=m; i++)
		{
			count+=sum(n-i, m, path*10 + i);
		}
		return count;
	}
}