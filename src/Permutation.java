import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Permutation {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
		{
			list[i] = Integer.parseInt(st.nextToken());
		}
		boolean[] li = new boolean[5001];
		int count =0;
		for(int i=0; i<n; i++)
		{
			if(!li[list[i]]) li[list[i]]=true;
			
		}
		for(int i=1; i<=n; i++)
			if(!li[i]) count++;
		System.out.println(count);
		br.close();
		System.exit(0);
	}
}
