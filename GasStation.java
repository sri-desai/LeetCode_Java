
public class GasStation
{
	
	public int canCompleteCircuit(int[] gas, int[] cost) 
	{
		if(gas == null || cost == null || gas.length == 0 || 
		   cost.length == 0 || gas.length != cost.length) return -1;
		
		for(int i = 0; i < gas.length; ++i)
		{
			gas[i] -= cost[i];
		}
		
		int prevSum = 0;
		int startIdx = 0;
		int curTankLevel = gas[0];
		
		for(int i = 1; i < gas.length; ++i)
		{
			curTankLevel += gas[i];
			
			if(curTankLevel < 0)
			{
				prevSum += curTankLevel;
				startIdx = i + 1;
				curTankLevel = 0;
			}
		}
		
		return prevSum + curTankLevel >= 0 ? startIdx : -1;
    }
	
	public static void main(String[] args)
	{
		int[] gas  = {2, 3, 1};
		int[] cost = {3, 1, 2};
		
		System.out.println(new GasStation().canCompleteCircuit(gas, cost));
	}
}
