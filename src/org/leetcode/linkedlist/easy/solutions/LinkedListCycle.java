/**
 * 
 */
package org.leetcode.linkedlist.easy.solutions;

import java.util.HashSet;
import java.util.Set;

import org.leetcode.linkedlist.medium.solutions.ListNode;

/**
 * @author divyeshsurana
 *
 */
public class LinkedListCycle {
	public boolean hasCycle_v1(ListNode head) {
		Set<ListNode> set = new HashSet<>();

		while (head != null) {
			if (set.contains(head)) {
				return true;
			}
			set.add(head);
			head = head.next;
		}

		return false;
	}

	public boolean hasCycle_v2(ListNode head) {
		ListNode node = head;
		ListNode fastNode = head == null ? null : head.next;

		while (node != null && fastNode != null) {
			if (node == fastNode) {
				return true;
			}
			node = node.next;
			fastNode = fastNode.next == null ? null : fastNode.next.next;
		}

		return false;
	}

	public boolean hasCycle_v3(ListNode head) {
		ListNode node = head;
		ListNode fastNode = head;

		while (fastNode != null && fastNode.next != null) {
			node = node.next;
			fastNode = fastNode.next.next;
			if (node == fastNode) {
				return true;
			}
		}

		return false;
	}
}
