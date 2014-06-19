import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Vampires {
	static int v,o,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		int tc = 0;
		int N = 100;
		while(!(param.equals("0 0 0")))
		{
			tc++;
			System.out.println("Case "+tc+":");
			int[][] grid = new int[N+1][N+1];
			StringTokenizer st = new StringTokenizer(param);
			v = Integer.parseInt(st.nextToken());
			o = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			int[][] vs = new int[v][2];
			int[][] os = new int[o][2];
			for(int i=0; i<v; i++)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				grid[x][y] = 1;
				vs[i][0] = x;
				vs[i][1] = y;
			}
			for(int i=0; i<o; i++)
			{
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				grid[x][y] = -1;
				os[i][0] = x;
				os[i][1] = y;
			}
			for(int i=0; i<m; i++)
			{
				int num=-8;
				st = new StringTokenizer(br.readLine());
				char dir = st.nextToken().charAt(0);
				if(dir == 'N') num = 3;
				else if(dir =='E') num = 5;
				else if(dir == 'W') num = 4;
				else if(dir == 'S') num = 6;
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				//System.out.println(w + " "+x+" "+y +" "+z);
				for(int j=x; j<=w; j++)
					for(int k= y; k<=z; k++)
						grid[j][k] = num;
				for(int j=w; j<=x; j++)
					for(int k= z; k<=y; k++)
						grid[j][k] = num; 
			}
			//for(int i=0; i<=N; i++)
				//System.out.println(Arrays.toString(grid[i]));
			boolean rs = false;
			for(int i=0; i<v; i++)
			{
				String res = "vampire "+(i+1);
				int x = vs[i][0];
				int y = vs[i][1];
				boolean isM;
				//System.out.println(x + " "+ y);

				isM = false;
				for(int j=x+1; j<=N; j++)
				{
					int c = grid[j][y];
					if(c!=0 && c!= 4 && c!=1) isM = true;
					if(c==4)
					{
						if(!isM) res +=" east";
						break;
					}
				}
				isM = false;
				for(int j=y+1; j<=N; j++)
				{
					int c = grid[x][j];
					if(c!=0 && c!= 6&&c!=1) isM = true;
					if(c==6)
					{
						if(!isM) res +=" north";
						break;
					}
				}
				isM = false;
				for(int j=y-1; j>=0; j--)
				{
					int c = grid[x][j];
					if(c!=0 && c!= 3&c!=1) isM = true;
					if(c==3)
					{
						if(!isM) res +=" south";
						break;
					}
				}
				isM = false;
				for(int j=x-1; j>=0; j--)
				{
					int c = grid[j][y];
					if(c!=0 && c!= 5&&c!=1) isM = true;
					if(c==5)
					{
						if(!isM) res +=" west";
						break;
					}
				}
				if(!res.equals("vampire "+(i+1)))
				{
					rs = true;
					System.out.println(res);
				}
			}
			if(!rs) System.out.println("none");
			param = br.readLine();
		}

		br.close();
		System.exit(0);
	}
}
