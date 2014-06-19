import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Antenna {
	static int n,k;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		StringTokenizer st = new StringTokenizer(param);
		int n = Integer.parseInt(st.nextToken());
		//int k = Integer.parseInt(st.nextToken());
		int[][] pts = new int[n][2];
		for(int i=0; i<n; i++)
		{
			st = new StringTokenizer(br.readLine());
			pts[i][0] = Integer.parseInt(st.nextToken());
			pts[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<n; i++)
		{
			for(int j=i+1; j<n; j++)
			{
				for(int l=j+1; l<n; l++)
				{
					double x1 = pts[i][0];
					double y1 = pts[i][1];
					double x2 = pts[j][0];
					double y2 = pts[j][1];
					double x3 = pts[l][0];
					double y3 = pts[l][1];
					double z1 = (x1+x2)/2;
					double z2 = (y1+y2)/2;
					double a1 = (x3+x2)/2;
					double a2 = (y3+y2)/2;
					double m1 = pslope(x1,y1,x2,y2);
					double m2 = pslope(x3,y3,x2,y2);
					double cx = ((z2-a2)+m2*a1-m1*z1)/(m2-m1);
					//double cy = m1*cx+(z2-m1*z1);
					
				}
			}
		}
		br.close();
		System.exit(0);
	}
	public static double getCR(double a, double b, double c)
	{
		double s = (a+b+c)/2;
		double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		return a*b*c/(4*area);
	}
	public static double pslope(double x1,double y1, double x2, double y2)
	{
		if((x2-x1)==0) return 0;
		if(y2-y1==0) return Integer.MAX_VALUE;
		return (x2-x1)/(y1-y2);
	}
}
