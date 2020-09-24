
public class ReverseLinkedList11 
{
	public ListNode reverseBetween(ListNode head, int m, int n) 
	{
		if(head == null || m == n) return head; 
		
		ListNode mNode     = head;
		ListNode mPrevNode = null;
		ListNode nNode     = null;
		ListNode nPrevNode = null;
		ListNode nNextNode = null;
		
		int diff = n - m;
		
		while(--m > 0)
		{
			mPrevNode = mNode;
			mNode = mNode.next;
		}
		
		nPrevNode = mNode;
		nNode     = nPrevNode.next;
		nNextNode = nNode.next;
		
		while(diff-- > 0)
		{
			if(nNode != null) nNode.next = nPrevNode;			
			nPrevNode = nNode;
			nNode = nNextNode;
			if(nNextNode != null) nNextNode = nNextNode.next;
		}
		
		if(mPrevNode == null)
		{
			head = nPrevNode;
		}
		else
		{
			mPrevNode.next = nPrevNode;
		}
		
		mNode.next = nNode;
		
		return head;
    }
	
	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		head.next     = new ListNode(2);
		head.next.next = new ListNode(3);
		
		head = new ReverseLinkedList11().reverseBetween(head, 1, 3);
		
		while(head != null)
		{
			System.out.println(head.val);
			
			head = head.next;
		}
	}
}
