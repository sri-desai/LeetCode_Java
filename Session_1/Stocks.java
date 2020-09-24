
public class Stocks 
{
	public int maxProfit(int[] prices) 
	{
		if(prices == null || prices.length == 0) return 0;
		
		int minBuy;
		int maxSell;
		int profit;
		
		minBuy = prices[0];
		maxSell = prices[0];
		profit = maxSell - minBuy;
		
		for(int i = 1; i < prices.length; ++i)
		{
			maxSell = prices[i];
			
			if(maxSell - minBuy > profit) profit = maxSell - minBuy;
			
			if(prices[i] < minBuy) minBuy = prices[i];
		}
		
		return profit;
    }
	
	public static void main(String[] args)
	{
		int[] prices = {7, 6, 4, 3, 1};
		
		System.out.println(new Stocks().maxProfit(prices));
	}
}
