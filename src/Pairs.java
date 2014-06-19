import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Pairs {
	static int n,m;
	static Pairs p = new Pairs();
	static int pairs[];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		StringTokenizer st = new StringTokenizer(param);
		int N = Integer.parseInt(st.nextToken());
		Node[] vs = new Node[N+1];
		pairs = new int[N+1];
		for(int i=1; i<=N; i++)
		{
			pairs[i] = -1;
			Node x = p.new Node(i);
			vs[i] = x;
		}
		for(int i=1; i<=N; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++)
			{
				int b = Integer.parseInt(st.nextToken());
				vs[a].v.add(b);
			}
		}
		System.out.println(pairs(vs,1));
		br.close();
		System.exit(0);
	}
	public static int pairs(Node[] vs, int root)
	{
		if(pairs[root]!=-1) return pairs[root];
		else
		{
			int max =0;
			if(vs[root].v.size()==0) return 0;
			for(int i=0; i<vs[root].v.size(); i++)
			{
				int res = 0;
				for(int j=0; j<vs[root].v.size(); j++)
				{
					if(j!=i) res+=pairs(vs,vs[root].v.get(j));
				}
				for(int j=0; j<vs[vs[root].v.get(i)].v.size(); j++)
				{
					res+=pairs(vs,vs[vs[root].v.get(i)].v.get(j));
				}
				max = Math.max(max,res);
			}
			pairs[root] = 1+max;
			return pairs[root];
		}
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
