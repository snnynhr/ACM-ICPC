import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Spells {
	static Spells sp = new Spells();
	public static ArrayList<H> spells;
	public static ArrayList<H> stand = new ArrayList<H>();
	static H farm = null;
	static int c = 0;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new FileReader("C:\\Users\\Sunny Nahar\\Downloads\\dad (3).txt"));
		String param = br.readLine();
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Sunny Nahar\\Desktop\\Result.pdf")));
		int i=0;
		spells = new ArrayList<H>();
		while(i<param.length())
		{
			char curr = param.charAt(i);
			int j = i+1;
			while(j<param.length() && param.charAt(j)>90)
				j++;
			int num = Math.max(1, parse(param.substring(i+1, j)));
			i = j;

			for(int cc = 0; cc<num; cc++)
			{
				if(curr == 'P')
				{
					spells.add(farm);
					farm = null;
				}
				else if(curr == 'C')
				{
					farm = spells.remove(0);
				}
				else if(curr == 'I')
				{
					spells.add(sp.new H(c++));
				}
				else if(curr == 'N')
				{
					if(spells.get(0).isHead)
						spells.get(0).size++;
				}
				else if(curr == 'M')
				{
					if(farm!= null && farm.isHead)
						farm.size++;
				}
				else if(curr == 'O')
				{
					if(farm!=null && farm.isHead)
					{
						farm.isHead = false;
						spells.get(0).isHead = true;
					}
					else if(spells.size()==1 && farm==null || farm!=null && spells.size()==0)
					{
						//1 in the system do nothing.
					}
					else if(spells.get(spells.size()-1).isHead)
					{
						spells.get(spells.size()-1).isHead = false;
						if(farm!=null)
							farm.isHead=true;
						else 
							spells.get(0).isHead = true;
					}
					else
					{
						for(int k=0; k<spells.size()-1; k++)
						{
							if(spells.get(k).isHead)
							{
								spells.get(k).isHead = false;
								spells.get(k+1).isHead = true;
								break;
							}
						}
					}
				}
				else if(curr == 'J')
				{
					farm = spells.remove(0);
					spells.add(farm);
					farm = null;
				}
				else if(curr == 'F')
				{
					int ss = spells.size();
					for(int ii=0; ii<ss; ii++)
						stand.add(spells.remove(0));
					c = 0;
				}
			}
		}
		for(int h=0; h<stand.size(); h++)
		{
			out.print((char)stand.get(h).size);
		}
		System.out.println("Done printing");
		System.out.println(stand.size());


		br.close();
		out.close();
		System.exit(0);
	}
	class H
	{
		public boolean isHead;
		public int size;
		public int ID;
		H(int x)
		{
			if(x==0) 
				isHead = true;
			else 
				isHead = false;
			size = 0;
			ID = x;
		}
		public String toString()
		{
			return ":"+size;
		}
	}
	public static int parse(String s)
	{
		int res = 0;
		for(int i=0; i<s.length(); i++)
		{
			if(s.charAt(i)=='d')      res = res*10 + 0;
			else if(s.charAt(i)=='u') res = res*10 + 1;
			else if(s.charAt(i)=='g') res = res*10 + 2; 
			else if(s.charAt(i)=='r') res = res*10 + 3;
			else if(s.charAt(i)=='w') res = res*10 + 4; 
			else if(s.charAt(i)=='q') res = res*10 + 5; 
			else if(s.charAt(i)=='s') res = res*10 + 6; 
			else if(s.charAt(i)=='k') res = res*10 + 7; 
			else if(s.charAt(i)=='a') res = res*10 + 8; 
			else if(s.charAt(i)=='h') res = res*10 + 9; 
		}
		return res;
	}
}
