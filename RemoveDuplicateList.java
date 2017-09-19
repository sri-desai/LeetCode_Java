
public class RemoveDuplicateList 
{
	public ListNode deleteDuplicates(ListNode head) 
	{
		if(head == null)
		{
			return head;
		}
		
		ListNode curNode  = head;
		ListNode prevNode = null;
		
		long prevValueRemoved = Long.MAX_VALUE;
		
		while(curNode != null && curNode.next != null)
		{
			if(curNode.val == curNode.next.val)
			{
				curNode.next = curNode.next.next;
				
				prevValueRemoved = curNode.val;
			}
			else
			if(curNode.val == prevValueRemoved)
			{
				if(prevNode == null)
				{
					head = curNode.next;
					
					curNode = curNode.next;
				}
				else
				{
					prevNode.next = curNode.next;
					curNode = curNode.next;
				}
			}
			else
			{
				prevNode = curNode;
				curNode = curNode.next;
			}
		}
		
		if(curNode != null && curNode.val == prevValueRemoved)
		{
			if(prevNode == null)
			{
				return prevNode;
			}
			else
			{
				prevNode.next = null;
			}
		}
		
		return head;
	}
	
	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		
		new ListRotate().linkDisplay(new RemoveDuplicateList().deleteDuplicates(head));
	}
}
