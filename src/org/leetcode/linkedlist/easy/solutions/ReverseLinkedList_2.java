/**
 * 
 */
package org.leetcode.linkedlist.easy.solutions;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class ReverseLinkedList_2 {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		return prev;
	}
}
