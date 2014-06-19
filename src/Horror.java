import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Horror {
	static int N,H,L;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();

		StringTokenizer st = new StringTokenizer(param);
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		param = br.readLine();
		st = new StringTokenizer(param);
		int[] list = new int[H];
		int[] h = new int[N];
		for(int i=0; i<N; i++)
			h[i] = Integer.MAX_VALUE;
		for(int i=0; i<H; i++)
		{
			list[i] = Integer.parseInt(st.nextToken());
			h[list[i]] = 0;
		}
		int[][] adj = new int[N][N];
		for(int i=0; i<L; i++)
		{
			param = br.readLine();
			st = new StringTokenizer(param);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<H; i++)
			q.add(list[i]);
		boolean[] vis = new boolean[N];
		while(!q.isEmpty())
		{
			int curr = q.poll();
			if(!vis[curr])
			{
				vis[curr] = true;
				for(int i=0; i<N; i++)
				{
					if(adj[curr][i]==1)
					{
						h[i] = Math.min(h[i], h[curr]+1);
						if(!vis[i]) q.add(i);
					}
				}
			}
		}
		int maxID = 0;
		int max = h[0];
		for(int i=1; i<N; i++)
		{
			if(h[i]>max)
			{
				max = h[i];
				maxID = i;
			}
		}
		System.out.println(maxID);
		br.close();
		System.exit(0);
	}
}
