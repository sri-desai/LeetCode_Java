import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists 
{
	public ListNode mergeKLists(ListNode[] lists) 
	{
		if(lists == null || lists.length == 0) return null;
		
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() 
		{
			@Override
			public int compare(ListNode o1, ListNode o2) 
			{
				return o1.val - o2.val;
			}
		});
		
		for(int i = 0; i < lists.length; ++i)
		{
			if(lists[i] != null)
			minHeap.add(lists[i]);
		}
		
		ListNode head = new ListNode(0);
		ListNode tail = head;
		
		while(!minHeap.isEmpty())
		{
			ListNode newNode = minHeap.remove();
			
			if(newNode.next != null)
			minHeap.add(newNode.next);
			
			tail.next = newNode;
			tail      = newNode;
			tail.next = null;
		}
		
		return head.next;
    }
}
