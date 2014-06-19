import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Template {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		PriorityQueue b = new PriorityQueue<Integer>(10,
				new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				if(a<b) return 1;
				if(a == b) return 0;
				return -1;
			}
		});
		b.add(4);
		b.add(5);
		b.add(6);
		b.add(7);
		System.out.println(b.poll());
		System.out.println(b.poll());
		System.out.println(b.poll());
		System.out.println(b.poll());
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		
		while(!(param.equals("0 0")))
		{
			StringTokenizer st = new StringTokenizer(param);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			param = br.readLine();
		}

		br.close();
		System.exit(0);
	}
}
