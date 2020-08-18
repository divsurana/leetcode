/**
 * 
 */
package org.leetcode.tree.hard.solutions;

import java.util.LinkedList;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class SerializeAndDeserializeBinaryTree {
	public static String SEPARATOR = ":";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuffer buffer = new StringBuffer();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			buffer.append(root.val).append(SEPARATOR);
			queue.offer(root);
		}

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();

			if (node.left == null) {
				buffer.append("NULL").append(SEPARATOR);
			} else {
				buffer.append(node.left.val).append(SEPARATOR);
				queue.offer(node.left);
			}

			if (node.right == null) {
				buffer.append("NULL").append(SEPARATOR);
			} else {
				buffer.append(node.right.val).append(SEPARATOR);
				queue.offer(node.right);
			}

		}
		return buffer.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] nodes = data.split(SEPARATOR);
		TreeNode head = null;
		Queue<TreeNode> queue = new LinkedList<>();

		for (int i = 0; i < nodes.length - 1; i++) {
			if (queue.isEmpty()) {
				head = nodes[i].equals("NULL") ? null : new TreeNode(Integer.parseInt(nodes[i]));
				queue.offer(head);
			} else {
				TreeNode node = queue.poll();
				if (nodes[i].equals("NULL")) {
					node.left = null;
				} else {
					node.left = new TreeNode(Integer.parseInt(nodes[i]));
					queue.offer(node.left);
				}

				if (nodes[i + 1].equals("NULL")) {
					node.right = null;
				} else {
					node.right = new TreeNode(Integer.parseInt(nodes[i + 1]));
					queue.offer(node.right);
				}
				i++;
			}
		}

		return head;
	}
}
