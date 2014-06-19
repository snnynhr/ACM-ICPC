import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NoWin {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		while(!(param.equals("JOKER")))
		{
			System.out.println(eval(param));
			param = br.readLine();
		}

		br.close();
		System.exit(0);
	}
	public static String eval(String param)
	{
		int num = 0;
		int[] p = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int d = 0;
		if(retVal(param.charAt(0))==11 && retVal(param.charAt(2))==11)
		{
			p[0] = 2;
			p[1] = 12;
			num = 2;
		}
		else if(retVal(param.charAt(0))==11)
		{
			p[0] = 1+retVal(param.charAt(2));
			p[1] = 11+retVal(param.charAt(2));
			num = 2;
		}
		else if(retVal(param.charAt(2))==11)
		{
			p[0] = 1+retVal(param.charAt(0));
			p[1] = 11+retVal(param.charAt(0));
			num = 2;
		}
		else
		{
			p[0] = retVal(param.charAt(0))+retVal(param.charAt(2));
			num = 1;
		}
		d = retVal(param.charAt(1))+retVal(param.charAt(3));
		if(d>21) return "Yes";
		int ind = 0;
		int dealer = getDS(d,param,4+ind);
		if(dealer>21 && didNL(num,p)) return "Yes";
		for(int i=0; i<num; i++)
		{
			//System.out.println(p[i]+",  "+dealer);
			if(p[i]>=dealer) return "Yes";
		}
		while(didNL(num,p) && ind+4<param.length())
		{

			if(retVal(param.charAt(ind+4))==11)
			{
				if(num==1)
				{
					p[1] = p[0];
					p[0] +=1;
					p[1] +=11;
				}
				else
				{
					for(int i=0; i<num; i++) p[i+num] = p[i];
					for(int i=0; i<num; i++) p[i]+=1;
					for(int i=0; i<num; i++) p[i+num] +=11;
					num*=2;
				}
			}
			else
				for(int i=0; i<num; i++)
					p[i]+=retVal(param.charAt(ind+4));

			dealer = getDS(d,param,4+ind+1);
			if(dealer>21 && didNL(num,p)) return "Yes";
			//if(dealer<=21 && !didNL(num,p)) return "No";
			for(int i=0; i<num; i++)
			{
				//	System.out.println(p[i]+",  "+dealer);
				if(p[i]<=21 && p[i]>=dealer) return "Yes";
			}
			ind++;
		}
		return "No";
	}
	public static boolean didNL(int num, int[] p)
	{
		for(int i=0; i<num; i++)
		{
			if(p[i]<=21) return true;
		}
		return false;
	}
	public static int getDS(int d, String param, int index)
	{
		while(index<param.length())
		{
			if(d>=17) 
			{

				break;
			}
			d+=retVal(param.charAt(index));
			index+=1;
		}
		return d;
	}
	public static int retVal(char a)
	{
		if(a=='2'||a=='3'||a=='4'||a=='5'||a=='6'||a=='7'||a=='8'||a=='9')
			return a-48;
		if(a=='T'||a=='K'||a=='Q'||a=='J') return 10;
		else return 11;
	}
}
