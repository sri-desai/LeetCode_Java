
public class RemoveNthNode
{
	public ListNode removeNthFromEnd(ListNode head, int n) 
	{
		if(n < 0 || head == null)
		{
			return head;
		}
		
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode curNode = dummyNode;
		ListNode nextNode = dummyNode;		
		
		for(int i = 0; i < n; ++i)
		{
			nextNode = nextNode.next;
		}
		
		if(nextNode == null)
		{
			return head;
		}
		
		while(nextNode.next != null)
		{		
			curNode = curNode.next;
			
			nextNode = nextNode.next;
		}
		
		if(curNode != null && curNode.next != null)
		{
			curNode.next = curNode.next.next;
		}
		
		return dummyNode.next;
    }
	
}
