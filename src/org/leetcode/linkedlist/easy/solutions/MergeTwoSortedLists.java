/**
 * 
 */
package org.leetcode.linkedlist.easy.solutions;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode pseudoHead = new ListNode(0);
		ListNode node = pseudoHead;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				node.next = l1;
				l1 = l1.next;
			} else {
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}

		node.next = l1 != null ? l1 : l2;

		return pseudoHead.next;
	}
}
