import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Priority_Obj
{
	int   sum;
	int[] elem = new int[2];
}

public class FindKPairswithSmallestSums
{
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) 
    {
        PriorityQueue<Priority_Obj> minHeap = new PriorityQueue<>(new Comparator<Priority_Obj>() {

			@Override
			public int compare(Priority_Obj o1, Priority_Obj o2) 
			{
				return o1.sum - o2.sum;
			}
		});
        
        return null;
        
        
    }
}
