package com.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 */

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int carry = 0;
		ListNode result = new ListNode();
		// Current point used to populate the result linked list
		ListNode current = result;
		
		while(l1 != null || l2 != null) {
			int sum = 0;
			
			// Compute the sum
			if(l1 != null) sum += l1.val;
			if(l2 != null) sum += l2.val;
			
			// Add the carry if needed
			sum += carry;
			carry = sum / 10;
			current.val = sum % 10;
			
			// Move next
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
			
			if (l1 != null || l2 != null) {
				current.next = new ListNode();
				current = current.next;
			} else if (carry > 0) {
				// Need to add one more element if there's a carry
				current.next = new ListNode(carry);
			}
		}
		
		return result;
		
	}	

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}	
}
