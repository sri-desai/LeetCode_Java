import java.util.Arrays;

public class CourseSchedule 
{
	public int scheduleCourse(int[][] courses) 
	{
		if(courses == null) return 0;
		
		
		return chooseCourseCount (0, 0, courses);
    }

	private int chooseCourseCount(int curCourse, int curDthDay, int[][] courses) 
	{
		if(curCourse >= courses.length) return 0;		
		
		boolean choosenCurcourse = false;
		
		if(courses[curCourse][1] - curDthDay > courses[curCourse][0])
		{
			choosenCurcourse = true;
		}
		
		int firstPlan = choosenCurcourse == false ? 0 : 1 + chooseCourseCount(curCourse + 1, curDthDay + courses[curCourse][0], courses);
		int secPlan   = chooseCourseCount(curCourse + 1, curDthDay, courses);
		
		return Math.max(firstPlan, secPlan);
	}
	
	public static void main(String[] args)
	{
		int[][] courses = {{2,5},{2,19},{1,8},{1,3}};
		
		System.out.println(new CourseSchedule().scheduleCourse(courses));
	}
	
	
}
