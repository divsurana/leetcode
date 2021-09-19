/**
 * 
 */
package org.eoplij.linkedlists;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class RemoveDuplicatesFromASortedList_8_8 {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode node = head;
		while (node != null && node.next != null) {
			while (node.next != null && node.next.val == node.val) {
				node.next = node.next.next;
			}
			node = node.next;
		}
		return head;
	}
}
