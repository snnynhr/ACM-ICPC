import java.io.*; 
import java.util.*; 

public class shotcube
{
	public void solve() throws IOException  
	{ 
		int t = nextInt();
		for(int cases = 0; cases < t; cases++)
		{
			int ans = -1;
			int[][] grid = new int[7][7];
			for(int x = 0; x < 7; x++)
			{
				String input = nextToken();
				for(int y = 0; y < 7; y++)
					grid[x][y] = (input.charAt(y) == 'X') ? 1 : 0;
			}

			ArrayList<State> queue = new ArrayList<State>();
			if(isValid(grid))
				ans = 0;
			else
				queue.add(new State(grid, 0));

			while(queue.size() > 0)
			{
				State cur = queue.remove(0);
				int[][] curgrid = cur.grid;
				for(int x = 0; x < 7; x++)
				{
					if(curgrid[0][x] == 1)
					{
						int count = 0;
						int index = 0;
						while(index < 7 && curgrid[index][x] == 1)
						{
							index++;
							count++;
						}
						
						boolean hasend = false;
						for(int y = count; y < 7; y++)
							if(curgrid[y][x] == 1)
								hasend = true;

						if(hasend)
						{
							int[][] newgrid = new int[7][7];
							for(int a = 0; a < 7; a++)
								for(int b = 0; b < 7; b++)
									newgrid[a][b] = curgrid[a][b];

							for(int y = 0; y < count; y++)
								newgrid[y][x] = 0;

							for(int y = 6; y >= 0; y--)
							{
								if(newgrid[y][x] == 1)
								{
									while(newgrid[y][x] == 1)
										y--;
									y++;
									
									while(count > 0)
									{
										newgrid[y - count][x] = 1;
										count--;
									}
									break;
								}
							}
							if(isValid(newgrid))
							{
								ans = cur.moves + 1;
								queue.clear();
							}
							else
								queue.add(new State(newgrid, cur.moves + 1));
						}
					}
				}
				
				for(int x = 0; x < 7; x++)
				{
					if(curgrid[6][x] == 1)
					{
						int count = 0;
						int index = 6;
						while(index >= 0 && curgrid[index][x] == 1)
						{
							index--;
							count++;
						}
						
						boolean hasend = false;
						for(int y = 6 - count; y >= 0; y--)
							if(curgrid[y][x] == 1)
								hasend = true;

						if(hasend)
						{
							int[][] newgrid = new int[7][7];
							for(int a = 0; a < 7; a++)
								for(int b = 0; b < 7; b++)
									newgrid[a][b] = curgrid[a][b];

							for(int y = 0; y < count; y++)
								newgrid[6 - y][x] = 0;

							for(int y = 0; y < 7; y++)
							{
								if(newgrid[y][x] == 1)
								{
									while(newgrid[y][x] == 1)
										y++;
									y--;
									
									while(count > 0)
									{
										newgrid[y + count][x] = 1;
										count--;
									}
									break;
								}
							}
							if(isValid(newgrid))
							{
								ans = cur.moves + 1;
								queue.clear();
							}
							else
								queue.add(new State(newgrid, cur.moves + 1));
						}
					}
				}
				
				for(int x = 0; x < 7; x++)
				{
					if(curgrid[x][0] == 1)
					{
						int count = 0;
						int index = 0;
						while(index < 7 && curgrid[x][index] == 1)
						{
							index++;
							count++;
						}
						
						boolean hasend = false;
						for(int y = count; y < 7; y++)
							if(curgrid[x][y] == 1)
								hasend = true;

						if(hasend)
						{
							int[][] newgrid = new int[7][7];
							for(int a = 0; a < 7; a++)
								for(int b = 0; b < 7; b++)
									newgrid[a][b] = curgrid[a][b];

							for(int y = 0; y < count; y++)
								newgrid[x][y] = 0;

							for(int y = 6; y >= 0; y--)
							{
								if(newgrid[x][y] == 1)
								{
									while(newgrid[x][y] == 1)
										y--;
									y++;
									
									while(count > 0)
									{
										newgrid[x][y - count] = 1;
										count--;
									}
									break;
								}
							}
							if(isValid(newgrid))
							{
								ans = cur.moves + 1;
								queue.clear();
							}
							else
								queue.add(new State(newgrid, cur.moves + 1));
						}
					}
				}
				
				for(int x = 0; x < 7; x++)
				{
					if(curgrid[x][6] == 1)
					{
						int count = 0;
						int index = 6;
						while(index >= 0 && curgrid[x][index] == 1)
						{
							index--;
							count++;
						}
						
						boolean hasend = false;
						for(int y = 6 - count; y >= 0; y--)
							if(curgrid[x][y] == 1)
								hasend = true;

						if(hasend)
						{
							int[][] newgrid = new int[7][7];
							for(int a = 0; a < 7; a++)
								for(int b = 0; b < 7; b++)
									newgrid[a][b] = curgrid[a][b];

							for(int y = 0; y < count; y++)
								newgrid[x][6 - y] = 0;

							for(int y = 0; y < 7; y++)
							{
								if(newgrid[x][y] == 1)
								{
									while(newgrid[x][y] == 1)
										y++;
									y--;
									while(count > 0)
									{
										newgrid[x][y + count] = 1;
										count--;
									}
									break;
								}
							}
							if(isValid(newgrid))
							{
								ans = cur.moves + 1;
								queue.clear();
							}
							else
								queue.add(new State(newgrid, cur.moves + 1));
						}
					}
				}
			}
			System.out.println(ans);
		}
	}

	public boolean isValid(int[][] grid)
	{
		for(int x = 0; x < 5; x++)
		{
			for(int y = 0; y < 5; y++)
			{
				if(grid[x][y] == 1)
				{	
					if(grid[x][y] == 1 && grid[x][y + 1] == 1 && grid[x][y + 2] == 1 &&
							grid[x + 1][y] == 1 && grid[x + 1][y + 1] == 1 && grid[x + 1][y + 2] == 1 &&
							grid[x + 2][y] == 1 && grid[x + 2][y + 1] == 1 && grid[x + 2][y + 2] == 1)
						return true;
					else
						return false;
				}
			}
		}
		return false;
	}

	public void output(int[][] grid)
	{
		for(int x = 0; x < 7; x++)
		{
			for(int y = 0; y < 7; y++)
				System.out.print(grid[x][y] + " ");
			System.out.println();
		}
		System.out.println();
	}

	public class State
	{
		public int[][] grid;
		public int moves;

		public State(int[][] grid, int moves)
		{
			this.grid = grid;
			this.moves = moves;
		}
	}

	public BufferedReader br; 
	public StringTokenizer st; 
	public PrintWriter out; 

	public String nextToken() throws IOException { 
		while(st == null || !st.hasMoreTokens()) { 
			st = new StringTokenizer(br.readLine()); 
		} 

		return st.nextToken(); 
	} 

	public int nextInt() throws IOException { 
		return Integer.parseInt(nextToken()); 
	} 

	public long nextLong() throws  IOException { 
		return Long.parseLong(nextToken()); 
	} 

	public double nextDouble() throws IOException { 
		return Double.parseDouble(nextToken()); 
	} 

	public void run() throws IOException  
	{    
		br = new BufferedReader( new InputStreamReader( System.in )); 
		out = new PrintWriter(System.out); 
		solve(); 
		out.close(); 
	} 

	public static void main(String[] args) throws IOException  
	{ 
		new shotcube().run(); 
	} 
}