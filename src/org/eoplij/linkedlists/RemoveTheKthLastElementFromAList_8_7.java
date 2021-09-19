/**
 * 
 */
package org.eoplij.linkedlists;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class RemoveTheKthLastElementFromAList_8_7 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode pseudoHead = new ListNode(0, head);
		ListNode first = head;
		ListNode second = pseudoHead;

		while (n-- > 0) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;

		return pseudoHead.next;
	}
}
