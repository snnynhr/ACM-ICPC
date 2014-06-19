import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class evenup {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		int n = Integer.parseInt(param);
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<Integer>();
		//Stack<Integer> s = new Stack<Integer>();
		if(n==1) System.out.println(1);
		else
		{
			for(int i=0; i<n; i++)
			{
				int a = Integer.parseInt(st.nextToken());
				if(list.size()>0 && (a+list.get(list.size()-1)) %2==0) 
					list.remove(list.size()-1);
				else
					list.add(a);
			}/*
			int c = 0;
			for(int i=0; i+1<list.size(); i++)
			{
				c++;
				if((list.get(i)+list.get(i+1))%2==0)
				{
					list.remove(i);
					list.remove(i);
					if(i>0)
						i-=2;
					else i-=1;
				}
			}
			*/
			//System.out.println(c);
			System.out.println(list.size());
		}
		br.close();
		System.exit(0);
	}
}
