
public class FirstBadVersion 
{
	public int firstBadVersion(int n) 
    {
        long low  = 1;
        long high = n;
        long badStart = n;
        
        while(low < high)
        {
        	int mid = (int) (low + (high - low) / 2);
        	
        	if(isBadVersion(mid))
        	{
        		high     = mid;
        		badStart = badStart > mid ? mid : badStart;        		
        	}
        	else
        	{
        		low = mid + 1;
        	}
        }
        
        return (int) (isBadVersion((int) badStart) ? badStart : -1);
    }

	private boolean isBadVersion(int mid) 
	{
		return false;
	}
}
