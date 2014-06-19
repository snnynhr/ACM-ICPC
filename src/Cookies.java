import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;


public class Cookies {
	static Cookies c = new Cookies();
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		SM x = c.new SM();


		String param = br.readLine();
		while(param!=null)
		{
			if(param.charAt(0)=='#')
				System.out.println(x.removeM());
			else
			{
				x.add(Integer.parseInt(param));
			}
			param = br.readLine();
			x.print();
		}
		br.close();
		System.exit(0);
	}
	public class SM {
		PriorityQueue<Integer> b;
		PriorityQueue<Integer> t;
		int sb = 0;
		int st = 0;		
		SortedSet<Integer> s = new TreeSet<Integer>();
		int m = 0;
		public SM()
		{
			t = new PriorityQueue<Integer>();
			b = new PriorityQueue<Integer>(10,
					new Comparator<Integer>(){
				public int compare(Integer a, Integer b){
					if(a<b) return 1;
					if(a == b) return 0;
					return -1;
				}
			});
			sb = 0;
			st = 0;		
		}
		public void print()
		{
			System.out.println(Arrays.toString(b.toArray()));
			System.out.println(Arrays.toString(t.toArray()));
		}
		public void add(int e) {
			//print();
			if(sb ==0 && st ==0)
			{
				t.add(e);
				st++;
			}
			else
			{
				if(e>=t.peek())
				{
					System.out.println(t.peek()+"  "+e);
					t.add(e);
					st++;
					if(st-sb>1)
					{
						b.add(t.poll());
						st--;
						sb++;
					}
				}
				else
				{
					b.add(e);
					sb++;
					if(sb-st>1)
					{
						sb--;
						st++;
						t.add(b.poll());
					}
				}
			}
			print();
		}
		public int removeM() {
			if(st>=sb)
			{
				int med = t.poll();
				return med;
			}
			else
			{
				return b.poll();
			}
		}
		public void update() {
			if(s.size()==0) m= 0;
			else if(s.size()==1) m = s.first();
			else {
				SortedSet<Integer> h = s.headSet(m);
				SortedSet<Integer> t = s.tailSet(m + 1);
				int x = 1 - s.size() % 2;
				if (h.size() < t.size() + x)
					m = t.first();
				else if (h.size() > t.size() + x)
					m = h.last();
			}
		}
	}
}
