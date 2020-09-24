import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses
{
	String givenString;
	
	public List<String> restoreIpAddresses(String s) 
	{
		List<String> mainList = new ArrayList<>();
		List<int[]>  pointsList = new ArrayList<>();
			
		if(s == null || s.trim().isEmpty() || s.trim().length() < 4 || s.trim().length() > 12) return mainList;
		
		givenString = s.trim();
		getIpAddresses(0, 4, pointsList, mainList);
		
		return mainList;
    }
	
	private boolean isPointsValid(int[] prevPoint)
	{
		int number = Integer.parseInt(givenString.substring(prevPoint[0], prevPoint[1] + 1));
		
		if(number > 255) return false;
		if(prevPoint[1] - prevPoint[0] > 0 && givenString.charAt(prevPoint[0]) == '0') return false;
		
		return true;
	}

	private void getIpAddresses(int startPos, int partsRemain, List<int[]> breakPoints, List<String> mainList)
	{
		if(breakPoints.size() > 0)
		{
			if(!isPointsValid(breakPoints.get(breakPoints.size() - 1))) return;			
		}			
		
		if(partsRemain == 0)
		{
			if(startPos == givenString.length())
			{
				StringBuffer sbuff = new StringBuffer();
				
				for(int i = 0; i < breakPoints.size(); ++i)
				{
					sbuff.append(givenString.substring(breakPoints.get(i)[0], breakPoints.get(i)[1] + 1) + ".");									
				}
				
				if(sbuff.length() > 0) sbuff.deleteCharAt(sbuff.length() - 1);
				
				mainList.add(sbuff.toString());
			}
			
			return;
		}
		else
		{			
			int[] curPoints = new int[2];
			for(int i = startPos; i < givenString.length() && i < startPos + 3; ++i)
			{
				curPoints[0] = startPos;
				curPoints[1] = i;
				
				breakPoints.add(curPoints);
				
				getIpAddresses(i + 1, partsRemain - 1, breakPoints, mainList);
				
				breakPoints.remove(breakPoints.size() - 1);
			}
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(new RestoreIPAddresses().restoreIpAddresses("010010"));
	}
}
