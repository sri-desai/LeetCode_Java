import java.util.PriorityQueue;

public class kthSmallElement 
{
	
	public int kthSmallest(int[][] matrix, int k) 
	{
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        PriorityQueue<MinHeapNode> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < matrix.length; ++i)
        {
        	minHeap.add(new MinHeapNode(matrix[i][0], i, 0));
        }
        
        for(int i = 0; i < k - 1 && !minHeap.isEmpty(); ++i)
        {
        	MinHeapNode minNode = minHeap.poll();
        	
        	if(minNode.colNumber < matrix[0].length - 1)
        	{
        		minHeap.offer(new MinHeapNode(matrix[minNode.rowNumber][minNode.colNumber + 1],
        				                      minNode.rowNumber, minNode.colNumber + 1));
        	}
        }
        
        return !minHeap.isEmpty() ? minHeap.remove().nodeVal : 0;   
    }

	public static void  main(String[] args)
	{
		int[][] matrix = {
		                  { 1, 2},
		                  {1, 3}
						 };
		
		System.out.println(new kthSmallElement().kthSmallest(matrix, 2));
	}
}

class MinHeapNode implements Comparable<MinHeapNode>
{
	int nodeVal;
	int rowNumber;
	int colNumber;
	
	public MinHeapNode(int val, int row, int col) 
	{
		this.nodeVal = val;
		this.rowNumber = row;
		this.colNumber = col;
	}
	
	@Override
	public int compareTo(MinHeapNode otherNode) 
	{
		return this.nodeVal - otherNode.nodeVal;
	}
}
