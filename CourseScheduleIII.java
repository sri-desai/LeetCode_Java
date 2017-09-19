import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII 
{
	public int scheduleCourse(int[][] courses) 
	{
		Arrays.sort(courses, (a, b)->a[1] - b[1]);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);		
		
		int curdthDay = 0;
		
		for(int[] course : courses)
		{
			curdthDay += course[0];
			
			maxHeap.add(course[0]);
			
			if(curdthDay > course[1]) 
				curdthDay -= maxHeap.poll();
		}
		
		return maxHeap.size();
    }

	
	
	public static void main(String[] args)
	{
		int[][] courses = {{100, 200}, {200, 250}, {1000, 250}, {2000, 3200}};
		
		System.out.println(new CourseScheduleIII().scheduleCourse(courses));
	}
}
