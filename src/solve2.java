import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class solve2 {
	static int n, e;
	static double a;
	static double[][] adj;
	static double maxSum = 0.0;
	static int[] prev,step;
	static double[] dp;
	static solve2 x= new solve2();
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());
		a = Double.parseDouble(br.readLine());
		adj = new double[n][n];
		prev  = new int[n];
		step  = new int[n];
		dp = new double[n];
		for(int i=0; i<n; i++) Arrays.fill(adj[i], -1);
		for(int i=0; i<e; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			double w = Double.parseDouble(st.nextToken());
			adj[v1][v2] = w;
			adj[v2][v1] = w;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		//Queue<P> q = new LinkedList<P>();
		//
		//for(int i=0; i<n; i++)
		//	if(adj[0][i]!=-1)
		//		q.add(x.new P(0,i));
		boolean[] vis = new boolean[n];
		q.add(0);
		while(!q.isEmpty())
		{
			int cur = q.poll();
			//int p = cur.prev;
			//int c = cur.curr;
			if(!vis[cur])
			{
				vis[cur] = true;
				for(int i=0; i<n; i++)
				{
					if(adj[cur][i]!=-1)
					{
						if(!vis[i]) 
						{
							q.add(i);
							step[i] = step[cur]+1;
							if(dp[i]<dp[cur]+Math.pow(1-a, step[i])*adj[cur][i])
							{
								dp[i] = dp[cur] + Math.pow(1-a, step[i])*adj[cur][i];
								prev[i] = cur;
								
							}
						}
					}

				}
			}
		}
		System.out.println(Arrays.toString(dp));
		int max = 0;
		for(int i=0; i<n; i++)
		{
			if(dp[i]>maxSum)
			{
				max = i;
				maxSum = dp[i];
			}
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		while(max!=0)
		{
			path.add(max);
			max = prev[max];
		}
		path.add(0);
		int l = path.size();
		for(int i=0; i<l; i++)
		{
			System.out.println(path.get(l-i-1));
		}

	}
	class P
	{
		int prev;
		int curr;
		public P(int a, int b)
		{
			prev = a;
			curr = b;
		}
	}
}
