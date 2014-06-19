import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class GameOutcome {
	static int n;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		int[][] matrix = new int[n][n];
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
			{
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int c =0;
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
			{
				if(find(i,j,matrix)) c++;
			}
		System.out.println(c);
		br.close();
		System.exit(0);
	}
	public static boolean find(int r, int c, int[][] mat)
	{
		int rsum = 0;
		int csum=0;
		for(int i=0; i<n; i++)
		{
			csum+=mat[i][c];
		}
		for(int i=0; i<n; i++)
		{
			rsum+=mat[r][i];
		}
		if(csum>rsum) return true;
		else return false;
	}
}
