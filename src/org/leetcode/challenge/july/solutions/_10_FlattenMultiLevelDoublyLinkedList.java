/**
 * 
 */
package org.leetcode.challenge.july.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _10_FlattenMultiLevelDoublyLinkedList {
	class Node {
		public int val;
		public Node prev;
		public Node next;
		public Node child;
	};

	public Node flatten(Node head) {
		if (head == null)
			return head;
		Node next = null;
		if (head.child != null) {
			next = head.next;
			head.next = head.child;
			head.next.prev = head;
			head.child = null;
		}
		flatten(head.next);
		if (next != null) {
			Node pseudo = head;
			while (pseudo.next != null) {
				pseudo = pseudo.next;
			}
			pseudo.next = next;
			next.prev = pseudo;
		}
		return head;
	}
}
