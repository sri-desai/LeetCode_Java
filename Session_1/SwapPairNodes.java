
public class SwapPairNodes 
{
	public ListNode swapPairs(ListNode head) 
	{
		if(head == null || head.next == null)
		{
			return head;
		}
		else
		{
			ListNode nextNode = head.next;
			head.next = swapPairs(head.next.next);			
			nextNode.next = head;		
			return nextNode;
		}
	}
}
