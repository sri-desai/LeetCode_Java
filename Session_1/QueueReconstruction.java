import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstruction
{
	public int[][] reconstructQueue(int[][] people) 
	{
		if(people.length == 0) return people;
		
		Arrays.sort(people, new Comparator<int[]>() 
		{
			@Override
			public int compare(int[] o1, int[] o2) 
			{
				// TODO Auto-generated method stub
				return o2[0] == o1[0] ? o1[1] - o2[1] : o2[0] - o1[0];
			}
		});
		
		List<int[]> list = new ArrayList<>();
		
		for(int person[] : people)
		{
			list.add(person[1], person);
		}
		
	   int[][] retVal = new int[people.length][people[0].length];
	   int i = 0;
	   
	   for(int person[] : list)
	   {
		   retVal[i++] = person;
	   }
	   
	   return retVal;
		
    }
	
	public static void main(String[] args)
	{
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		
		System.out.println(Arrays.deepToString(new QueueReconstruction().reconstructQueue(people)));
	}
}
