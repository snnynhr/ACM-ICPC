import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ants {
	static int n,m;
	static int[][] dist;
	static boolean[][] v;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		int n = Integer.parseInt(param);
		for(int i=0; i<n; i++)
		{
			br.readLine();
			int[][] grid = new int[241][241];
			int x = 120;
			int y = 120;
			grid[x][y] = 1;
			int m = Integer.parseInt(br.readLine());
			for(int j=0; j<m; j++)
			{
				char a = br.readLine().charAt(0);
				if(a=='S')
				{
					y-=1;
					grid[x][y]=1;
					y-=1;
					grid[x][y]=1;
				}
				else if(a=='N')
				{
					y+=1;
					grid[x][y]=1;
					y+=1;
					grid[x][y]=1;
				}
				else if(a=='E')
				{
					x+=1;
					grid[x][y]=1;
					x+=1;
					grid[x][y]=1;
				}
				else if(a=='W')
				{
					x-=1;
					grid[x][y]=1;
					x-=1;
					grid[x][y]=1;
				}
			}
			dist = new int[241][241];
			for(int j=0; j<241; j++)
			{
				for(int k=0; k<241; k++)
				{
					dist[j][k]= Integer.MAX_VALUE;
				}
			}
			dist[120][120] = 0;
			v= new boolean[241][241];
			dfs(120,120,grid,v);
			//for(int j=0; j<121; j++)
				//System.out.println(Arrays.toString(dist[j]));
			System.out.println(dist[x][y]);
		}
		br.close();
		System.exit(0);
	}
	public static void dfs(int x, int y, int[][] grid, boolean[][] vis)
	{
		vis[x][y]=true;
		if(isValid(x+2,y,grid) && grid[x+1][y]==1 && grid[x+2][y]==1)
		{
			dist[x+2][y] = Math.min(dist[x+2][y],dist[x][y]+1);
			if(!vis[x+2][y]) dfs(x+2,y,grid,vis);
		}
		if(isValid(x-2,y,grid) && grid[x-1][y]==1 && grid[x-2][y]==1)
		{
			dist[x-2][y] = Math.min(dist[x-2][y],dist[x][y]+1);
			if(!vis[x-2][y]) dfs(x-2,y,grid,vis);
		}
		if(isValid(x,y+2,grid) && grid[x][y+1]==1 && grid[x][y+2]==1)
		{
			dist[x][y+2] = Math.min(dist[x][y+2],dist[x][y]+1);
			if(!vis[x][y+2]) dfs(x,y+2,grid,vis);
		}
		if(isValid(x,y-2,grid) && grid[x][y-1]==1 && grid[x][y-2]==1)
		{
			dist[x][y-2] = Math.min(dist[x][y-2],dist[x][y]+1);
			if(!vis[x][y-2]) dfs(x,y-2,grid,vis);
		}
		
	}
	public static boolean isValid(int x, int y, int[][] grid)
	{
		return x>=0 && y>=0 && x<grid.length && y<grid[0].length;
	}
	
}
