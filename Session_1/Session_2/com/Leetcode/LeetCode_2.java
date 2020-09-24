package com.Leetcode;

public class LeetCode_2 
{
    /* Add new node next to the given node and return the new node. */
    private ListNode addNewDigit(int digit, ListNode node) 
    {
        ListNode newDigit = new ListNode(digit);
        node.next = newDigit;
        return newDigit;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        int sum = 0;
        int carry = 0;
        ListNode retHead = new ListNode();
        ListNode tail = retHead;
        
        /* Return null on the empty input. */
        if (l1 == null || l2 == null) {
            return retHead.next;
        }
        
        /* Loop over all the digits untill they are exhausted in both the lists. */
        while (l1 != null || l2 != null) {
            
            /* Necessary computation to get the new digit. */
            sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
            carry = sum / 10;
            sum = sum % 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            
            /* Add new digit to main list. */
            tail = addNewDigit(sum, tail);
        }
        
        /* Add any remaining digit in the carry at the end. */
        if (carry != 0) {
            tail = addNewDigit(carry, tail);
        }
        
        /* Return the main list. */
        return retHead.next;
    }
    
    public static void main(String[] args) 
    {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        
        ListNode sumList = new LeetCode_2().addTwoNumbers(l1, l2);
        
        System.out.println(sumList);
    }
}
