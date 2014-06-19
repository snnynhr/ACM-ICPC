import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Suspects {
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		//int cnt = n;
		int c =0;
		int[][] mat = new int[n+1][4];
		for(int ii=0; ii<n; ii++) {
			for(int i=0; i<n; i++)
			{

				String s = br.readLine();
				char ss = s.charAt(1);
				int f = Integer.parseInt(s.substring(1));
				mat[i][0] = f;
				if(ss=='-')
				{
					c++;
					mat[f][1] ++;
					mat[i][0] = -1*f;
				}
				else
					mat[f][2] ++;
			}
			int k=0;
			for(int i = 1; i <= n; ++i){
				int truth = mat[i][2] + c - mat[i][1];
				if(truth != m){
					mat[i][3]=1;
					k++;
				}
			}
			for (int i = 1; i <= n; i ++ ) {                 
				if(mat[i][0]> 0) { 
					if(mat[mat[i][0]][3]==1 && k == 1) System.out.println("Truth"); 
					else if (mat[mat[i][0]][3]!=1) System.out.println("Lie"); 
					else System.out.println("Not defined");  
				}  
				else {  
					if (mat[-mat[i][0]][3]!=1) System.out.println("Truth");  
					else if (mat[-mat[i][0]][3]==1 && k == 1)System.out.println("Lie");  
					else System.out.println("Not defined");  
				}   
			}
		}
		br.close();
		System.exit(0);
	}
}