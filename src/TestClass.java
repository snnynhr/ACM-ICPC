import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;


public class TestClass {
	public static void main(String args[]) throws IOException
	{
		int[] str = new int[128];
		int[] m = {1,1,0,1,1,1,1};
		int c = 0;
		while(c++ < 20)
		{
			int s = 0;
			for(int i=0; i<m.length; i++)
				s = 2*s + m[i];
			if(str[s]==0)
			{
				str[s]=1;
				System.out.println(s);
			}

			Random rand = new Random();
			int y = rand.nextInt(2);
			int x = rand.nextInt(3);
			if(y==0)
			{
				if(x==0)
				{
					m[0] = 1-m[0];
					m[1] = 1-m[1];
					m[2] = 1-m[2];
					m[3] = 1-m[3];
				}
				else if(x ==1)
				{
					m[1] = 1-m[1];
					m[2] = 1-m[2];
					m[4] = 1-m[4];
					m[5] = 1-m[5];
				}
				else
				{
					m[2] = 1-m[2];
					m[3] = 1-m[3];
					m[5] = 1-m[5];
					m[6] = 1-m[6];
				}
			}
			else
			{
				if(x==0)
				{
					m[0] = 1;
					m[1] = 1;
					m[2] = 1;
					m[3] = 1;
				}
				else if(x ==1)
				{
					m[1] = 1;
					m[2] = 1;
					m[4] = 1;
					m[5] = 1;
				}
				else
				{
					m[2] = 1;
					m[3] = 1;
					m[5] = 1;
					m[6] = 1;
				}
			}
		}
		for(int i=0; i<128; i++)
		{
			if(str[i]==1)
			{
				for(int j=6; j>=0; j--)
				{
					m[6-j] = (i>>j)&1;
				}
				System.out.println(i);
				System.out.println("\t"+m[0]+"\t");
				System.out.println(m[1]+"\t\t"+m[3]);
				System.out.println("\t"+m[2]);
				System.out.println(m[4]+"\t\t"+m[6]);
				System.out.println("\t"+m[5]+"\n");
			}
		}
	}
}
