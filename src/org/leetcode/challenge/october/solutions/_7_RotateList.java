/**
 * 
 */
package org.leetcode.challenge.october.solutions;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyesh_surana
 *
 */
public class _7_RotateList {
	public ListNode rotateRight_v1(ListNode head, int k) {
		if (head == null || k == 0)
			return head;
		ListNode node = head;
		int size = 0;
		while (node != null) {
			node = node.next;
			size++;
		}
		k = k % size;
		return helper(head, size, k);
	}

	private ListNode helper(ListNode head, int size, int k) {
		if (k == 0)
			return head;
		ListNode node = head;
		// Reach the node that needs to be at the end
		for (int i = 0; i < size - k - 1; i++) {
			node = node.next;
		}

		// Iterate further to find the last node
		ListNode next = node.next;
		while (next.next != null) {
			next = next.next;
		}
		next.next = head;
		head = node.next;
		node.next = null;
		return head;
	}

	public ListNode rotateRight_v2(ListNode head, int k) {
		if (head == null || k == 0)
			return head;
		ListNode node = head;
		int size = 1;
		while (node.next != null) {
			node = node.next;
			size++;
		}
		k = k % size;

		ListNode tail = node;
		node = head;
		for (int i = 0; i < size - k - 1; i++) {
			node = node.next;
		}
		tail.next = head;
		head = node.next;
		node.next = null;
		return head;
	}
}
