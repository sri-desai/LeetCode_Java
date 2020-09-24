
public class GuessNumber
{
	public int guessNumber(int n) 
	{		
		int low  = 1;
		int high = n;
		boolean isCorrectAns = false;
		
		while(!isCorrectAns && low <= high)
		{
			int mid = (low + high) / 2;
			
			int apiRetVal = guess(mid);
			
			if(apiRetVal == 0)
			{
				isCorrectAns = true;
			}
			else
			if(apiRetVal == 1)
			{
				low = mid + 1;
			}
			else
			{
				high = mid - 1;
			}		
		}
				
		return (low + high) / 2;
    }

	private int guess(int mid)
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
