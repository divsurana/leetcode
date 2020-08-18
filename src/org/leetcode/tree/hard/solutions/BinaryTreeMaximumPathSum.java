/**
 * 
 */
package org.leetcode.tree.hard.solutions;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class BinaryTreeMaximumPathSum {
	int maxSum = Integer.MIN_VALUE;

	// Using global variable
	public int maxPathSum_v1(TreeNode root) {
		calculatePathSum_v1(root);
		return maxSum;
	}

	private int calculatePathSum_v1(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftSum = calculatePathSum_v1(node.left);
		int rightSum = calculatePathSum_v1(node.right);
		int totalSum = Math.max(node.val, leftSum + rightSum + node.val);

		if (leftSum != 0) {
			maxSum = Math.max(maxSum, leftSum);
			maxSum = Math.max(maxSum, leftSum + node.val);
		}
		if (rightSum != 0) {
			maxSum = Math.max(maxSum, rightSum);
			maxSum = Math.max(maxSum, rightSum + node.val);
		}
		maxSum = Math.max(maxSum, totalSum);

		return Math.max(node.val, Math.max(leftSum + node.val, rightSum + node.val));
	}

	// Without using global variable
	public int maxPathSum_v2(TreeNode root) {
		return calculatePathSum_v2(root, Integer.MIN_VALUE);
	}

	private int calculatePathSum_v2(TreeNode node, int max) {
		if (node == null) {
			return max;
		}

		max = Math.max(max, calculatePathSum_v2(node.left, max));
		max = Math.max(max, calculatePathSum_v2(node.right, max));

		int leftSum = node.left == null ? 0 : node.left.val;
		int rightSum = node.right == null ? 0 : node.right.val;
		int totalSum = Math.max(node.val, leftSum + rightSum + node.val);

		if (leftSum != 0) {
			max = Math.max(max, leftSum);
			max = Math.max(max, leftSum + node.val);
		}
		if (rightSum != 0) {
			max = Math.max(max, rightSum);
			max = Math.max(max, rightSum + node.val);
		}
		max = Math.max(max, totalSum);
		node.val = Math.max(node.val, Math.max(leftSum + node.val, rightSum + node.val));

		return max;
	}
}
