import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hero {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		n = Integer.parseInt(param);
		int sum = 0;
		for(int i=0; i<n; i++)
			sum+=solve(br.readLine());
		System.out.println(sum);
		br.close();
		System.exit(0);
	}
	public static int solve(String s)
	{
		if(s.contains("CD")) return 0;
		return 1;
	}
}
