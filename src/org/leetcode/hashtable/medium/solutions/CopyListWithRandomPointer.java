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
	public Node copyRandomList(Node head) {
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
