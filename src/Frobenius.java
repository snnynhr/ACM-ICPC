
public class Frobenius {
	static int x = 15210;
	static int y = 15251;
	static int z = 15213;
	static int[] dp = new int[7000000];
	static int find(int a, int b, int c)
	{
	    int counter = 0;
	    int i=0;
	    dp[x]=1;
	    dp[y]=1;
	    dp[z]=1;
	    int maxNotSolvable = 0;
	    while(counter < a)
	    {
	        if(dp[i] == 1)
	        {
	            dp[i+a] = 1;
	            dp[i+b] = 1;
	            dp[i+c] = 1;
	            counter++;
	        }
	        else
	        {
	            counter = 0;
	            maxNotSolvable = i;
	        }
	        i++;
	    }
	    return maxNotSolvable;
	}
	public static void main(String args[])
	{
		System.out.println(find(x,y,z));
	}
}
