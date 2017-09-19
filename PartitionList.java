
public class PartitionList 
{
	public ListNode partition(ListNode head, int x) 
	{
		if(head == null)
		{
			return head;
		}
		
		ListNode firstHead = new ListNode(-1);
		ListNode firstTail = firstHead;
		ListNode secHead   = new ListNode(-1);
		ListNode secTail   = secHead;
		
		while(head != null)
		{						
			if(head.val < x)
			{
				firstTail = addItem(firstTail, head.val);
			}
			else
			{
				secTail = addItem(secTail, head.val);
			}
			
			head = head.next;
		}
		
		firstTail.next = secHead.next;
		
		return firstHead.next;
    }
	
	private ListNode addItem(ListNode tail, int item)
	{
		tail.next = new ListNode(item);
		
		return tail.next;
	}
	
	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		
		System.out.println(new PartitionList().partition(head, 2));
	}
}
