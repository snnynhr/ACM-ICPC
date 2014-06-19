import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Trace {
	static int n;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] rad = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
		{
			rad[i+1] = Integer.parseInt(st.nextToken());
		}
		rad[0]=0;
		Arrays.sort(rad);
		int sum = 0;
		for(int i=rad.length-1; i>0; i-=2)
		{
			int res = rad[i]*rad[i]-rad[i-1]*rad[i-1];
			sum+=res;
			
		}
		double s = sum;
		s*=Math.PI;
		System.out.println(s);
		br.close();
		System.exit(0);
	}
}
