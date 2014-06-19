import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Postcards {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String res = br.readLine();
		//String res = "CCCCCCCCCC";
		int i=0;
		int c=0;
		d: while(i<res.length())
		{
			boolean check = true;
			char comp = res.charAt(i);
			for(int j=i; j<i+5; j++)
			{
				if(j>=res.length())
				{
					c++;
					break d;
				}
				if(res.charAt(j)!=comp)
				{
					c++;
					i=j;
					check = false;
					break;
				}

			}
			if(check)
			{
				c++;
				i+=5;
			}
		}
		System.out.println(c);
		br.close();
		System.exit(0);
	}
}
