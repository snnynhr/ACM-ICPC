import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Robots {
	static int n,m;
	static long[][] dp;
	static long mod = Integer.MAX_VALUE;
	static boolean f = false;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		n = Integer.parseInt(param);
		char[][] grid = new char[n][n];
		for(int i=0; i<n; i++)
		{
			String s = br.readLine();
			for(int j=0; j<n; j++)
				grid[i][j] = s.charAt(j);
		}
		dp = new long[n][n];
		dp[0][0] = 1;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(!(i==0&&j==0))
				{
					long sum = 0;
					if(isV(i-1,j)&&grid[i-1][j]=='.')
						sum += dp[i-1][j];
					if(isV(i,j-1)&&grid[i][j-1]=='.')
						sum += dp[i][j-1];
					sum %= mod;
					dp[i][j] = sum;
				}
			}
		}
		boolean[][] v = new boolean[n][n];
		dfs(grid,0,0,v);
		if(dp[n-1][n-1]!=0)
			System.out.println((dp[n-1][n-1]+mod)%mod);
		else if(f)
			System.out.println("THE GAME IS A LIE");
		else
			System.out.println("INCONCEIVABLE");
		br.close();
		System.exit(0);
	}
	public static void dfs(char[][] grid, int x, int y, boolean[][] vis)
	{
		if(x == n-1 && y == n-1) f = true;
		else
		{
			vis[x][y] = true;
			if(isV(x-1,y)&& !vis[x-1][y] && grid[x-1][y]=='.')
			{
				dfs(grid,x-1,y,vis);
			}
			if(isV(x+1,y)&& !vis[x+1][y] && grid[x+1][y]=='.')
			{
				dfs(grid,x+1,y,vis);
			}
			if(isV(x,y-1)&& !vis[x][y-1] && grid[x][y-1]=='.')
			{
				dfs(grid,x,y-1,vis);
			}
			if(isV(x,y+1)&& !vis[x][y+1] && grid[x][y+1]=='.')
			{
				dfs(grid,x,y+1,vis);
			}
		}
	}
	public static boolean isV(int x, int y)
	{
		return x>=0 && y>=0 && x<n && y<n;
	}
}
