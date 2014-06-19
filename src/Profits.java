import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Profits {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while(n!=0)
		{
			int[] x = new int[n];
			for(int i=0; i<n; i++)
			{
				x[i] = Integer.parseInt(br.readLine());
			}
			System.out.println(solve(x));
			n = Integer.parseInt(br.readLine());
		}
		br.close();
		//System.out.println(solve(new int[] {-3,4,9,-2,-5,8}));
		System.exit(0);
	}
	public static int solve(int[] x)
	{
		int mmax = Integer.MIN_VALUE;
		boolean c = true;
		for(int i=0; i<x.length; i++)
		{
			if(x[i]>=0){
				c = false;
			}
			else
			{
				mmax = Math.max(x[i], mmax);
			}
		}
		if(c) return mmax;
		int me = 0,max = 0;
		for(int i=0; i<x.length; i++)
		{
			me = Math.max(0, me + x[i]);
			max = Math.max(max, me);
		}
		return max;
	}
}
