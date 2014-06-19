import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class TW {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		//System.out.println(convert(9));
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		int n = Integer.parseInt(param);
		
		for(int i=0; i<n; i++)
		{
			ArrayList<Long> left = new ArrayList<Long>();
			ArrayList<Long> right = new ArrayList<Long>();
			int test = Integer.parseInt(br.readLine());
			String r = convert(test);
			//System.out.println(r);
			char[] rr = r.toCharArray();
			for(int j=0; j<rr.length-1; j++)
			{
				if(rr[j]=='3')
				{
					rr[j+1]++;
				}
				else if(rr[j]=='2')
				{
					rr[j+1]++;
					//System.out.println(Arrays.toString(rr));
					left.add((long)Math.pow(3,j));
				}
				else if(rr[j]=='1')
					right.add((long)Math.pow(3,j));
			}
			if(rr[rr.length-1]=='1') right.add((long)Math.pow(3,rr.length-1));
			System.out.print("left pan:");
			if(left.size()==0) System.out.print(" ");
			for(int j=left.size()-1; j>=0; j--)
				System.out.print(" "+left.get(j));
			System.out.println();
			System.out.print("right pan:");
			if(right.size()==0) System.out.print(" ");
			for(int j=right.size()-1; j>=0; j--)
				System.out.print(" "+right.get(j));
			System.out.println();
			if(i!=n-1) System.out.println();
				
		}
		br.close();
		System.exit(0);
	}
	public static String convert(int x)
	{
		String res = "";
		while(x>0)
		{
			res+=x%3;
			x/=3;
		}
		return res+"0";
	}
}
