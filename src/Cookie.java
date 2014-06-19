import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Cookie {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		int n = Integer.parseInt(param);
		String test = br.readLine();
		System.out.println(ret(n,test));
		br.close();
		System.exit(0);
	}
	public static int ret(int n, String s)
	{
		int count = 0;
		int m = 0; 
		int w = 0;
		int l = s.length();
		for(int i=0; i<l; i++)
		{
			//System.out.println(s);
			if(s.charAt(i)=='M')
			{
				if(Math.abs(m+1-w)<=n)
				{
					m++;
					count++;
				}
				else 
				{
					if(i+1<=s.length() && s.charAt(i+1)=='W')
					{
						s = swap(s,i);
						w+=1;
						count++;
					}
					else

						return count;
				}
			}
			else
			{
				if(Math.abs(w+1-m)<=n)
				{
					w++;
					count++;
				}
				else 
				{
					if(i+1<=s.length() && s.charAt(i+1)=='M')
					{
						swap(s,i);
						m+=1;
						count++;
					}
					else
						return count;
				}
			}
		}
		return count;
	}
	public static String swap(String s, int i)
	{
		String a = s.substring(0,i);
		String b = s.substring(i+2);
		String c = s.charAt(i)+"";
		String d = s.charAt(i+1)+"";
		return a+d+c+b;
	}
}
