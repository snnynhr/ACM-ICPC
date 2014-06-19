import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Difference {
	static int n,m,l,k;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		while(!(param.equals("0 0 0 0")))
		{
			StringTokenizer st = new StringTokenizer(param);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			System.out.println(conv(n,m,l,k));
			param = br.readLine();
		}

		br.close();
		System.exit(0);
	}
	public static int conv(int a, int b, int c, int d)
	{
		int count = 0;
		while(!(a==b && b==c&& c==d))
		{
			int w = Math.abs(a-b);
			int x = Math.abs(b-c);
			int y = Math.abs(c-d);
			int z = Math.abs(a-d);
			a = w;
			b = x;
			c = y;
			d = z;
			count++;
		}
		return count;
	}
}
