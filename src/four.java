import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class four {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		int n = Integer.parseInt(param);
		for(int i=0; i<n; i++)
		{
			int m = Integer.parseInt(br.readLine());
			String[] answers = {"4 + 4 + 4 + 4", "4 + 4 + 4 - 4", "4 + 4 + 4 / 4", "4 + 4 + 4 * 4", "4 + 4 - 4 + 4", "4 + 4 - 4 - 4", "4 + 4 - 4 / 4", "4 + 4 - 4 * 4", "4 + 4 / 4 + 4", "4 + 4 / 4 - 4", "4 + 4 / 4 / 4", "4 + 4 / 4 * 4", "4 + 4 * 4 + 4", "4 + 4 * 4 - 4", "4 + 4 * 4 / 4", "4 + 4 * 4 * 4", "4 - 4 + 4 + 4", "4 - 4 + 4 - 4", "4 - 4 + 4 / 4", "4 - 4 + 4 * 4", "4 - 4 - 4 + 4", "4 - 4 - 4 - 4", "4 - 4 - 4 / 4", "4 - 4 - 4 * 4", "4 - 4 / 4 + 4", "4 - 4 / 4 - 4", "4 - 4 / 4 / 4", "4 - 4 / 4 * 4", "4 - 4 * 4 + 4", "4 - 4 * 4 - 4", "4 - 4 * 4 / 4", "4 - 4 * 4 * 4", "4 / 4 + 4 + 4", "4 / 4 + 4 - 4", "4 / 4 + 4 / 4", "4 / 4 + 4 * 4", "4 / 4 - 4 + 4", "4 / 4 - 4 - 4", "4 / 4 - 4 / 4", "4 / 4 - 4 * 4", "4 / 4 / 4 + 4", "4 / 4 / 4 - 4", "4 / 4 / 4 / 4", "4 / 4 / 4 * 4", "4 / 4 * 4 + 4", "4 / 4 * 4 - 4", "4 / 4 * 4 / 4", "4 / 4 * 4 * 4", "4 * 4 + 4 + 4", "4 * 4 + 4 - 4", "4 * 4 + 4 / 4", "4 * 4 + 4 * 4", "4 * 4 - 4 + 4", "4 * 4 - 4 - 4", "4 * 4 - 4 / 4", "4 * 4 - 4 * 4", "4 * 4 / 4 + 4", "4 * 4 / 4 - 4", "4 * 4 / 4 / 4", "4 * 4 / 4 * 4", "4 * 4 * 4 + 4", "4 * 4 * 4 - 4", "4 * 4 * 4 / 4", "4 * 4 * 4 * 4"};
			int[] res = {16, 8, 9, 24, 8, 0, 7, -8, 9, 1, 4, 8, 24, 16, 8, 68, 8, 0, 1, 16, 0, -8, -1, -16, 7, 
					-1, 4, 0, -8, -16, 0, -60, 9, 1, 2, 17, 1, -7, 0, -15, 4, -4, 0, 0, 8, 0, 1, 16, 
					24, 16, 17, 32, 16, 8, 15, 0, 8, 0, 1, 16, 68, 60, 16, 256};
			boolean found = false;
			
			for(int j=0; j<res.length; j++)
			{
				if(m == res[j])
				{
					System.out.println(answers[j]+" = "+res[j]);
					found = true;
					break;
				}
			}
			if(!found) System.out.println("no solution");
		}
		
		br.close();
		System.exit(0);
	}
}
