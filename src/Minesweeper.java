import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Minesweeper {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		while(!(param.equals("0 0")))
		{
			StringTokenizer st = new StringTokenizer(param);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			char[][] x = new char[n][m];
			for(int i=0; i<n; i++)
			{
				String s = br.readLine();
				for(int j=0; j<m; j++)
				{
					x[i][j] = s.charAt(j);
				}
			}
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++)
				{
					if(x[i][j]=='.')
					{
						int count = 0;
						if(isV(i+1,j,n,m) && x[i+1][j]=='*')
							count++;
						if(isV(i-1,j,n,m) && x[i-1][j]=='*')
							count++;
						if(isV(i,j+1,n,m) && x[i][j+1]=='*')
							count++;
						if(isV(i,j-1,n,m) && x[i][j-1]=='*')
							count++;
						if(isV(i+1,j+1,n,m) && x[i+1][j+1]=='*')
							count++;
						if(isV(i+1,j-1,n,m) && x[i+1][j-1]=='*')
							count++;
						if(isV(i-1,j+1,n,m) && x[i-1][j+1]=='*')
							count++;
						if(isV(i-1,j-1,n,m) && x[i-1][j-1]=='*')
							count++;
						char z = (char) (count + 48);
						x[i][j] = z;
					}
				}
			}
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++)
				{
					System.out.print(x[i][j]);
				}
				System.out.println();
			}
			param = br.readLine();
		}
		
		br.close();
		System.exit(0);
	}
	public static boolean isV(int i, int j, int n, int m)
	{
		return i>=0 && j>=0 && i<n && j<m;
	}
}
