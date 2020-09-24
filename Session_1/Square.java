
public class Square 
{
	public int numSquares(int n) 
	{
		if(n < 4)
		{
			return n;
		}
		
		int[] array = new int[n + 1];
		
		array[0] = 0;
		array[1] = 1;
		array[2] = 2;
		array[3] = 3;
		
		for(int number = 4; number <= n; ++number)
		{
			array[number] = number;
			
			for(int indNum = 1; indNum <= number; ++indNum)
			{
				int square = indNum * indNum;
				
				if(square > number)
				{
					break;
				}
				else
				{
					array[number] = Math.min(array[number], 1 + array[number - square]);
				}
			}
		}
		
		return array[n];
    }
	
	public static void main(String[] args) 
	{
		Square sq = new Square();
		
		sq.numSquares(4);
	}
}
