import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage 
{
	private int  maxSize;
	private long sum;
	private Queue<Integer> queue;	
	
	/** Initialize your data structure here. */
    public MovingAverage(int size) 
    {
    	sum     = 0L;
        queue   = new LinkedList<>(); 
        maxSize = size;
    }
    
    public double next(int val)
    {
        if(queue.size() == maxSize)
        {
        	sum -= queue.remove();        	
        }
        
        sum += val;
        
    	queue.add(val);
    	
    	return sum / (double)queue.size();
    }
}
