import java.util.ArrayList;


public class Board {
	
	public static void main(String args[])
	{
		
	}
	public void newB(int l, int w)
	{
		int[][] board = new int[l][w];
		for(int i=0; i<l; i++)
			for(int j=0; j<w; j++)
				board[i][j] = 1;
		board[0][0] = 0;
		
		
	}
	public boolean check(int[][] board)
	{
		for(int i=0; i<board.length; i++)
			for(int j=0; j<board[0].length; j++)
				if(board[i][j]!=2) 
					return false;
		return true;
	}
}
