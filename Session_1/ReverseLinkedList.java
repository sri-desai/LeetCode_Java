
public class ReverseLinkedList
{
	public ListNode reverseList(ListNode head) 
    {
		return reverseListIterative(head);
    }

	private ListNode reverseListRecursive(ListNode curNode, ListNode prevNode) 
	{		
		if(curNode == null)
		{
			return prevNode;		
		}
		else
		{
			ListNode next = curNode.next;
			
			curNode.next = prevNode;
			
			return reverseListRecursive(next, curNode);
		}
	}
	
	private ListNode reverseListIterative (ListNode head)
	{
		if(head == null) return null;
		
		ListNode curNode  = head;
		ListNode prevNode = null;
		ListNode nextNode = curNode.next;
		
		while(curNode != null)
		{
			curNode.next = prevNode;
			
			prevNode     = curNode;
			curNode      = nextNode;
			nextNode     = nextNode == null ? nextNode : nextNode.next;
		}
		
		return prevNode;
	}
	
	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		//head.next     = new ListNode(2);
		
		head = new ReverseLinkedList().reverseList(head);
		
		return;
	}
}
