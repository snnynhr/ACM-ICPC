import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Vampire {
	static int n,m;
	static ArrayList<Long> v = new ArrayList<Long>();
	public static void main(String args[]) throws IOException
	{
		long s = System.currentTimeMillis();
		generate();
		Collections.sort(v);
		//System.out.println(v.size());
		BufferedReader br;
		//System.out.println("start");
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		while(!(param.equals("0")))
		{
			//System.out.println("afsd");
			n = Integer.parseInt(param);
			int r = searchG(n);
			//System.out.println("afsde");			
			if(v.get(r)>=n) 
				System.out.println(v.get(r));
			else
				System.out.println(v.get(r+1));
			param = br.readLine();
		}
		//br.close();
		//System.out.println("time "+(System.currentTimeMillis()-s));
		System.exit(0);
	}
	static int searchG(int n)
	{
		int lower = 0;
		int upper = v.size();
		int mid = upper/2;
		long ms = v.get(mid+1);
		while (!(v.get(mid) <= n && (ms > n)))
		{
			if(mid==0) return 0;
			mid = lower + (upper - lower)/2;
			long s = v.get(mid);
			if (s > n)
				upper = mid;
			else if (s < n)
				lower = mid;
			else 
				return mid;
			ms = v.get(mid+1);
		}
		return mid;
	}
	public static void generate()
	{
		int c =0;
		int cc=0;
		int bound = 1000256;
		for(long i=1; i<=bound; i++)
		{
			for(long j=i; j<=bound/i; j++)
			{
				c++;
				long res = i*j;
				int a = len(res);
				int b = len(i)+len(j);
				if(a>b) break;
				if(a==b)
				{
					//System.out.println(res+" "+i+" "+j);
					cc++;
					if(check(res,i,j)) v.add(res);
				}
			}
		}
		//System.out.println(cc);
		//System.out.println(c);

	}
	public static int len(long num)
	{
		return (int)(Math.log10(num)+1);
	}
	public static boolean check(long a, long b,long c)
	{
		StringBuilder ss = new StringBuilder();
		ss.append(a);
		StringBuilder tt = new StringBuilder();
		tt.append(b);
		tt.append(c);
		int[] num = new int[10];
		for(int i=0; i<ss.length(); i++)
			num[ss.charAt(i)-48]++;
		for(int i=0; i<tt.length(); i++)
			num[tt.charAt(i)-48]--;
		for(int i=0; i<10; i++)
		{
			if(num[i]!=0) return false;
		}
		return true;
	}
}
