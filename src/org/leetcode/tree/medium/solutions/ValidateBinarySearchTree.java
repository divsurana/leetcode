/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import java.util.LinkedList;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class ValidateBinarySearchTree {
	public boolean isValidBST_v1(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<Integer> queue = new LinkedList<>();
		inorder(root, queue);
		return isValid(queue);
	}

	public void inorder(TreeNode node, Queue<Integer> queue) {
		if (node == null) {
			return;
		}
		inorder(node.left, queue);
		queue.offer(node.val);
		inorder(node.right, queue);
	}

	public boolean isValid(Queue<Integer> queue) {
		int prev = queue.poll();
		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (prev >= current) {
				return false;
			}
			prev = current;
		}
		return true;
	}

	public boolean isValidBST_v2(TreeNode root) {
		return isValidBST(root, null, null);
	}

	private boolean isValidBST(TreeNode root, Integer low, Integer high) {
		if (root == null) {
			return true;
		}
		return (low == null || low < root.val) && (high == null || root.val < high)
				&& isValidBST(root.left, low, root.val) && isValidBST(root.right, root.val, high);
	}
}
