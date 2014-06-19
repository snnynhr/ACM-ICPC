import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Heart {
	static int n,m;
	static Heart h = new Heart();
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		while(!(param.equals("0 0")))
		{
			StringTokenizer st = new StringTokenizer(param);
			int N = Integer.parseInt(st.nextToken());
			int T= Integer.parseInt(st.nextToken());
			int[] tps = new int[N];
			//int[][] adj = new int[N][N];
			Node[] vs = new Node[N];
			for(int i=0; i<N; i++)
				vs[i] = h.new Node(i);
			int[] numadj = new int[N];
			for(int i=0; i<N; i++)
			{
				st = new StringTokenizer(br.readLine());
				tps[i] = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				numadj[i] = num;
				for(int j=0; j<num; j++)
				{
					int x = Integer.parseInt(st.nextToken());
					vs[i].v.add(x);
				}
			}
			//check
			int[] totals = new int[N];
			for(int i=0; i<N; i++)
			{
				int sum=0;
				for(int j=0; j<vs[i].v.size(); j++)
					sum+=tps[vs[i].v.get(j)];
				sum+=tps[i];
				totals[i] = sum;
			}
			boolean[] dead = new boolean[N];
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(0);
			while(!q.isEmpty())
			{
				int curr = q.poll();
				if(numadj[curr]>0)
				{
					numadj[curr]--;
					if(totals[curr]<T) dead[curr] = true;
					for(int j=0; j<vs[curr].v.size(); j++)
					{
						int i = vs[curr].v.get(j);
						if(dead[curr]&&!dead[i]) totals[i] -=tps[curr];
						if(!dead[i] && numadj[i]>0) q.add(i);
					}
					/*for(int i=0; i<N; i++)					{if(adj[curr][i]==1){							if(dead[curr]&&!dead[i]) totals[i] -=tps[curr];					if(!dead[i]) q.add(i);		}			}*/
				}
			}
			//
			int nh = 0;
			int h = 0;
			for(int i=0; i<N; i++)
			{
				int sum=0;
				for(int j=0; j<vs[i].v.size(); j++)
				{
					int k = vs[i].v.get(j);
					if(totals[k]>=T)
					{
						sum+=tps[k];
					}
				}
				sum+=tps[i];
				if(sum>=T) 
				{
					h++;
					nh+=tps[i];
				}
			}
			System.out.println(h+" "+nh);
			param = br.readLine();
		}
		br.close();
		System.exit(0);
	}
	public class Node
	{
		int id;
		ArrayList<Integer> v;
		Node(int x)
		{
			id = x;
			v = new ArrayList<Integer>();
		}
	}
}

