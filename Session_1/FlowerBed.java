
public class FlowerBed
{
	public boolean canPlaceFlowers(int[] flowerbed, int n) 
	{
		if(flowerbed == null || flowerbed.length < n)    return false;
		if(flowerbed.length == 1)                        return n == 0 || flowerbed[0] == 0;
		
		for(int i = 0; i < flowerbed.length && n > 0; ++i)
		{
			if(i == 0)
			{
				if(flowerbed[i] == 0 && flowerbed[i + 1] == 0)
				{
					flowerbed[i] = 1;
					
					--n;
				}
			}
			else
			if(i == flowerbed.length - 1)
			{
				if(flowerbed[i] == 0 && flowerbed[i - 1] == 0)
				{
					flowerbed[i] = 1;
					
					--n;
				}
			}
			else 
			if(flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)
			{
				flowerbed[i] = 1;
				
				--n;
			}
		}
		
		return n == 0;
    }
}
