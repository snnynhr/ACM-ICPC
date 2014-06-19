import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class pizza 
{
	public void solve() throws IOException  
	{ 
		int cases = nextInt();
		for(int t = 0; t < cases; t++)
		{
			int r = nextInt();
			int n = nextInt();
			double degrees = nextInt();
			degrees += (double)nextInt() / 60;
			degrees += (double)nextInt() / 3600;
			
			ArrayList<Double> cuts = new ArrayList<Double>();
			double cur = 0;
			for(int x = 0; x < Math.min(n, 1296000); x++)
			{
				//if(!cuts.contains(cur))
				cuts.add(cur);
				cur += degrees;
				cur %= 360;
			}
//			
//			Double[] sorted = new Double[cuts.size()];
//			sorted = cuts.toArray(new Double[cuts.size()]);
//			Arrays.sort(sorted);			
//			Double[] sizes = new Double[cuts.size()];
//			for(int x = 0; x < sizes.length; x++)
//			{
//				if(x != sizes.length - 1)
//					sizes[x] = sorted[x + 1] - sorted[x];
//				else
//					sizes[x] = 360 - sorted[x];
//			}
//			Arrays.sort(sizes);
//			
			Collections.sort(cuts);
			Double[] sizes = new Double[cuts.size()];
			double max = 0;
			for(int x = 0; x < sizes.length; x++)
			{
				if(x != sizes.length - 1)
					sizes[x] = cuts.get(x + 1) - cuts.get(x);
				else
					sizes[x] = 360 - cuts.get(x);
			}
			for(int x = 0; x < sizes.length; x++)
				if(sizes[x] > max)
					max = sizes[x];
			
			//System.out.println(sizes[sizes.length - 1]);
			
			Double area = Math.PI * r * r * max / 360;
			System.out.println(area);
		}
	}
	
	public BufferedReader br; 
	public StringTokenizer st; 
	public PrintWriter out; 

	public String nextToken() throws IOException { 
		while(st == null || !st.hasMoreTokens()) { 
			st = new StringTokenizer(br.readLine()); 
		} 

		return st.nextToken(); 
	} 

	public int nextInt() throws IOException { 
		return Integer.parseInt(nextToken()); 
	} 

	public long nextLong() throws  IOException { 
		return Long.parseLong(nextToken()); 
	} 

	public double nextDouble() throws IOException { 
		return Double.parseDouble(nextToken()); 
	} 

	public void run() throws IOException  
	{    
		br = new BufferedReader( new InputStreamReader( System.in )); 
		out = new PrintWriter(System.out); 
		solve(); 
		out.close(); 
	} 

	public static void main(String[] args) throws IOException  
	{ 
		new pizza().run(); 
	}
}
