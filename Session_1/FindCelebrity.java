import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindCelebrity 
{
	public int findCelebrity(int n) 
    {
       List<Integer>  listOfPeople     = new ArrayList<>();
       Set<Integer>   peopleNotToCheck = new HashSet<>();
       int            curCelebrity     = -1;
       
       for(int i = 0; i < n; ++i)
       {
    	   listOfPeople.add(i);
       }
       
       for(int curPersonIdx = 0; curPersonIdx < listOfPeople.size(); ++curPersonIdx)
       {
    	   int personToCheck = listOfPeople.get(curPersonIdx);
    	   
    	   if(peopleNotToCheck.contains(personToCheck)) continue;
    	   
    	   boolean isSomeOneDontKnow = false;
    	   
    	   peopleNotToCheck.add(personToCheck);
    	   
    	   for(int curPerson : listOfPeople)
    	   {
    		   if(curPerson == personToCheck) continue;
    		   else
    		   if(knows(curPerson, personToCheck))
    		   {
    			   peopleNotToCheck.add(curPerson);
    		   }
    		   else
    		   {
    			   isSomeOneDontKnow = true;
    			   
    			   break;
    		   }
    	   }    	       	  
    	   
    	   if(!isSomeOneDontKnow && !doesHeKnowsSomeone(personToCheck, listOfPeople))
    	   {
    		   if(curCelebrity >= 0) return -1;
    		   
    		   curCelebrity = personToCheck;
    	   }
       }
       
       return curCelebrity;
    }
	
	private boolean doesHeKnowsSomeone (int toBeCelebrity, List<Integer>  listOfPeople)
	{
		 for(int curPerson : listOfPeople)
		 {
			 if(curPerson == toBeCelebrity) continue;
			 
			 if(knows(toBeCelebrity, curPerson)) return true;
		 }
		 
		 return false;
	}
	
	private boolean knows(int a, int b)
	{
		return true;
	}
	
	public static void main(String[] args)
	{
		int ans = new FindCelebrity().findCelebrity(2);
		
		System.out.println(ans);
	}
}
