import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Palindrometer {
	static int n;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String res = br.readLine();
		while(!res.equals("0"))
		{
			System.out.println(getMin(res));
			res = br.readLine();
		}
		br.close();
		System.exit(0);
	}
	public static int getMin(String x)
	{
		String s = x+"";
		if(s.length()%2==1)
		{
			int mid = s.length()-1;
			mid/=2;
			String t = s.substring(0,mid+1);
			for(int i=mid-1; i>=0; i--)
			{
				t=t+s.charAt(i);
			}
			int res = Integer.parseInt(t);
			if(res>=Integer.parseInt(x)) return res-Integer.parseInt(x);
			else
			{
				res = Integer.parseInt(t.substring(0,mid+1));
				res+=1;
				t = res+"";
				t = "0000000000".substring(0,mid+1-t.length())+t;
				
				for(int i=mid-1; i>=0; i--)
				{
					t=t+t.charAt(i);
				}
				res = Integer.parseInt(t);
				return res-Integer.parseInt(x);
			}
		}
		else
		{
			int mid = s.length()/2-1;
			String t = s.substring(0,mid+1);
			for(int i=mid; i>=0; i--)
			{
				t=t+s.charAt(i);
			}
			int res = Integer.parseInt(t);
			if(res>=Integer.parseInt(x)) return res-Integer.parseInt(x);
			else
			{

				res = Integer.parseInt(s.substring(0,mid+1));
				res+=1;
				t = res+"";
				t = "0000000000".substring(0,mid+1-t.length())+t;
				for(int i=mid; i>=0; i--)
				{
					t=t+t.charAt(i);
				}
				res = Integer.parseInt(t);
				return res-Integer.parseInt(x);
			}
		}
	}
}
