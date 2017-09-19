
public class Coin_Change
{
	public int change(int amount, int[] coins) 
	{
		if(coins == null)
			return 0;
		
		if(amount == 0)
			return 1;
		
		if(coins.length == 0)
			return 0;
		
		int[][] decisionMatrix = new int[coins.length][amount + 1];
						
		for(int i = 0; i < decisionMatrix[0].length; ++i)
		{
			if(i % coins[0] == 0)
			{
				decisionMatrix[0][i] = 1;
			}
		}
		
		for(int i = 1; i < decisionMatrix.length; ++i)
		{
			int currentDenom = coins[i];
			
			for(int curamount = 0; curamount < decisionMatrix[0].length; ++curamount)
			{
				if(curamount < currentDenom)
				{
					decisionMatrix[i][curamount] = decisionMatrix[i - 1][curamount]; 
				}
				else
				{
					decisionMatrix[i][curamount] = decisionMatrix[i - 1][curamount] + decisionMatrix[i][curamount - currentDenom];
				}
			}
		}
				
		return decisionMatrix[coins.length - 1][amount];
    }
	
	public static void main(String[] args)
	{
		int[] coins = {10};
		
		System.out.println(new Coin_Change().change(10, coins));
	}
}
