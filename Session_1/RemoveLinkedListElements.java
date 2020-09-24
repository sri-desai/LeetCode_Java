
public class RemoveLinkedListElements
{
	public ListNode removeElements(ListNode head, int val) 
	{		
		while(head != null && head.val == val)
		{
			head = head.next;
		}
		
		if(head == null) return head;		
		ListNode curNode = head;
		
		while(curNode != null)
		{
			while(curNode != null && curNode.next != null && curNode.next.val == val)
				curNode.next = curNode.next.next;
			
			if(curNode != null) curNode = curNode.next;				
		}
		
		return head;
	}
	
	public static void main(String[] args)
	{
		ListNode head = new ListNode(10);
		head.next     = new ListNode(20);
		
		head = new RemoveLinkedListElements().removeElements(head, 20);
		
		return;
	}
}
