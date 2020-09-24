import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PhoneDirectory
{
	private int 		   maxNumbersAllowed;
	private int 		   curNumberToAssign;
	private Set<Integer>   assignedNumbers;
	private Queue<Integer> releasedNumbers;
	
	/** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public PhoneDirectory(int maxNumbers) 
	{
		maxNumbersAllowed = maxNumbers;
		curNumberToAssign = 0;
		assignedNumbers   = new HashSet<>();
		releasedNumbers   = new LinkedList<>();
	}

	/** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
	public int get() 
	{
		int retNumber;
		
		if(!releasedNumbers.isEmpty()) 
		{
			retNumber = releasedNumbers.remove();
		}
		else
		if(curNumberToAssign < maxNumbersAllowed)
		{
			retNumber = curNumberToAssign++;			
		}
		else
		{
			retNumber = -1;
		}
		
		if(retNumber >= 0) 
		{
			assignedNumbers.add(retNumber);
		}
		
		return retNumber;
	}

	/** Check if a number is available or not. */
	public boolean check(int number)
	{					
		return !assignedNumbers.contains(number) && number >= 0 && number < maxNumbersAllowed;
	}

	/** Recycle or release a number. */
	public void release(int number)
	{
		if(assignedNumbers.remove(number))
		{
			releasedNumbers.add(number);
		}
	}
}
