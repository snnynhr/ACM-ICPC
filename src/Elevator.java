import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Elevator {
	static int f,s,g,u,d;
	static int min = Integer.MAX_VALUE;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		StringTokenizer st = new StringTokenizer(param);
		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		dfs(f,s,g,u,d,0);
		if(min==Integer.MAX_VALUE) 
			System.out.println("use the stairs");
		else System.out.println(min);
		br.close();
		System.exit(0);
	}
	public static void dfs(int f, int s, int g, int u, int d, int iter)
	{
		for(int i =0; i<10000000; i++)
		{
			if(s==g) 
			{
				min = i;
				break;
			}
			if(s<g)
			{
				if(s+u<=f)
					s+=u;
				else if(s-d>=0)
					s-=d;
				else
					break;
			}
			else
			{
				if(s-d>=0)
					s-=d;
				else if(s+u<=f)
					s+=u;
				else
					break;
			}
		}
	}
}
