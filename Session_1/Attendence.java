
public class Attendence
{
	public boolean checkRecord(String s) 
	{
		int A_Count = 0;
		int L_Count = 0;
		
		for(int i = 0; i < s.length(); ++i)
		{
			if(s.charAt(i) == 'A')
			{
				A_Count++;
				L_Count = 0;
				
				if(A_Count > 1) return false;
			}
			else
			if(s.charAt(i) == 'L')
			{
				L_Count++;
				
				if(L_Count > 2) return false;
			}
			else
			{
				L_Count = 0;
			}
			
		}
		
		return true;		
    }
}
