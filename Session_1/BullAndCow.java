
public class BullAndCow 
{
	public String getHint(String secret, String guess) 
	{
		if(secret == null || guess == null)
		{
			return null;
		}
		
		int bullCount = 0;
		int cowCount  = 0;
		
		int[] count = new int[10];
		
		for(int i = 0; i < secret.length(); ++i)
		{
			count[secret.charAt(i) - '0']++;
		}
		
		for(int i = 0; i < guess.length(); ++i)
		{
			if(secret.charAt(i) == guess.charAt(i))
			{
				++bullCount;
				
				count[guess.charAt(i) - '0']--;
			}
			else
			{
				if(count[guess.charAt(i) - '0'] > 0)
				{
					count[guess.charAt(i) - '0']--;
					
					++cowCount;
				}
			}
		}		
				
		return new String(bullCount + "A" + cowCount + "B");
    }
	
	public static void main(String[] args)
	{
		System.out.println(new BullAndCow().getHint("11", "10"));
	}
}
