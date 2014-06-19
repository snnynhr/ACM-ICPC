import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class solve {
	static final int DEPTH = 25;
	static int n, e;
	static double a;
	static double[][] adj;
	static double maxSum = 0.0;
	static ArrayList<Integer> best;
	static int Node = 0;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());
		a = Double.parseDouble(br.readLine());
		adj = new double[n][n];
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
		boolean[] v = new boolean[n];
		ArrayList<Integer> p = new ArrayList<Integer>();
		p.add(0);
		v[0] = true;
		dfs(0,0,0,0,v,p,Math.min(DEPTH,n));
		//System.out.println("FINAL SCORE: "+ maxSum);
	}
	public static void check(ArrayList<Integer> p, double score)
	{
		//System.out.println(maxSum);
		if(score>maxSum)
		{
			best = p;
			maxSum = score;
			System.out.println(best.size());
			for(int i=0; i<best.size(); i++)
				System.out.println(best.get(i));
		}
	}
	public static void greedy(int node, int prev, int depth, double score, boolean[] vis, ArrayList<Integer> p)
	{
		int max = -1;
		double m = 0;
		for(int i=0; i<n; i++)
			if(adj[node][i]!=-1 && !vis[i] && i!=prev)
				if(adj[node][i]>m) max = i;
		if(max!=-1)
		{
			double breakpoint = 1/Math.pow(a, depth);
			if(breakpoint>20000)
				check(p,score);
			else
			{
				p.add(max); 
				vis[max] = true;
				greedy(max,node,depth+1,score+Math.pow(a, depth)*adj[node][max], vis, p);
			}
		}
		else
			check(p,score);
	}
	public static void dfs(int node, int prev, int depth, double score, boolean[] vis, ArrayList<Integer> p, int maxd)
	{
		Node = node;
		if(depth == maxd)
		{
			if(score>maxSum)
			{
				best = p;
				maxSum = score;
				boolean[] nvis = Arrays.copyOf(vis, vis.length);
				ArrayList<Integer> tmp = new ArrayList<Integer>();
				for(int i=0; i<p.size(); i++) 
					tmp.add(p.get(i));
				greedy(node,prev,depth,score,nvis,tmp);
			}
		}
		else
		{
			PriorityQueue<Integer> Q = new PriorityQueue<Integer>(201,new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					if(adj[Node][o1]>adj[Node][o2]) return 1;
					else if(adj[Node][o1]<adj[Node][o2]) return -1;
					return 0; 	}});
			boolean f = false;
			for(int i=0; i<n; i++)
				if(adj[node][i]!=-1 && !vis[i] && i!=prev)
				{
					Q.add(i);
					f = true;
				}
			while(!Q.isEmpty())
			{
				int c = Q.poll();
				vis[c] = true;
				p.add(c);
				dfs(c,node,depth+1,score+Math.pow(a, depth)*adj[node][c], vis, p, maxd);
				p.remove(p.size()-1);
				vis[c] = false;
			}
			if(!f && score>maxSum)
				check(p,score);
		}
	}
}
