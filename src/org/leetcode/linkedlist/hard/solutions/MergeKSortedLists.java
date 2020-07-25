/**
 * 
 */
package org.leetcode.linkedlist.hard.solutions;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode merge = null;

		for (int i = 0; i < lists.length; i++) {
			merge = merge(merge, lists[i]);
		}

		return merge;
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode pseudoHead = new ListNode(0);
		ListNode node = pseudoHead;

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
