

/* Need to correct the code */
public class PalindromeLinkedList
{
	public boolean isPalindrome(ListNode head)
	{
		if(head == null) return true;
		
		boolean isEven = true;
		
		int firstHalf = 0;
		int secHalf   = 0;
		
		ListNode mid;
		ListNode curHead;
		ListNode end;
		
		mid = head;
		curHead = head;
		end = head;
		
		while(end.next != null && end.next.next != null)
		{
			end = end.next.next;
			mid = mid.next;
		}
		
		if(end.next == null) 
		{
			end = mid; 
			isEven = false;
			mid = mid.next;
		}
			
		for(curHead = head; (!isEven && curHead != end) || (isEven && mid != null); curHead = curHead.next)
		{
			firstHalf *= 10 + curHead.val;
			secHalf   *= 10 + mid.val;
			
			mid = mid.next;
		}
		
		return firstHalf == secHalf;
		
    }

	public static void main(String[] args)
	{
		ListNode head = new ListNode(10);
		head.next     = new ListNode(20);
		
		System.out.println(new PalindromeLinkedList().isPalindrome(head));
	}
}
