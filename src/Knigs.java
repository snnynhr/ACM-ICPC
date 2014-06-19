import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Knigs {
	static int k,n;
	static int[] arr;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		StringTokenizer st = new StringTokenizer(param);
		k = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[k];
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
		int[] years = new int[2011+n+1000];
		int power = 0;
		for(int i=0; i<n+k-1; i++)
		{
			if(i==0)
			{
				StringTokenizer ss = new StringTokenizer(br.readLine());
				int year = Integer.parseInt(ss.nextToken());
				int pow = Integer.parseInt(ss.nextToken());
				if(year==2011)
				{
					q.add(Integer.MAX_VALUE-pow);
				}
				else
				{
					years[year] = pow;
				}
				power = pow;
			}
			else
			{
				StringTokenizer ss = new StringTokenizer(br.readLine());
				int year = Integer.parseInt(ss.nextToken());
				int pow = Integer.parseInt(ss.nextToken());
				if(year==2011)
				{
					q.add(Integer.MAX_VALUE-pow);
				}
				else
				{
					years[year] = pow;
				}
			}
		}
		boolean found = false;
		for(int i=0; i<n; i++)
		{
			if((Integer.MAX_VALUE-q.peek())==power)
			{
				found = true;
				System.out.println(2011+i);
				break;
			}
			else
			{
				q.poll();
				q.add(Integer.MAX_VALUE-years[2011+i+1]);
			}
		}
		if(!found) System.out.println("unknown");
		//while(!q.isEmpty())
			//System.out.println("adds "+q.poll());
		br.close();
		System.exit(0);
	}
}
