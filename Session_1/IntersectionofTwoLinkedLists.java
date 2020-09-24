
public class IntersectionofTwoLinkedLists 
{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
	{
		int firstListLen = getLength(headA);
		int secListLen   = getLength(headB);
		
		ListNode highestNode = firstListLen > secListLen ? headA : headB;
		ListNode smallNode   = highestNode == headA ? headB : headA;
		int buffLen = Math.abs(firstListLen - secListLen);
		
		while(buffLen-- != 0)
		{
			highestNode = highestNode.next;
		}
		
		while(smallNode != highestNode)
		{
			smallNode = smallNode.next;
			highestNode = highestNode.next;
		}
		
		
		return smallNode;
    }

	private int getLength(ListNode headA) 
	{
		int count = 0;
		
		while(headA != null)
		{
			++count;
			headA = headA.next;
		}
		
		return count;
	}
}
