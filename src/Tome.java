import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;


public class Tome {
	static ArrayList<String> wizards = new ArrayList<String>();
	static ArrayList<String> spells = new ArrayList<String>();
	static String[] sp = {"Aguamenti","AvadaKedavra","BabblingCurse","BatBogeyHex","Confringo","Confundo","ConjunctivitisCurse","Crucio","Defodio","Densaugeo","Deprimo","Diffindo","Engorgio","EntrailExpellingCurse","Expelliarmus","Expulso","FiendfyreCurse","Flagrate","FreezingCharm","Furnunculus","HairLossCurse","HotAirCharm","Impedimenta","Imperio","Incarcerous","Incendio","JellyLegsJinx","KneeReversalHex","Langlock","Levicorpus","LocomotorMortis","Mobilicorpus","Obscuro","Oppugno","PeskipiksiPesternomi","PetrificusTotalus","Reducio","Reducto","Relashio","Rictusempra","Sectumsempra","Serpensortia","Silencio","SlugVomitingCharm","StingingHex","Stupefy","Tarantallegra","Waddiwasi"};
	static int[][] comp;
	static int[] color;
	static int[] prev;
	static int[] start;
	static int[] fin;
	static Stack<Integer> sss = new Stack<Integer>();
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sunny Nahar\\Downloads\\tome.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Sunny Nahar\\Desktop\\comp.txt")));
		String s = br.readLine();
		comp = new int[sp.length][sp.length];
		color = new int[sp.length];
		prev = new int[sp.length];
		start = new int[sp.length];
		fin = new int[sp.length];

		for(int i=0; i<comp.length; i++)
			Arrays.fill(comp[i],-7);
		while(s!=null)
		{
			String name = s;
			StringTokenizer st = new StringTokenizer(name,",");
			String wiz1 = st.nextToken();
			String wiz2 = st.nextToken().substring(1);
			if(!wizards.contains(wiz1)) wizards.add(wiz1);
			if(!wizards.contains(wiz2)) wizards.add(wiz2);

			String winner = br.readLine();
			String spell1 = br.readLine();
			st = new StringTokenizer(spell1);
			while(st.hasMoreTokens())
			{
				String ss = st.nextToken();
				if(!spells.contains(ss)) spells.add(ss);
			}
			String spell2 = br.readLine();
			st = new StringTokenizer(spell2);
			while(st.hasMoreTokens())
			{
				String ss = st.nextToken();
				if(!spells.contains(ss)) spells.add(ss);
			}
			br.readLine();
			if(winner.equals("tie"))
			{
				StringTokenizer st1 = new StringTokenizer(spell1);
				StringTokenizer st2 = new StringTokenizer(spell2);
				while(st1.hasMoreTokens())
				{
					String s1 = st1.nextToken();
					String s2 = st2.nextToken();
					comp[binarySearch(s1)][binarySearch(s2)] = 0;
					comp[binarySearch(s2)][binarySearch(s1)] = 0;
					if(!s1.equals(s2))
					System.out.println(s1+" "+s2);
				}
			}
			s = br.readLine();
		}
		br = new BufferedReader(new FileReader("C:\\Users\\Sunny Nahar\\Downloads\\tome.txt"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\Sunny Nahar\\Desktop\\Result.pdf")));
		s = br.readLine();
		int count = 0;
		while(s!=null)
		{
			count++;
			String name = s;
			StringTokenizer st = new StringTokenizer(name,",");
			String wiz1 = st.nextToken();
			String wiz2 = st.nextToken().substring(1);
			String winner = br.readLine();
			String spell1 = br.readLine();
			String spell2 = br.readLine();
			br.readLine();
			int cwin = 0;
			if(!winner.equals("tie"))
			{
				if(winner.equals(wiz2)) 
					cwin = 1;
				
				StringTokenizer st1 = new StringTokenizer(spell1);
				StringTokenizer st2 = new StringTokenizer(spell2);
				String c1="",c2="";
				while(st1.hasMoreTokens())
				{
					String s1 = st1.nextToken();
					String s2 = st2.nextToken();
					if(!s1.equals(s2) && comp[binarySearch(s1)][binarySearch(s2)] != 0)
					{
						c1 = s1;
						c2 = s2;
						break;
					}
				}
				out.println("comp: "+c1+" "+c2);
				//if(c1.equals("Deprimo")&&c2.equals("FiendfyreCurse"))
				//{
				//	System.out.println("ZZError: "+count+"; "+c1+"  "+c2);
				//	System.out.println(spell1);
				///	System.out.println(spell2);
				//	
				//}
				if(cwin == 0)
				{
					if(comp[binarySearch(c1)][binarySearch(c2)]==-1)
						System.out.println("Error: "+count+"; "+c1+"  "+c2);
					comp[binarySearch(c1)][binarySearch(c2)] = 1;
					comp[binarySearch(c2)][binarySearch(c1)] = -1;
				}
				else
				{
					comp[binarySearch(c1)][binarySearch(c2)] = -1;
					comp[binarySearch(c2)][binarySearch(c1)] = 1;
				}
			}
			s = br.readLine();
		}
		//for(int i=0; i<comp.length; i++)
			//System.out.println(Arrays.toString(comp[i]));
		
		
		//System.out.println(wizards.size());
		//for(int i=0; i<wizards.size(); i++)
			//System.out.println(wizards.get(i));
		Collections.sort(spells);
		System.out.println("\n"+spells.size());
		for(int i=0; i<spells.size(); i++)
			System.out.print("\""+spells.get(i)+"\",");
		System.out.println();
		dfs();
		for(int i=0; i<sp.length; i++)
			System.out.println((i+1)+": "+sp[sss.pop()]);
		br.close();
		out.close();
	}
	static int time = 0;
	public static void dfs()
	{
		for(int i=0; i<sp.length; i++)
		{
			if(color[i]==0)
			{
				dfsv(i);
			}
		}
	}
	public static void dfsv(int i)
	{
		time = time + 1;
		start[i] = time;
		color[i] = 1;
		for(int j=0; j<sp.length; j++)
		{
			if(comp[i][j]==-1 && i!=j && color[j]==0)
			{
				prev[j] = i;
				dfsv(j);
			}
		}
		color[i] = 2;
		time = time + 1;
		fin[i] = time;
		sss.add(i);
	}
	public static int binarySearch(String key)
	{ 
		int l = 0;
		int h = sp.length - 1;
		while (l <= h)
		{ 
			int m = l+(h-l)/2;
			if (key.compareTo(sp[m]) < 0) h = m- 1;
			else if (key.compareTo(sp[m])>0) l = m + 1;
			else return m;
		}
		return -1;
	}


}
