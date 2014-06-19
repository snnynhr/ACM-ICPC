import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LastChance {

	public static void main(String[] args) throws IOException {
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String res = br.readLine();
		//String res = "AaaBRAaaCAaaDAaaBRAaa";
		if(res.length()==0) System.out.println(0);
		int l=0; int r=0;
		int vc = 0;
		int cc = 0;
		if(isVowel(res.charAt(0)))
			vc++;
		else cc++;
		int maxl = 0;
		int num = 0;
		boolean[] ress = new boolean[res.length()];
		for(int i=0; i<res.length(); i++)
		{
			ress[i] = isVowel(res.charAt(i));
		}
		while(l<=r && r<res.length())
		{
			System.out.println(l+" "+r + (vc<=2*cc));
			if(vc<=2*cc)
			{
				if(maxl<r-l+1)
				{
					System.out.println(maxl);
					maxl = r-l+1;
					num=1;
				}
				else if(maxl == r-l+1)
				{
					num++;
				}
				if(r+1<res.length())
				{
					r++;
					if(ress[r]) vc++; 
					else cc++;
				}
				else
				{
					break;
				}
			}
			else
			{
				if(ress[l]) vc--; else cc--;
				l++;
				if(l>r) r=l;
			}
		}
		for(int i=0; i<res.length(); i++)
		{
			
		}
		System.out.println(maxl);
		System.out.println(num);
		br.close();
		System.exit(0);
	}
	public static boolean isVowel(char c)
	{
		char[] v = {'a','e','i','o','u','A','E','I','O','U'};
		for(int i=0; i<10; i++)
		{
			if(v[i]==c) return true;
		}
		return false;
	}
}