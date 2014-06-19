import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class islamd {
	static int n,m;
	static int[][] islandnum;
	static int[][] islandnumm;
	static char[][] res;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		//br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new FileReader("test.in"));
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<String> cases = new ArrayList<String>();
		String s = br.readLine();
		while(s!=null)
		{
			input.add(s);
			s = br.readLine();
		}
		System.out.println(input.size());
		for(int i=0; i<input.size(); i++)
		{
			cases.add(input.get(i));
			if(input.get(i).equals(""))
			{
				solve(cases);
				cases = new ArrayList<String>();
			}
		}
		if(cases.size()!=0) solve(cases);
		br.close();
		System.exit(0);
	}
	public static void solve(ArrayList<String> x)
	{
		System.out.println(x.get(0));
		res = new char[x.size()][x.get(0).length()];
		for(int i=0; i<x.size(); i++)
		{
			for(int j=0; j<x.get(i).length(); j++)
			{
				res[i][j] = x.get(i).charAt(j);
			}
		}
		int l = res.length;
		int w = res[0].length;
		
		islandnum= new int[l][w]; 
		islandnumm= new int[l][w]; 
		int num=0;
		int b = 0;
		int bus = 0;
		boolean[][] vis = new boolean[l][w];
		boolean[][] visss = new boolean[l][w];
		for(int i=0; i<res.length; i++)
		{
			for(int j=0; j<res[0].length; j++)
			{
				if(islandnum[i][j]==0 && (res[i][j] == '#' || res[i][j]=='X'))
					floodfillIsland(++num,vis, i,j,l,w);
				if(islandnum[i][j]==0 && res[i][j] == 'B')
					floodfillBridges(--b,vis, i,j,l,w);
			}
		}
		for(int i=0; i<res.length; i++)
		{
			for(int j=0; j<res[0].length; j++)
			{
				if(res[i][j] != '.' && islandnumm[i][j]==0)
					floodfillIslandandBridges(++bus,visss, i,j,l,w);
			}
		}
		print(islandnum);
		System.out.println(num+" "+b+" "+bus);
	}
	public static void print(int[][] x)
	{
		for(int i=0; i<x.length; i++) System.out.println(Arrays.toString(x[i]));
	}
	public static void floodfillBridges(int num,boolean[][] v, int i, int j,int l,int w)
	{
		v[i][j] = true;
		islandnum[i][j] = num;
		if(isValid(i+1,j,l,w)&&!v[i+1][j] && res[i+1][j]=='B')
		{
			floodfillBridges(num,v,i+1,j,l,w);
		}
		if(isValid(i,j+1,l,w)&&!v[i][j+1] && res[i][j+1]=='B')
		{
			floodfillBridges(num,v,i,j+1,l,w);
		}
		if(isValid(i,j-1,l,w)&&!v[i][j-1] && res[i][j-1]=='B')
		{
			floodfillBridges(num,v,i,j-1,l,w);
		}
		if(isValid(i-1,j,l,w)&&!v[i-1][j] && res[i-1][j]=='B')
		{
			floodfillBridges(num,v,i-1,j,l,w);
		}
	}
	public static void floodfillIsland(int num,boolean[][] v, int i, int j,int l,int w)
	{
		v[i][j] = true;
		islandnum[i][j] = num;
		if(isValid(i+1,j,l,w)&&!v[i+1][j] && ((res[i+1][j] == '#' || res[i+1][j]=='X')) )
		{
			floodfillIsland(num,v,i+1,j,l,w);
		}
		if(isValid(i,j+1,l,w)&&!v[i][j+1] && ((res[i][j+1] == '#' || res[i][j+1]=='X')) )
		{
			floodfillIsland(num,v,i,j+1,l,w);
		}
		if(isValid(i,j-1,l,w)&&!v[i][j-1] && ((res[i][j-1] == '#' || res[i][j-1]=='X')) )
		{
			floodfillIsland(num,v,i,j-1,l,w);
		}
		if(isValid(i-1,j,l,w)&&!v[i-1][j] && ((res[i-1][j] == '#' || res[i-1][j]=='X')) )
		{
			floodfillIsland(num,v,i-1,j,l,w);
		}
	}
	public static void floodfillIslandandBridges(int num,boolean[][] v, int i, int j,int l,int w)
	{
		v[i][j] = true;
		islandnumm[i][j] = num;
		if(isValid(i+1,j,l,w)&&!v[i+1][j] && ((res[i+1][j] == '#' || res[i+1][j]=='X'|| res[i+1][j]=='B')) )
		{
			floodfillIslandandBridges(num,v,i+1,j,l,w);
		}
		if(isValid(i,j+1,l,w)&&!v[i][j+1] && ((res[i][j+1] == '#' || res[i][j+1]=='X'|| res[i][j+1]=='B')) )
		{
			floodfillIslandandBridges(num,v,i,j+1,l,w);
		}
		if(isValid(i,j-1,l,w)&&!v[i][j-1] && ((res[i][j-1] == '#' || res[i][j-1]=='X'|| res[i][j-1]=='B')) )
		{
			floodfillIslandandBridges(num,v,i,j-1,l,w);
		}
		if(isValid(i-1,j,l,w)&&!v[i-1][j] && ((res[i-1][j] == '#' || res[i-1][j]=='X'|| res[i+1][j]=='B')) )
		{
			floodfillIslandandBridges(num,v,i-1,j,l,w);
		}
	}
	public static boolean isValid(int i, int j, int l, int w)
	{
		return i>=0 && i<l && j>=0 && j<w;
	}
	

}
