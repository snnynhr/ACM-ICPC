import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Lock {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		while(!(param.equals("0 0 0 0")))
		{
			StringTokenizer st = new StringTokenizer(param);
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int max = 0;
			for(int i=0; i<N; i++)
			{
				int sum1 = 0;
				sum1+=3*N;
				if(i>=A) sum1+=i-A;
				else sum1+=N-(Math.abs(i-A));
				if(A<=B) sum1+=(B-A);
				else sum1 += N-(Math.abs(B-A));
				if(B>=C) sum1+=B-C;
				else sum1+= N-(Math.abs(C-B));
				//System.out.println(sum);
				max = Math.max(Math.max(max, sum1),sum1);
			}
			System.out.println(max);
			param = br.readLine();
		}

		br.close();
		System.exit(0);
	}
}
