import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Skyline {
	static long[] x;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		comp();
		int n = Integer.parseInt(br.readLine());
		while(n!=0)
		{
			System.out.println(x[n]);
			n = Integer.parseInt(br.readLine());
		}
		br.close();
	}
	public static void comp()
	{
		x = new long[1001];
		long mod = 1000000;
		x[0] = 1;
		for(int i=1; i<=1000; i++)
		{
			for(int j=0; j<i; j++)
			{
				x[i]+=x[j]*x[i-1-j];
				x[i]%=mod;
			}
		}
	}
}
