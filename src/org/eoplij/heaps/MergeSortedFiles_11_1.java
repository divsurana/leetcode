/**
 * 
 */
package org.eoplij.heaps;

import java.util.PriorityQueue;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class MergeSortedFiles_11_1 {
	// Using heap (Better for other scenarios like stream of data as well)
	public ListNode mergeKLists_v1(ListNode[] lists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> Integer.compare(node1.val, node2.val));

		for (ListNode list : lists) {
			while (list != null) {
				minHeap.add(list);
				list = list.next;
			}
		}

		ListNode result = minHeap.poll();
		ListNode node = result;
		while (!minHeap.isEmpty()) {
			node.next = minHeap.poll();
			node = node.next;
		}
		if (node != null) {
			node.next = null;
		}
		return result;
	}

	// Adapted from the book where the minheap is created as we go so as to keep
	// the heap size small
	public ListNode mergeKLists_v2(ListNode[] lists) {
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>((node1, node2) -> Integer.compare(node1.val, node2.val));

		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				minHeap.add(lists[i]);
			}
		}

		ListNode result = new ListNode(0);
		ListNode node = result;
		while (!minHeap.isEmpty()) {
			node.next = minHeap.poll();
			node = node.next;
			if (node.next != null) {
				minHeap.add(node.next);
			}
		}
		if (node != null) {
			node.next = null;
		}
		return result.next;
	}

	// Using merge 2 lists
	public ListNode mergeKLists_v3(ListNode[] lists) {
		int i = 0, j = 0, k = lists.length;

		while (k > 1) {
			if (j == k - 1) {
				lists[i] = lists[j];
			} else {
				lists[i] = merge(lists[j], lists[j + 1]);
			}
			if (j == k - 1 || j + 1 == k - 1) {
				i = j = 0;
				k = (k + 1) / 2;
			} else {
				i++;
				j += 2;
			}
		}

		return k == 0 ? null : lists[0];
	}

	public ListNode merge(ListNode node1, ListNode node2) {
		if (node1 == null) {
			return node2;
		}
		if (node2 == null) {
			return node1;
		}
		if (node1.val > node2.val) {
			return merge(node2, node1);
		}
		ListNode pseudoHead = new ListNode(0, node1);
		while (node1.next != null && node2 != null) {
			if (node1.next.val > node2.val) {
				ListNode temp = node1.next;
				node1.next = node2;
				node2 = temp;
			}
			node1 = node1.next;
		}
		if (node1.next == null) {
			node1.next = node2;
		}
		return pseudoHead.next;
	}
}
