import java.util.Arrays;


public class Vector {

	public static void main(String[] args) {
		double[] c = {0,9.7762,0.832};
		double x = c[0];
		double y = c[1];
		double z = c[2];
		double[] pass = new double[3];
		pass[0] = x;
		pass[1] = y;
		pass[2] = z;
		double[][] res = change(pass);
		double adjX = res[0][0]*x+res[0][1]*y+res[0][2]*z;
		double adjY = res[1][0]*x+res[1][1]*y+res[1][2]*z;
		double adjZ = res[2][0]*x+res[2][1]*y+res[2][2]*z;
		System.out.println("AdjX: "+adjX);
		System.out.println("AdjY: "+adjY);
		System.out.println("AdjZ: "+adjZ);
		//	double[][] res = orthonormalGS(c);
		//	for(int i=0; i<3; i++)
		//		System.out.println(Arrays.toString(res[i]));
	}
	public static void print(double[] p)
	{
		System.out.println(Arrays.toString(p));
	}
	public static double angleDP(double[] v1, double[] v2)
	{
		return Math.acos(dotProd(v1,v2))/(norm(v1)*norm(v2));
	}
	public static double[] crossProduct(double[] v1, double[] v2)
	{
		return new double[] {v1[1]*v2[2]-v1[2]*v2[1],v1[2]*v2[0]-v1[0]*v2[2],v1[0]*v2[1]-v1[1]*v2[0]};
	}
	public static double[] negate(double[] v)
	{
		double[] res = new double[v.length];
		for(int i=0; i<v.length; i++)
		{
			res[i] = -1*v[i];
		}
		return res;
	}
	public static double[][] change(double[] curr)
	{
		//Init y = (0,1,0)
		double[][] r= new double[3][3];
		double[] vect = {curr[0],curr[1],0};
		vect = normalize(vect);
		double[] xhat = {1,0,0};
		double angle = angleDP(vect,xhat);
		double[] res = {0,0,0};
		res[0] = Math.cos(90+angle);
		res[1] = Math.sin(90+angle);
		res[2] = 0;
		vect = negate(vect);//z
		//Z...
		curr = normalize(curr);
		curr = negate(curr);
		//
		r[2] = vect;
		res = normalize(res);//y
		r[1] = res;
		print(curr);
		print(res);
		r[0] = normalize(crossProduct(res, curr));
		print(normalize(crossProduct(res, curr)));//x
		//dp
		System.out.println(dotProd(r[2], r[1]));
		double[][] m = new double[3][3];
		m[0][0] = r[0][0]/9.8;
		m[0][1] = r[1][0]/9.8;
		m[0][2] = r[2][0]/9.8;
		m[1][0] = r[0][1]/9.8;
		m[1][1] = r[1][1]/9.8;
		m[1][2] = r[2][1]/9.8;
		m[2][0] = r[0][2]/9.8;
		m[2][1] = r[1][2]/9.8;
		m[2][2] = r[2][2]/9.8;
		return inverse(m);
	}
	public static double[] normalize(double[] v)
	{
		double[] ret = new double[v.length];
		double norm = norm(v);
		for(int i=0; i<v.length; i++)
			ret[i] = v[i]/norm;
		return ret;
	}
	public static double[][] orthonormalGS(double[] v)
	{
		double[] yhat = {0,1,0};
		double[] zhat = {0,0,1};
		double[][] res = new double[3][3];
		double m = norm(v);
		//Normed vector
		double[] normed_m = normalize(v);
		//Gram-Schmidt orthonormalization
		res[0][0]=normed_m[0];
		res[1][0]=normed_m[1];
		res[2][0]=normed_m[1];
		double scale = dotProd(yhat,normed_m);
		double[] a = new double[3];
		for(int i=0; i<3; i++)
			a[i] = yhat[i] - scale*normed_m[i];
		double[] na = normalize(a);
		res[0][1] = na[0];
		res[1][1] = na[1];
		res[2][1] = na[2];
		//calc v3
		double d1 = dotProd(zhat,normed_m);
		double d2 = dotProd(zhat,na);
		double[] b = new double[3];
		for(int i=0; i<3; i++)
			b[i] = zhat[i] - d1*normed_m[i]-d2*na[i];
		double[] nb = normalize(b);
		res[0][2] = nb[0];
		res[1][2] = nb[1];
		res[2][2] = nb[2];
		return res;
	}
	public static double[][] inverse(double[][] a)
	{
		double x = (a[0][0] * a[1][1] * a[2][2]) + (a[1][0] * a[2][1] * a[0][2]) + (a[2][0] * a[0][1] * a[1][2]);
		double y = (a[0][2] * a[1][1] * a[2][0]) + (a[1][2] * a[2][1] * a[0][0]) + (a[2][2] * a[0][1] * a[1][0]);
		double det = x-y;
		System.out.println(det);
		double ret[][] = new double[3][3];
		ret[0][0] = (a[1][1]*a[2][2]-a[1][2]*a[2][1])/det;
		ret[1][1] = (a[0][0]*a[2][2]-a[0][2]*a[2][0])/det;
		ret[2][2] = (a[0][0]*a[1][1]-a[1][0]*a[0][1])/det;
		ret[0][1] = (a[0][2]*a[2][1]-a[2][2]*a[0][1])/det;
		ret[0][2] = (a[0][1]*a[1][2]-a[0][2]*a[1][1])/det;
		ret[1][0] = (a[1][2]*a[2][0]-a[1][0]*a[2][2])/det;
		ret[1][2] = (a[0][2]*a[1][0]-a[0][0]*a[1][2])/det;
		ret[2][0] = (a[1][0]*a[2][1]-a[1][1]*a[2][0])/det;
		ret[2][1] = (a[0][1]*a[2][0]-a[0][0]*a[2][1])/det;
		return ret;
	}
	public static double norm(double[] v)
	{
		return Math.sqrt(dotProd(v,v));
	}
	public static double dotProd(double[] v1, double[] v2)
	{
		double res = 0;
		for(int i=0; i<v1.length; i++) res += v1[i]*v2[i];
		return res;
	}
}
