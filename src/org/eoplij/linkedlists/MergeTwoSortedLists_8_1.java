/**
 * 
 */
package org.eoplij.linkedlists;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 21. Merge Two Sorted Lists -
// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists_8_1 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode node = new ListNode(0);
		ListNode pseudoHead = node;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = l1;
				l1 = l1.next;
			} else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}

		node.next = l1 == null ? l2 : l1;

		return pseudoHead.next;
	}
}
