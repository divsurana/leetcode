/**
 * 
 */
package org.leetcode.linkedlist.hard.solutions;

import java.util.PriorityQueue;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode merge = null;

		for (ListNode list : lists) {
			merge = merge(merge, list);
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

	public ListNode mergeKLists_v2(ListNode[] lists) {
		PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
		for (ListNode node : lists) {
			if (node != null) {
				heap.offer(node);
			}
		}
		ListNode pseudoHead = new ListNode();
		ListNode node = pseudoHead;

		while (!heap.isEmpty()) {
			node.next = heap.poll();
			node = node.next;
			if (node.next != null) {
				heap.offer(node.next);
			}
		}

		return pseudoHead.next;
	}
}
