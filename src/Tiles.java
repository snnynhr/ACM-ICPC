import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Tiles {
	static int n,m;
	static int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73};
	static double min = Double.MAX_VALUE;
	static long minn = Long.MAX_VALUE;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		while(!(param.equals("0")))
		{
			StringTokenizer st = new StringTokenizer(param);
			n = Integer.parseInt(st.nextToken());
			min = Double.MAX_VALUE;
			minn = Long.MAX_VALUE;
			if(n==1)
				System.out.println(1);
			else
			{
				ArrayList<Integer> xx = new ArrayList<Integer>();
				xx.add(2*n-1);
				gen(xx);
				ArrayList<Integer> xy = new ArrayList<Integer>();
				xy.add(2*n);
				gen(xy);
				//2System.out.println(min);
				System.out.println(minn);
			}
			param = br.readLine();
		}

		br.close();
		System.exit(0);
	}
	public static void gen(ArrayList<Integer> x)
	{
		Collections.sort(x);
		//System.out.println(Arrays.toString(x.toArray()));
		double res = 1.0;
		for(int i=x.size()-1; i>=0; i--)
		{
			res *= Math.pow(primes[x.size()-1-i],x.get(i)-1);
			//if(res>Long.MAX_VALUE) System.out.println(res);
		}
		//System.out.println(res);
		if(res!=1.0 && res<=Long.MAX_VALUE)
		{	
			min = Math.min(min,res);
			minn = Math.min(minn,(long)res);
		}
		for(int k=0; k<x.size(); k++)
			for(int i=2; i<=Math.sqrt(x.get(k)); i++)
			{
				if(x.get(k)%i==0)
				{
					ArrayList<Integer> y = new ArrayList<Integer>();
					for(int l=0; l<x.size(); l++) y.add(x.get(l));
					int re = y.remove(k);
					y.add(re/i);
					y.add(i);
					gen(y);
				}
			}
	}
}
