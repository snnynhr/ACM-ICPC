import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Goldbach {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		boolean[] p = new boolean[32001];
		for(int i=2; i<p.length; i++)
			if(isPrime(i)) p[i]=true;
		int n = Integer.parseInt(param);
		for(int i=0; i<n; i++)
		{
			ArrayList<String> s = new ArrayList<String>();
			int c = 0;
			int m = Integer.parseInt(br.readLine());
			for(int j=2; j<=m/2; j++)
			{
				if(p[j]&&p[m-j])
				{
					c++;
					s.add(j+"+"+(m-j));
				}
			}
			System.out.println(m +" has "+c+" representation(s)");
			for(int j=0; j<c; j++) System.out.println(s.get(j));
			if(i!=n-1) System.out.println();
		}
		br.close();
		System.exit(0);
	}
	public static boolean isPrime(int x)
	{
		//naive algorithm runtime sqrt(x)/4 + 2 for all x>=0;
		if(x==2 || x==3) return true;
		if(x==1 || x%2==0 || x%3==0) return false;
		int z=(int)Math.sqrt(x);
		for(int i=5; i<=z; i+=2)//+((i-1)%4))
			if(x%i==0) return false;
		return true;
	}
}
