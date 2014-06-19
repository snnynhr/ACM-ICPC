import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class History {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeMap<Integer,Integer> x = new TreeMap<Integer, Integer>();
		for(int i=0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			x.put(a, b);
		}
		int c=0;
		int first=x.firstEntry().getKey(),end=x.firstEntry().getValue();
		int endmax = end;
		for(int i=1; i<n; i++)
		{	
			int cf = x.higherEntry(first).getKey();
			int ce = x.higherEntry(first).getValue();
			if(ce<endmax) c++;
			endmax = Math.max(ce, endmax);
			first = cf;
		}
		System.out.println(c);
		br.close();
		System.exit(0);
	}
}
