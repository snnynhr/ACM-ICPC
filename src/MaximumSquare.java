import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class MaximumSquare {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		while(!(param.equals("0 0")))
		{
			StringTokenizer st = new StringTokenizer(param);

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			int[][] c = new int[n][m];
			for(int i=0; i<n; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++)
				{
					c[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			solve(n,m,c);
			param = br.readLine();
		}

		br.close();
		System.exit(0);
	}
	public static void solve(int n, int m, int[][] c)
	{
		int[][] dp = new int[n][m];
		for(int i=0; i<n; i++)
			dp[i][0] = c[i][0];
		for(int i=0; i<m; i++)
			dp[0][i] = c[0][i];
		for(int i=1; i<n; i++)
		{
			for(int j=1; j<m; j++)
			{
				if(c[i][j]==1)
					dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j-1]),dp[i-1][j])+1;
				else dp[i][j]=0;
			}
		}
		int max = 0;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				max = Math.max(max,dp[i][j]);
			}
		}
		System.out.println(max);
	}
}
