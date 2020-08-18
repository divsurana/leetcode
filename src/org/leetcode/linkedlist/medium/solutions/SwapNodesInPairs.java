/**
 * 
 */
package org.leetcode.linkedlist.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode node = head;
		ListNode prev = head;
		head = head.next;
		while (node != null && node.next != null) {
			ListNode next = node.next;
			prev.next = next;
			node.next = next.next;
			next.next = node;
			prev = node;
			node = node.next;
		}
		return head;
	}
}
