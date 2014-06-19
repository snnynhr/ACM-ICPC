
public class Misc {
	public static void main(String[] args)
	{
		for(int x = 0; x < 4; x++)
			for(int y = 0; y < 4; y++)
				for(int z = 0; z < 4; z++)
					System.out.print("\"" + "4" + " " + symbol(x) + " 4 " + symbol(y) + " 4 " + symbol(z) + " 4\", ");
	}
	
	public static String symbol(int a)
	{
		switch(a)
		{
		case 0: return "+";
		case 1: return "-";
		case 2: return "/";
		case 3: return "*";
		}
		return "=";
	}
}
