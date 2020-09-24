import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange
{	
	public int[] smallestRange(List<List<Integer>> nums) 
	{
		int maxHeapNodeVal = Integer.MIN_VALUE;
		int minRangeStart = 0;
		int minRangeEnd   = Integer.MAX_VALUE;
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < nums.size(); ++i)
        {
        	minHeap.offer(new HeapNode(nums.get(i).get(0), 0, i));
        	
        	maxHeapNodeVal = Math.max(maxHeapNodeVal, nums.get(i).get(0));
        }
        
        while(minHeap.size() == nums.size())
        {
        	HeapNode minHeapNode = minHeap.remove();
        	
        	if(maxHeapNodeVal - minHeapNode.val < minRangeEnd - minRangeStart)
        	{
        		minRangeStart = minHeapNode.val;
        		minRangeEnd   = maxHeapNodeVal;
        	}
        	
        	if(minHeapNode.idx < nums.get(minHeapNode.row).size() - 1)
        	{
        		minHeap.offer(new HeapNode(nums.get(minHeapNode.row).get(minHeapNode.idx + 1),
        								   minHeapNode.idx + 1, minHeapNode.row));
            	
            	maxHeapNodeVal = Math.max(maxHeapNodeVal, 
            			                  nums.get(minHeapNode.row).get(minHeapNode.idx + 1));
        	}
        }
        
        return new int[] {minRangeStart, minRangeEnd};
    }
	
	public static void main(String[] args)
	{
		List<List<Integer>> mainList = new ArrayList();
		
		List<Integer> subList = new ArrayList<>();
		subList.add(4);
		subList.add(10);
		subList.add(15);
		subList.add(24);
		subList.add(26);
		mainList.add(subList);
		
		subList = new ArrayList<>();
		subList.add(0);
		subList.add(9);
		subList.add(12);
		subList.add(20);
		mainList.add(subList);
		
		subList = new ArrayList<>();
		subList.add(5);
		subList.add(18);
		subList.add(22);
		subList.add(30);
		mainList.add(subList);
		
		System.out.println(new SmallestRange().smallestRange(mainList));
	}
}


class HeapNode implements Comparable<HeapNode>
{
	int val;
	int idx;
	int row;
	
	
	public HeapNode(int val, int idx, int row) 
	{
		this.val = val;
		this.idx = idx;
		this.row = row;
	}


	@Override
	public int compareTo(HeapNode otherHeapNode) 
	{
		return this.val - otherHeapNode.val;
	}
	
}

