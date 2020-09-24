
public class ListRotate 
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
		ListRotate listObj = new ListRotate();
		
		ListNode head = new ListNode(1);
		head.next     = new ListNode(2);
		head.next.next     = new ListNode(3);
		head.next.next.next     = new ListNode(4);
		head.next.next.next.next     = new ListNode(5);
		head.next.next.next.next.next     = null;
	
		ListNode smallList = new ListNode(1);
		smallList.next = new ListNode(2);
		smallList.next.next = null;
		
		listObj.linkDisplay(listObj.rotateRight(smallList, 1));
		
	}
	
}
