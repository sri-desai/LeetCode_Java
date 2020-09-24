import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists 
{
	public ListNode mergeKLists(ListNode[] lists) 
	{
		ListNode headNode = new ListNode(0);
		ListNode tailNode = headNode;
		
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
		
		while(!minHeap.isEmpty())
		{
			ListNode minElem = minHeap.remove();
			
			if(minElem.next != null) minHeap.add(minElem.next);
			
			tailNode = addElem(minElem, tailNode);
		}
		
		return headNode.next;
    }

	private ListNode addElem(ListNode minElem, ListNode tailNode) 
	{
		minElem.next = null;
		
		tailNode.next = minElem;
		
		tailNode = minElem;
		
		return tailNode;
	}

	public static void main(String[] args)
	{
		ListNode head1 = new ListNode(1);
		head1.next     = new ListNode(2);
		
		ListNode head2 = new ListNode(1);
		
		ListNode[] array = new ListNode[2];
		
		array[0] = head1;
		array[1] = head2;
		
		System.out.println(new MergekSortedLists().mergeKLists(array));
	}
}
