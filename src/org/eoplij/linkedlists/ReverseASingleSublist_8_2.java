/**
 * 
 */
package org.eoplij.linkedlists;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class ReverseASingleSublist_8_2 {
	ListNode tailEnd;
	ListNode newHead;

	public ListNode reverseBetween_v1(ListNode head, int left, int right) {
		int pos = 0;
		ListNode pseudoHead = new ListNode(0);
		pseudoHead.next = head;
		ListNode node = pseudoHead;
		while (pos + 1 < left) {
			node = node.next;
			pos++;
		}
		ListNode child = reverse(node.next, pos + 1, right);
		child.next = tailEnd;
		node.next = newHead;

		return pseudoHead.next;
	}

	private ListNode reverse(ListNode node, int pos, int right) {
		if (pos == right) {
			tailEnd = node.next;
			newHead = node;
		} else {
			ListNode parent = reverse(node.next, pos + 1, right);
			parent.next = node;
		}
		return node;
	}

	public ListNode reverseBetween_v2(ListNode head, int left, int right) {
		if (left == right) { // No need to reverse since start == finish.
			return head;
		}
		ListNode pseudoHead = new ListNode(0);
		pseudoHead.next = head;
		ListNode sublistHead = pseudoHead;
		int pos = 1;
		while (pos++ < left) {
			sublistHead = sublistHead.next;
		}
		// Reverse sublist.
		ListNode sublistIter = sublistHead.next;
		while (left++ < right) {
			ListNode temp = sublistIter.next;
			sublistIter.next = temp.next;
			temp.next = sublistHead.next;
			sublistHead.next = temp;
		}
		return pseudoHead.next;
	}

	// Variant
	public ListNode reverseList_v1(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode pseudoHead = new ListNode(0);
		pseudoHead.next = head;
		while (head.next != null) {
			ListNode temp = head.next;
			head.next = temp.next;
			temp.next = pseudoHead.next;
			pseudoHead.next = temp;
		}
		return pseudoHead.next;
	}

	public ListNode reverseList_v2(ListNode head) {
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
