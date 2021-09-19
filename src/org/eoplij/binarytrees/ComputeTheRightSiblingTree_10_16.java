/**
 * 
 */
package org.eoplij.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author divyeshsurana
 *
 */
public class ComputeTheRightSiblingTree_10_16 {
	// Definition for a Node.
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};

	public Node connect_v1(Node root) {
		if (root == null) {
			return root;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int n = queue.size();
			while (n-- > 0) {
				Node node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				if (n != 0) {
					node.next = queue.peek();
				}
			}
		}

		return root;
	}

	// Using the benefit of the next field and eliminating the use of queue
	public Node connect_v2(Node root) {
		if (root == null) {
			return root;
		}
		Node node = root;

		while (node != null && node.left != null) {
			populateNextLevel(node);
			node = node.left;
		}

		return root;
	}

	private void populateNextLevel(Node node) {
		Node start = node;
		while (start != null) {
			start.left.next = start.right;
			if (start.next != null) {
				start.right.next = start.next.left;
			}
			start = start.next;
		}
	}
}
