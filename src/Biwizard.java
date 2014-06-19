
public class Biwizard {
	public static void main(String args[])
	{
		for(int i=1; i<1000; i++)
		{
			if(check(i))
			{
				System.out.println("Answer is: "+ Integer.toBinaryString(i) + " "+i);
				//break;
			}
		}
		System.out.println("CHecked");
		//check(19);
	}
	public static boolean check(int in)
	{
		String s = Integer.toBinaryString(in);
		//System.out.println(s);
		boolean check = true;
		int[][] maze1 = new int[4][4];
		maze1[0][1] = -1;
		maze1[1][0] = -1;
		maze1[1][3] = 1;
		maze1[3][1] = 1;
		maze1[2][3] = -1;
		maze1[3][2] = -1;
		maze1[0][2] = 1;
		maze1[2][0] = 1;
		int[][] maze2 = new int[7][7];
		maze2[0][0] = -1;
		maze2[0][1] = 1;
		maze2[1][2] = -1;
		maze2[1][3] = 1;
		maze2[2][4] = -1;
		maze2[2][5] = 1;
		maze2[3][0] = 1;
		maze2[3][6] = -1;
		maze2[4][2] = 1;
		maze2[4][1] = -1;
		maze2[5][3] = -1;
		maze2[5][4] = 1;
		maze2[6][6] = 1;
		maze2[6][5] = -1;
		//maze 1
		int start = 0;
		int c1=0;
		for(int i=0; i<s.length(); i++)
		{
			int curr = Integer.parseInt(s.substring(i,i+1));
			//System.out.println();
			if(curr == 0) curr = -1;
			for(int j=0; j<4; j++)
			{
				if(maze1[c1][j]==curr)
				{
					c1 = j;
					break;
				}
			}
		}
		if(c1!=1) check = false;
		//System.out.println(c1);
		start= 0;
		int c2=0;
		for(int i=0; i<s.length(); i++)
		{
			int curr = Integer.parseInt(s.substring(i,i+1));
			if(curr==0) curr = -1;
			//System.out.println(";"+c2);
			
			for(int j=0; j<7; j++)
			{
				if(maze2[c2][j]==curr)
				{
					c2 = j;
					break;
				}
			}
		}
		check = true;
		System.out.println(in + " "+ c2+ " ::"+(in%7));
		if(c2!=0) check = false;
		//System.out.println(c2);
		return check;
	}
}
