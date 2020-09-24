
public class MoveZeroes
{
	public void moveZeroes(int[] nums) 
	{
		int posToInsert = -1;
		
		for(int i = 0; i < nums.length; ++i)
		{
			if(nums[i] == 0)
			{
				if(posToInsert == -1) posToInsert = i;
			}
			else
			{
				if(posToInsert != -1)
				{
					nums[posToInsert++] = nums[i];
					nums[i] = 0;					
				}
			}
		}
		
    }
}
