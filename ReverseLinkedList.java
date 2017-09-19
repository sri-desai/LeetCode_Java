
public class ReverseLinkedList
{
	public ListNode reverseList(ListNode head) 
    {
		return reverseListRecursive(head, null);
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
	
	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next     = new ListNode(2);
		
		head = new ReverseLinkedList().reverseList(head);
		
		return;
	}
}
