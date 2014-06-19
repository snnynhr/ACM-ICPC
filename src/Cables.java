import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;
public class Cables {

	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		while(n!=0)
		{
			int[][] xy = new int[n][2];
			for(int i=0; i<n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				xy[i][0] = Integer.parseInt(st.nextToken());
				xy[i][1] = Integer.parseInt(st.nextToken());
			}
			double[][] grid = new double[n][n];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<n; j++)
				{
					grid[i][j] = Math.sqrt((xy[i][0]-xy[j][0])*(xy[i][0]-xy[j][0])+(xy[i][1]-xy[j][1])*(xy[i][1]-xy[j][1]));
				}
			}
			findMST(n,grid);
			n = Integer.parseInt(br.readLine());
		}
		System.exit(0);
	}
	public static void findMST(int N, double[][] grid)
	{
		double[] dist;
		boolean inTree[];
		int[] source;
		int currSize = 0;
		double weightSum=0;
		source = new int[N];
		dist = new double[N];
		inTree = new boolean[N];
		for(int i=0; i<N; i++)
		{
			dist[i]=Integer.MAX_VALUE;
			source[i] = -1;
		}
		int i=0;
		while(currSize<N)
		{
			double min = Integer.MAX_VALUE;
			int minI =-1;
			inTree[i]=true;
			for(int j=0; j<N; j++)
			{
				if(i!=j & !inTree[j])
				{
					if(grid[i][j]<dist[j])
					{
						source[j]=i;
						dist[j]=grid[i][j];
					}
					if(dist[j]<min)
					{
						min=dist[j];
						minI=j;
					}
				}
			}
			i=minI;
			currSize++;
		}
		for(i=1; i<dist.length; i++)
			weightSum+=dist[i];
		String s = weightSum+"";
		s = s.substring(0,s.indexOf('.')+3);
		BigDecimal rr = new BigDecimal(s);
		rr.setScale(3, BigDecimal.ROUND_HALF_UP);
		System.out.println(rr);
	}
}