import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Oddities {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		int n = Integer.parseInt(param);
		for(int i=0; i<n; i++)
		{
			int x =Integer.parseInt(br.readLine()); 
			if(x%2==0)
				System.out.println(x+" is even");
			else 
				System.out.println(x+" is odd");
		}
		br.close();
		System.exit(0);
	}
}
