import java.util.HashSet;
import java.util.Set;

public class GasStation
{
	public int canCompleteCircuit(int[] gas, int[] cost) 
	{
		if(gas == null || cost == null || gas.length == 0 || 
		   cost.length == 0 || gas.length != cost.length) return -1;
		
		int totalGasCostDiff = 0;
		int resultStartIdx   = 0;
		int gasReamainInTank = 0;
		
		for(int i = 0; i < gas.length; ++i)
		{
			gasReamainInTank += gas[i] - cost[i];
			
			/* check whether we can't make it to next stop */
			if(gasReamainInTank < 0)
			{	
				/* set the start position to next stop */
				resultStartIdx = i + 1;
				
				totalGasCostDiff += gasReamainInTank;
				
				/* we are going to start from empty tank from next stop */
				gasReamainInTank = 0;
			}
		}
		
		return totalGasCostDiff + gasReamainInTank < 0 ? -1 : resultStartIdx;
    }
	
	public static void main(String[] args)
	{
		;
	}
}
