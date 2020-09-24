import java.util.ArrayList;
import java.util.List;

public class FindAllNumbers 
{
	public List<Integer> findDisappearedNumbers(int[] nums) 
	{
		if(nums == null) return new ArrayList<Integer>();
		
		for(int i = 0; i < nums.length; ++i)
		{
			while(nums[i] != nums[nums[i] - 1])
			{
				int targetIdx = nums[i] - 1;
				
				int temp  = nums[i];
				nums[i]   = nums[targetIdx];
				nums[targetIdx] = temp;				
			}
		}
		
		List<Integer> retList = new ArrayList<>();
		
		for(int i = 0; i < nums.length; ++i)
		{
			if(nums[i] != i + 1)
			{
				retList.add(i + 1);
			}
		}
		
		return retList;
    }
	
	public int getSum(int a, int b) 
    {
        int result = 0;
        boolean carry = false;
        int bitPos    = 0;
        
        while(!(a == 0 && b == 0))
        {        	
        	if((a & 1) == 1 && (b & 1) == 1)
        	{
        		if(carry)
        		{        			
        			result = result | (1 << bitPos);
        		}
        		else
        		{
        			carry = true;
        		}
        	}
        	else
        	if((a & 1) == 0 && (b & 1) == 0)
        	{
        		if(carry) 
        		{
        			result = result | (1 << bitPos);
        			
        			carry = false;
        		}
        	}
        	else
        	{
        		if(!carry)
        		{
        			result = result | (1 << bitPos);
        		}
        	}
        	
        	a >>>= 1;
        	b >>>= 1;    
        	++bitPos;
        }
        
        if(carry) 
        {
        	result = result | (1 << bitPos);
        }
       
        return result;
    }
	
	public static void main(String[] args)
	{
		System.out.println(new FindAllNumbers().getSum(-1, 1));
	}
}
