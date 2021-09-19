/**
 * 
 */
package org.dailycoding;

import java.util.LinkedList;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class SerializeDeserializeBinaryTree {
	final static String SEPARATOR = " ";

	public static String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		StringBuffer buffer = new StringBuffer();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			buffer.append(node == null ? node : node.val).append(SEPARATOR);
			if (node != null) {
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}

		return buffer.toString();
	}

	public static TreeNode deserialize(String treeString) {
		String[] nodes = treeString.split(SEPARATOR);
		TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		for (int i = 1; i < nodes.length && !queue.isEmpty(); i += 2) {
			TreeNode node = queue.poll();
			if (!nodes[i].equals("null")) {
				node.left = new TreeNode(Integer.parseInt(nodes[i]));
				queue.offer(node.left);
			}
			if (!nodes[i + 1].equals("null")) {
				node.right = new TreeNode(Integer.parseInt(nodes[i + 1]));
				queue.offer(node.right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(0, new TreeNode(1, new TreeNode(3), null), new TreeNode(2));
		if (deserialize(serialize(node)).left.left.val == 3) {
			System.out.println("Test successful");
		} else {
			System.out.println("Test unsuccessful");
		}
	}
}
