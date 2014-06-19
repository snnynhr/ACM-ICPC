import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class EqualAngles {
	static int N,A,B;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		br.close();
		System.exit(0);
		eval(-4,5,-10,0,7,0);
	}
	public static void eval(double ax,double ay,double bx, double by, double cx, double cy)
	{
		double s1 = slope(ax,ay,cx,cy);
		double s2 = slope(bx,by,cx,cy);
		double s3 = slope(ax,ay,bx,by);
		double c1 = Math.abs(s1);
		double c2 = Math.abs(s2);
		double c3 = Math.abs(s3);
		if(c1<=c2 && c1<=c3)
		{
			
		}
		else if(c2<=c1 && c2<=c3)
		{
			double dx = ax;
			double dy = ay;
			ax = bx;
			ay = by;
			bx = dx;
			by = dy;
		}
		else if(c3<=c1 && c3<=c2)
		{
			double dx = cx;
			double dy = cy;
			cx = bx;
			cy = by;
			bx = dx;
			by = dy;
		}
		if(ax>=cx)
		{
			double dx = ax;
			double dy = ay;
			ax = cx;
			ay = cy;
			cx = dx;
			cy = dy;
			
		}
		double resslope = aslope(dist(ax,ay,bx,by),dist(ax,ay,cx,cy),dist(bx,by,cx,cy));
		
		double acslo = slope(ax,ay,cx,cy);
		double shiftac = tansum(acslo,resslope);
		double constac = ay-shiftac*ax;
		double bcslo = slope(bx,by,cx,cy);
		double shiftbc = tansum(bcslo,resslope);
		double constbc = cy-shiftbc*cx;
		double resx1 = (constbc-constac)/(acslo-bcslo);
		double resy1 = acslo*resx1+constac;
		System.out.println(resslope);
		
		resslope = aslope(dist(ax,ay,bx,by),dist(ax,ay,cx,cy),dist(bx,by,cx,cy));
		acslo = slope(ax,ay,cx,cy);
		shiftac = tansum(acslo,-resslope);
		constac = ay-shiftac*ax;
		bcslo = slope(bx,by,cx,cy);
		shiftbc = tansum(bcslo,-resslope);
		constbc = by-shiftbc*bx;
		double resx2 = (constbc-constac)/(acslo-bcslo);
		double resy2 = acslo*resx2+constac;
		System.out.println(resx2+" "+resy2+" "+resx1+" "+resy1);
	}
	public static double tansum(double a, double b)
	{
		return (a+b)/(1-a*b);
	}
	public static double slope(double x1,double y1, double x2, double y2)
	{
		if((x2-x1)!=0)
		return (y2-y1)/(x2-x1);
		else return Integer.MAX_VALUE;
	}
	public static double dist(double x1,double y1, double x2,double y2)
	{
		return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}
	public static double aslope(double a,double b,double c)
	{
		double s = (a+b+c)/2;
		double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		double r = a*a+b*b+c*c;
		return 4*area/r;
	}
	public double angle(double a,double b,double c)
	{
		double s = (a+b+c)/2;
		double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
		double r = a*a+b*b+c*c;
		double res = 4*area/r;
		return Math.atan(res);
	}
}
