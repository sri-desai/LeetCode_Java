
public class IsCycleInList 
{
	 public ListNode detectCycle(ListNode head) 
	 {
		 if(head == null)
		 {
			 return head;
		 }
		 
		 ListNode slowPtr = head;
		 ListNode fastPtr = head;
		 
		 boolean isCyclePresent = false;
		 
		 while(slowPtr != null && fastPtr != null)
		 {
			 slowPtr = slowPtr.next;
			 
			 if(fastPtr.next != null)
			 {
				 fastPtr = fastPtr.next.next;
			 }
			 else
			 {
				 return null;
			 }
			 
			 if(slowPtr == fastPtr)
			 {
				 isCyclePresent = true;
				 
				 break;
			 }			 
		 }
		 
		 if(!isCyclePresent)
		 {
			 return null;
		 }
		 
		 slowPtr = head;
		 
		 while(slowPtr != fastPtr)
		 {
			 slowPtr = slowPtr.next;
			 fastPtr = fastPtr.next;
		 }
		 
		 return slowPtr;
	 }
}
