/**
 * 
 */
package org.eoplij.binarytrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class SymmetricTree_10_2 {
	// Using queues
	public boolean isSymmetric_v1(TreeNode root) {
		boolean isSymmetric = true;
		Queue<TreeNode> leftQueue = new LinkedList<>();
		Queue<TreeNode> rightQueue = new LinkedList<>();
		leftQueue.offer(root);
		rightQueue.offer(root);

		while (isSymmetric && !leftQueue.isEmpty() && !rightQueue.isEmpty()) {
			TreeNode left = leftQueue.poll();
			TreeNode right = rightQueue.poll();

			isSymmetric = compare(left.left, right.right, leftQueue, rightQueue)
					&& compare(left.right, right.left, leftQueue, rightQueue);
		}
		return isSymmetric;
	}

	private boolean compare(TreeNode left, TreeNode right, Queue<TreeNode> leftQueue, Queue<TreeNode> rightQueue) {
		if (left != null && right != null) {
			if (left.val == right.val) {
				leftQueue.offer(left);
				rightQueue.offer(right);
				return true;
			}
		} else if (left == null && right == null) {
			return true;
		}
		return false;
	}

	// Using recursion
	public boolean isSymmetric_v2(TreeNode root) {
		return compare(root.left, root.right);
	}

	private boolean compare(TreeNode left, TreeNode right) {
		if (left != null && right != null) {
			return left.val == right.val && compare(left.left, right.right) && compare(left.right, right.left);
		} else if (left == null && right == null) {
			return true;
		}
		return false;
	}

	// Using stack
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root.left);
		stack.push(root.right);
		while (!stack.empty()) {
			TreeNode n1 = stack.pop(), n2 = stack.pop();
			if (n1 == null && n2 == null) {
				continue;
			}
			if (n1 == null || n2 == null || n1.val != n2.val) {
				return false;
			}
			stack.push(n1.left);
			stack.push(n2.right);
			stack.push(n1.right);
			stack.push(n2.left);
		}
		return true;
	}
}
