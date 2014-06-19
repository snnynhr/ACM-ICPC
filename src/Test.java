
public class Test {

	public static void main(String[] args) {
		//double[][] res = orthonormalGS(0,0,-1);
		//for(int i=0; i<3; i++)
		//System.out.println(Arrays.toString(res[i]));
	}
	public static double angleDP(double vx, double vy, double vz, double wx, double wy, double wz)
	{
		return Math.acos(dotProd(vx, vy, vz,wx,wy,wz))/(norm(vx, vy, vz)*norm(wx,wy,wz));
	}
	public static void change(double x, double y, double z)
	{
		//Init y = (0,1,0)
		double angle = angleDP(x,y,0,1,0,0);
		double y_x = Math.cos(90+angle);
		double y_y = Math.sin(90+angle);
		double y_z = 0;
		
	}
	public static double[][] orthonormalGS(double x, double y, double z)
	{
		double[][] res = new double[3][3];
		double m = norm(x,y,z);
		//Normed vector
		double a = x/m;
		double b = y/m;
		double c = z/m;

		//Gram-Schmidt orthonormalization
		res[0][0]=a;
		res[1][0]=b;
		res[2][0]=c;
		double scale = dotProd(0,1,0,a,b,c);
		double a1 = 0 - a*scale;
		double a2 = 1 - b*scale;
		double a3 = 0 - c*scale;
		double l = norm(a1,a2,a3);
		double na1 = a1/l;
		double na2 = a2/l;
		double na3 = a3/l;
		res[0][1] = na1;
		res[1][1] = na2;
		res[2][1] = na3;

		//calc v3
		double d1 = dotProd(0,0,1,a,b,c);
		double d2 = dotProd(0,0,1,na1,na2,na3);
		double b1 = 0 - d1*a - d2*na1;
		double b2 = 0 - d1*b - d2*na2;
		double b3 = 1 - d1*c - d2*na3; 
		double k = norm(b1,b2,b3);
		double c1 = b1/k;
		double c2 = b2/k;
		double c3 = b3/k;
		res[0][2] = c1;
		res[1][2] = c2;
		res[2][2] = c3;
		return res;
	}
	public static double norm(double x, double y, double z)
	{
		return Math.sqrt(x*x+y*y+z*z);
	}
	public static double dotProd(double v1,double v2,double v3,double w1,double w2, double w3)
	{
		return v1*w1+v2*w2+v3*w3;
	}
}
