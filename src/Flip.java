import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Flip {
	static int n,m;
	static Flip xx = new Flip();
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		int tc = 0;
		while(!param.equals("0 0"))
		{
			tc++;
			StringTokenizer st = new StringTokenizer(param);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			Node[][] x = new Node[n][m];
			for(int i=0; i<n; i++)
				for(int j=0; j<m; j++)
					x[i][j] = xx.new Node();
			for(int i=0; i<n; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++)
				{
					x[i][j].s.push(Integer.parseInt(st.nextToken()));
				}
			}
			String moves = br.readLine();
			int l = 0;
			int r = m-1;
			int u = 0;
			int d = n-1;
			for(int i=0; i<n+m-2; i++)
			{
				if(moves.charAt(i)=='L')
				{
					for(int j=0; j<n; j++)
					{
						while(!x[j][l].s.isEmpty())
						{
							x[j][l+1].s.push(x[j][l].s.pop()*-1);
						}
					}
					l++;
				}
				else if(moves.charAt(i)=='R')
				{
					for(int j=0; j<n; j++)
					{
						while(!x[j][r].s.isEmpty())
						{
							x[j][r-1].s.push(x[j][r].s.pop()*-1);
						}
					}
					r--;
				}
				else if(moves.charAt(i)=='T')
				{
					for(int j=0; j<m; j++)
					{
						while(!x[u][j].s.isEmpty())
						{
							x[u+1][j].s.push(x[u][j].s.pop()*-1);
						}
					}
					u++;
				}
				else
				{
					for(int j=0; j<m; j++)
					{
						while(!x[d][j].s.isEmpty())
						{
							x[d-1][j].s.push(x[d][j].s.pop()*-1);
						}
					}
					d--;
				}
			}
			String res = "";
			for(int i=0; i<n; i++)
				for(int j=0; j<m; j++)
				{
					if(x[i][j].s.size()>0)
					{
						Stack<Integer> t = new Stack<Integer>();
						while(!x[i][j].s.isEmpty())
							t.push(x[i][j].s.pop());
						while(!t.isEmpty())
						{
							int z = t.pop();
							if(z>0) res = res + " " + z;
						}
					}
				}
			System.out.println("Case "+tc+":"+res);
			param = br.readLine();
		}
		br.close();
		System.exit(0);
	}
	class Node
	{
		Stack<Integer> s;
		public Node()
		{
			s = new Stack<Integer>();
		}
	}
}
