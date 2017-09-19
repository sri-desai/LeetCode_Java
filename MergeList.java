
public class MergeList
{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
	{
		ListNode head = new ListNode(Integer.MIN_VALUE);
		ListNode curNode = head;
		
		while(l1 != null && l2 != null)
		{
			if(l1.val < l2.val)
			{
				curNode.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			else
			{
				curNode.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			
			curNode = curNode.next;
		}
		
		ListNode nextNode = l1 == null ? l2 : l1;
		
		while(nextNode != null)
		{
			curNode.next = new ListNode(nextNode.val);
			
			curNode = curNode.next;
			nextNode = nextNode.next;
		}
		
		return head.next;
    }
}
