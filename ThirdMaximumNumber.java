
public class ThirdMaximumNumber 
{
	public int thirdMax (int[] nums)
	{
		Integer first_max = null;
		Integer sec_max   = null;
		Integer third_max = null;
		
		for(Integer number : nums)
		{
			if(number.equals(first_max) || number.equals(sec_max) || number.equals(third_max))
			{
				continue;
			}
			else
			if(first_max == null || number > first_max)
			{
				third_max = sec_max;
				sec_max   = first_max;
				first_max = number;				
			}
			else
			if(sec_max == null || number > sec_max)
			{
				third_max = sec_max;
				sec_max   = number;
			}
			else
			if(third_max == null || number > third_max)
			{
				third_max = number;
			}
		}
		
		return third_max == null ? first_max : third_max;
	}	
	
	public static void main(String[] args)
	{
		int array[] = {2, 2, 3, 1};
		
		System.out.println(new ThirdMaximumNumber().thirdMax(array));
	}
}
