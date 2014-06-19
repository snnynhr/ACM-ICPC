import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;


public class Robot {
	static int n,m;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		String param = br.readLine();
		while(!(param.trim().equals("0")))
		{
			n = Integer.parseInt(param.trim());
			int[][] x = new int[n+2][3];
			for(int i=1; i<=n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				x[i][0] = Integer.parseInt(st.nextToken());
				x[i][1] = Integer.parseInt(st.nextToken());
				x[i][2] = Integer.parseInt(st.nextToken());
			}
			x[0][0] = 0;
			x[0][1] = 0;
			x[0][2] = 0;
			x[n+1][0] = 100;
			x[n+1][1] = 100;
			x[n+1][2] = Integer.MAX_VALUE;
			double[] dp = new double[n+2];
			double[] pen = new double[n+2];
			pen[0] = 0;
			for(int i=1; i<=n+1; i++)
			{
				pen[i] = x[i][2]+pen[i-1];
				dp[i] = Integer.MAX_VALUE;
			}
			dp[0] = 0;
			for(int i=1; i<=n+1; i++)
				for(int j=0; j<i; j++)
					dp[i] = Math.min(dp[i], dp[j]+ Math.sqrt((x[i][0]-x[j][0])*(x[i][0]-x[j][0])+(x[i][1]-x[j][1])*(x[i][1]-x[j][1]))+pen[i-1]-pen[j]+1);
			double res = dp[n+1];
			//String s = res+"";
			DecimalFormat twoDForm = new DecimalFormat("#.###");
			System.out.println(Double.valueOf(twoDForm.format(res)));
			System.out.println(String.format("%.6g%n", res));
			/*
			int ss = s.indexOf('.');
			if(s.length()>ss+3)
			{
				s = s.substring(0,ss+4);
				BigDecimal rr = new BigDecimal(s);
				rr.setScale(4, BigDecimal.ROUND_HALF_UP);
				System.out.println(rr);
			}
			else
			{
				s = s+"00000".substring(0,ss+4-s.length());
				System.out.println(s);
			}*/
			param = br.readLine();
		}
		br.close();
		System.exit(0);
	}
}
