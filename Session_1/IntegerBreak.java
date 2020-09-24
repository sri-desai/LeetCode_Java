
public class IntegerBreak 
{
	int   maxProduct;
	int[] intArray;
	
	public int integerBreak(int n) 
	{
        if(n == 2) return 1;
        
        intArray   = new int[n];
        maxProduct = -1;
        
        for(int i = 1; i <= n; ++i)
        {
        	intArray[i - 1] = i;
        }
        
        calculateProduct(n, 0, 1, 0);
        
        return maxProduct;
    }

	private void calculateProduct(int reminder, int startPos, int curProduct, int elemCount)
	{
		if(reminder == 0)
		{
			if(elemCount < 2) return;
			maxProduct = Math.max(maxProduct, curProduct);
		}
		else
		{
			for(int i = startPos; i < intArray.length; ++i)
			{
				if(reminder < intArray[i])
				{
					calculateProduct(0, i, curProduct * reminder, elemCount + 1);
					
					break;
				}
				else
				{
					calculateProduct(reminder - intArray[i], i, curProduct * intArray[i], elemCount + 1);
				}
			}		
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(new IntegerBreak().integerBreak(3));
	}
}
