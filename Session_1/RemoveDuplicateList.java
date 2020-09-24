
public class RemoveDuplicateList 
{
	public ListNode deleteDuplicates(ListNode head) 
	{
		ListNode newHead  = null;
		ListNode tailNode = null;
		
		while(head != null)
		{			
			if(!checkDuplicateAndRemove(head))
			{
				if(newHead == null)
				{
					newHead  = head;
					tailNode = newHead;
				}
				else
				{
					tailNode.next = head;					
					tailNode = tailNode.next;
				}
			}
			
			head = head.next;
		}
		 
		if(tailNode != null) tailNode.next = null;
		
		return newHead;
	}
	
	private boolean checkDuplicateAndRemove(ListNode curNode) 
	{
		boolean isDupPresent = false;
		
		if(curNode != null && curNode.next != null)
		{
			while(curNode.next != null && curNode.val == curNode.next.val)
			{
				curNode.next = curNode.next.next;
				
				isDupPresent = true;
			}
		}
		
		return isDupPresent;
	}

	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		
		head = new RemoveDuplicateList().deleteDuplicates(head);
		
		System.out.println(head);
	}
}
