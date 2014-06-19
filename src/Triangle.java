import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Triangle {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		int n = Integer.parseInt(param);
		int[][] grid = new int[n][n];
		for(int i=0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i; j++)
			{
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<n; i++)
		{
			for(int j=0; j<=i; j++)
			{
				if(j>=1)
				grid[i][j] += Math.max(grid[i-1][j-1],grid[i-1][j]);
				else grid[i][j] += grid[i-1][j];
			}
		}
		int max = 0;
		for(int i=0; i<n; i++)
			max = Math.max(max,grid[n-1][i]);
		//for(int i=0; i<n; i++)
			//System.out.println(Arrays.toString(grid[i]));
		System.out.println(max);
		br.close();
		System.exit(0);
	}
}
