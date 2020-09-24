
public class RotateList 
{
	 public ListNode rotateRight(ListNode head, int k) 
		{
			if(head == null || k == 0)
			{
				return head;
			}
			
			ListNode size = head;
			long sizeCount = 0;
			
			while(size != null)
			{
				size = size.next;
				
				++sizeCount;
			}
			
			if(sizeCount <= k)
			{
				k = (int) (k % sizeCount);
			}
			
			if(0 == k)
			{
				return head;
			}
			
			ListNode nextHead = head;
			ListNode prevHelper = null;
			ListNode curTail = head;
			
			while(k -- > 1 && curTail != null)
			{
				curTail = curTail.next;
			}
			
			while(curTail != null && curTail.next != null)
			{
				prevHelper = nextHead;
				nextHead   = nextHead.next;
				curTail    = curTail.next;
			}
			
			if(prevHelper != null)
			{
				prevHelper.next = null;
			}
			
			if(curTail != null)
			{
				curTail.next = head;
			}
			
			return nextHead;    
	    }
	
	public static void main(String[] args)
	{
		ListNode head  = new ListNode(10);
		head.next      = new ListNode(20);
		head.next.next = new ListNode(30);
		
		new RotateList().rotateRight(head, 3);
		
		return;
	}
}
