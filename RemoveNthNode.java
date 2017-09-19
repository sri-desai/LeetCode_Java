
public class RemoveNthNode
{
	public ListNode removeNthFromEnd(ListNode head, int n) 
	{
		if(n < 0 || head == null)
		{
			return head;
		}
		
		ListNode dummyNode = new ListNode(0);
		ListNode curNode = dummyNode;
		ListNode nextNode = dummyNode;
		dummyNode.next = head;
		
		for(int i = 0; i < n + 1; ++i)
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
