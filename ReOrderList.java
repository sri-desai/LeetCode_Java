
public class ReOrderList 
{
	public void reorderList(ListNode head) 
	{
		if(head == null)
		{
			return;
		}
		
		ListNode slowPointer = head;
		ListNode fastPointer = head;
		ListNode newHead     = null;
		
		while(fastPointer != null && fastPointer.next != null && 
			  fastPointer.next.next != null)
		{
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		
		fastPointer = slowPointer.next;
		slowPointer.next = null;
		slowPointer      = head;
		
		while(fastPointer != null)
		{
			ListNode node = fastPointer;			
			fastPointer = fastPointer.next;
			newHead = insertAtHead(node, newHead);			
		}
		
		while(newHead != null && slowPointer != null)
		{
			ListNode nextNode = slowPointer.next;
			ListNode nextHead = newHead.next;
			
			slowPointer.next = newHead;
			newHead.next     = nextNode;
			
			newHead = nextHead;
			slowPointer = nextNode;
		}
		
		return;
		
    }

	private ListNode insertAtHead(ListNode nodeToInsert, ListNode head)
	{
		nodeToInsert.next = null;
		
		if(head != null)
		{
			nodeToInsert.next = head;
		}
		
		return nodeToInsert;
	}
	
	public void linkDisplay(ListNode head)
	{
		while(head != null)
		{
			System.out.println(head.val + "-->");
			
			head = head.next;
		}
		
		System.out.println("null");
	}
	
	public static void main(String[] args)
	{
		ReOrderList ReOrderList1 = new ReOrderList();
		
		ListNode head = new ListNode(1);
		head.next     = new ListNode(2);
		head.next.next     = new ListNode(3);
		head.next.next.next     = new ListNode(4);
		head.next.next.next.next     = new ListNode(5);
		head.next.next.next.next.next     = null;
	
		ListNode smallList = new ListNode(1);
		smallList.next = new ListNode(2);
		smallList.next.next = new ListNode(3);
		smallList.next.next.next = null;
		
		ReOrderList1.reorderList(null);
		ReOrderList1.linkDisplay(null);
		
		
	}
}
