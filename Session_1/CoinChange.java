import java.util.Arrays;

public class CoinChange 
{
	public int coinChange(int[] coins, int amount) 
	{
		if(amount == 0)       return 0;
		if(coins == null || coins.length == 0) return -1; 
		
		int coins_dp[] = new int[amount + 1];
		
		for(int i = 1; i < coins_dp.length; ++i) coins_dp[i] = Integer.MAX_VALUE - 1;
		
		for(int curAmount = 1; curAmount <= amount; ++curAmount)
		{
			for(int i = 0; i < coins.length; ++i)
			{
				if(curAmount >= coins[i])
				{
					coins_dp[curAmount] = Math.min(coins_dp[curAmount], coins_dp[curAmount - coins[i]] + 1);
				}
			}
		}
		
		return coins_dp[amount] == Integer.MAX_VALUE - 1 ? -1 : coins_dp[amount];
    }
	
	public static void main(String[] args)
	{
		int[] coins = {186,419,83,408};
		
		System.out.println(new CoinChange().coinChange(coins, 6249));
	}
}
