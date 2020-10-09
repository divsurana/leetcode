/**
 * 
 */
package org.leetcode.challenge.october.solutions;

import java.util.LinkedList;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _9_SerializeAndDeserializeBST {
	private String SEPARATOR = ",";
	private String EMPTY = "NULL";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null)
			return "";
		StringBuffer buffer = new StringBuffer();
		Queue<TreeNode> queue = new LinkedList<>();
		buffer.append(root.val).append(SEPARATOR);
		queue.offer(root);

		while (!queue.isEmpty()) {
			for (int i = queue.size(); i > 0; i--) {
				TreeNode node = queue.poll();
				if (node.left == null) {
					buffer.append(EMPTY).append(SEPARATOR);
				} else {
					buffer.append(node.left.val).append(SEPARATOR);
					queue.offer(node.left);
				}

				if (node.right == null) {
					buffer.append(EMPTY).append(SEPARATOR);
				} else {
					buffer.append(node.right.val).append(SEPARATOR);
					queue.offer(node.right);
				}
			}
		}
		return buffer.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.isEmpty())
			return null;
		String[] nodes = data.split(SEPARATOR);
		TreeNode head = new TreeNode(Integer.parseInt(nodes[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(head);

		for (int i = 1; i < nodes.length - 1 && !queue.isEmpty(); i += 2) {
			TreeNode parent = queue.poll();
			String leftNode = nodes[i];
			String rightNode = nodes[i + 1];

			if (!leftNode.equals(EMPTY)) {
				parent.left = new TreeNode(Integer.parseInt(leftNode));
				queue.offer(parent.left);
			}
			if (!rightNode.equals(EMPTY)) {
				parent.right = new TreeNode(Integer.parseInt(rightNode));
				queue.offer(parent.right);
			}
		}

		return head;
	}
}
