import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Trees {
	static int n,m;
	static int[] cyc;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		int testcounter=0;
		while(!(param.equals("0 0")))
		{
			StringTokenizer st = new StringTokenizer(param);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int[][] adj = new int[n][n];
			for(int i=0; i<n; i++) Arrays.fill(adj[i], Integer.MAX_VALUE);
			for(int i=0; i<m; i++)
			{
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a-1][b-1] = 1;
				adj[b-1][a-1] = 1;
			}
			int[] v = new int[n];
			boolean[] visited = new boolean[n];
			int c = 0;
			for(int i=0; i<n; i++)
				if(!visited[i]) dfs(adj,v,++c,visited,i);
			cyc = new int[n];
			boolean[] tv = new boolean[c+1];
			for(int i=0; i<n; i++)
			{
				if(!tv[v[i]])
				{
					
					//visited[i] = true;
					for(int j=0; j<n; j++)
					{

						visited = new boolean[n];
						if(adj[i][j]==1 && !visited[j]) cycdfs(adj,visited,j,j,i,v);

					}
					if(cyc[i]!=0)
					tv[v[i]]=true;
				}
			}
			//System.out.println(Arrays.toString(cyc));
			boolean[] dd = new boolean[c+1];
			for(int i=0; i<cyc.length; i++)
				dd[cyc[i]]= true;
			int numcyc=0;
			for(int i=1; i<dd.length; i++)
				if(dd[i]) numcyc++;
			int res = c - numcyc;
			if(res==0)
				System.out.println("Case "+(++testcounter)+": No trees.");
			else if(res==1)
				System.out.println("Case "+(++testcounter)+": There is one tree.");
			else
				System.out.println("Case "+(++testcounter)+": A forest of " + res +" trees.");
			param = br.readLine();
		}

		br.close();
		System.exit(0);
	}
	public static void cycdfs(int[][] adj, boolean[] vis, int x, int y, int start, int[] v)
	{
		//System.out.println(x+","+y+","+start);
		if(y == start && x!=y) cyc[start] = v[start];
		else
		{
			vis[y] = true;
			for(int i=0; i<n; i++)
			{
				if(!(y==x && i==start))
					if(adj[y][i]==1 && !vis[i]) cycdfs(adj,vis,x,i,start,v);
			}
		}
	}
	public static void dfs(int[][] adj, int[] v, int cc, boolean[] vis, int x)
	{
		vis[x] = true;
		v[x] = cc;
		for(int i=0; i<n; i++)
		{
			if(adj[x][i]==1 && !vis[i]) dfs(adj,v,cc,vis,i);
		}
	}
}
