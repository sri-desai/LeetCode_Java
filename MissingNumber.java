public class MissingNumber 
{
	public int missingNumber(int[] nums) 
	{		
		long targetSum = nums.length * (nums.length + 1) / 2;
		long curSum    = 0;
		
		for(int i = 0; i < nums.length; ++i)
		{
			curSum += nums[i];
		}
		
		return (int) (curSum == targetSum ? 0 : targetSum - curSum);
    }
	
	public String reverseStr(String s, int k) 
	{
		if(s == null) return s;
		
		StringBuffer reversedString = new StringBuffer();
		
		for(int i = 0; i < s.length();)
		{
			populateBuffer(i, k, s, reversedString, true);
			
			i += k;
			
			populateBuffer(i, k, s, reversedString, false);
			
			i += k;
		}
		
		return reversedString.toString();
	}
	
	private void populateBuffer(int startPos, int stepCount, String mainString, 
			                    StringBuffer reversedString, boolean isReversePopulate) 
	{
		if(isReversePopulate)
		{
			int curPos = startPos + stepCount - 1;
			
			while(curPos >= mainString.length())
			{
				--curPos;
			}
			
			while(curPos >= startPos)
			{
				reversedString.append(mainString.charAt(curPos));
				
				--curPos;
			}
		}
		else
		{
			int curPos = startPos;
			
			while(curPos < startPos + stepCount && curPos < mainString.length())
			{
				reversedString.append(mainString.charAt(curPos));
				
				++curPos;
			}
		}
	}

	public static void main(String[] args)
	{
		System.out.println(new MissingNumber().reverseStr("abcdefg", 2));
	}
}
