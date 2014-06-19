import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.regex.*;

public class Ls {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String pattern = br.readLine();
		String param = br.readLine();
		n = Integer.parseInt(param);
		for(int i=0; i<n; i++)
		{
			String s = br.readLine();
			if(parse(s,pattern)) System.out.println(s);
		}
		br.close();
		System.exit(0);
	}
	public static boolean parse(String p, String pat)
	{
		p = "a"+p+"a";
		pat = "a" + pat + "a";
		StringTokenizer st = new StringTokenizer(pat,".");
		StringTokenizer pp = new StringTokenizer(p,".");
		while(st.hasMoreTokens())
		{
			String curr = st.nextToken();
			if(!pp.hasMoreTokens()) return false;
			String comp = pp.nextToken();
			if(!curr.equals("*"))
			{
				Pattern ppp = Pattern.compile(compiler(curr));
				Matcher m = ppp.matcher(comp);
				boolean b = m.matches();
				if(!b) return false;
			}
		}
		return true;
	}
	public static String compiler(String s)
	{
		String res="";
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)=='*')
			{
				res+=".*";
			}
			else
				res+=""+s.charAt(i);
		}
		return res;
	}
}
