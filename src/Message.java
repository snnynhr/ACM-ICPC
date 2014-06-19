import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Message {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer read = new StringBuffer(br.readLine());
		StringBuffer write = new StringBuffer(br.readLine());
		int w = write.length()-1;
		
		for(int i=0; i<w; i++)
		{
			StringBuffer ww = new StringBuffer("0");
			read.append(ww);
			read = ww.append(read);
		}
		int max = 0;
		for(int i=0; i<read.length()-write.length()+1; i++)
		{
			int res = match(read.substring(i, i+write.length()),write.substring(0, write.length()));
			max = Math.max(max, res);
		}
		System.out.println( w+1-max);
		br.close();
		System.exit(0);
	}
	public static int match(String a, String b)
	{
		int c=0;
		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();
		for(int i=0; i<a.length(); i++)
		{
			if(aa[i]==bb[i]) c++;
		}
		return c;
	}

}
