/**
 * 
 */
package org.leetcode.hashtable.medium.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author divyeshsurana
 *
 */
public class CopyListWithRandomPointer {
	public Node copyRandomList_v1(Node head) {
		Node node = head;
		Map<Node, Node> map = new HashMap<>();

		while (node != null) {
			Node copy = map.getOrDefault(node, new Node(node.val));
			map.put(node, copy);

			copy.next = node.next == null ? null : map.getOrDefault(node.next, new Node(node.next.val));
			map.put(node.next, copy.next);

			copy.random = node.random == null ? null : map.getOrDefault(node.random, new Node(node.random.val));
			map.put(node.random, copy.random);

			node = node.next;
		}

		return map.get(head);

	}

	public Node copyRandomList_v2(Node head) {
		if (head == null) {
			return null;
		}

		// Make copies of each node
		Node node = head;
		while (node != null) {
			Node copy = new Node(node.val);
			copy.next = node.next;
			node.next = copy;
			node = copy.next;
		}

		// Replace random pointers with the copies
		node = head;
		while (node != null) {
			node.next.random = node.random != null ? node.random.next : null;
			node = node.next.next;
		}

		// Separate the copies from the original nodes
		Node pseudoHead = head.next;
		while (head != null) {
			Node next = head.next;
			head.next = next.next;
			next.next = next.next != null ? next.next.next : null;
			head = head.next;
		}

		return pseudoHead;
	}

	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
