import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class plot {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		StringTokenizer st = new StringTokenizer(param);
		int n = Integer.parseInt(st.nextToken());
		int[] coeff = new int[n+1];
		for(int i=0; i<n+1; i++)
			coeff[i] = Integer.parseInt(st.nextToken());
		int[][] r = new int[n+1][n+1];
		for(int i=0; i<n+1; i++)
			r[0][i] = eval(coeff,i);
		for(int i=1; i<n+1; i++)
		{
			for(int j=0; j<n+1-i; j++)
			{
				r[i][j] = r[i-1][j+1]-r[i-1][j];
			}
		}
		String s = "";
		for(int i=0; i<n+1; i++)
			s+=r[i][0]+" ";
		System.out.println(s.trim());
		br.close();
		System.exit(0);
	}
	public static int eval(int[] coeff, int x)
	{
		int sum = 0;
		int l = coeff.length;
		for(int i=0; i<l; i++)
		{
			int res =(int)Math.pow(x,l-i-1);
			sum += res*coeff[i];
		}
		return sum;
	}
}
