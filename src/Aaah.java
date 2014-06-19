import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Aaah {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		String a = br.readLine();
		if(a.length()<=param.length()) 
			System.out.println("go");
		else System.out.println("no");
		br.close();
		System.exit(0);
	}
}
