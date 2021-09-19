/**
 * 
 */
package org.eoplij.binarytrees;

import java.util.LinkedList;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class SumRootToLeafPathsInABinaryTree_10_5 {
	// Recursive
	public int sumNumbers_v1(TreeNode root) {
		return sum(root, 0);
	}

	private int sum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		sum = sum * 10 + root.val;
		return root.left == null && root.right == null ? sum : sum(root.left, sum) + sum(root.right, sum);
	}

	// Iterative
	public int sumNumbers_v2(TreeNode root) {
		int total = 0;
		LinkedList<TreeNode> q = new LinkedList<>();
		LinkedList<Integer> sumq = new LinkedList<>();
		if (root != null) {
			q.offer(root);
			sumq.offer(root.val);
		}
		while (!q.isEmpty()) {
			TreeNode current = q.poll();
			int partialSum = sumq.poll();
			if (current.left == null && current.right == null) {
				total += partialSum;
			} else {
				if (current.right != null) {
					q.offer(current.right);
					sumq.offer(partialSum * 10 + current.right.val);
				}
				if (current.left != null) {
					q.offer(current.left);
					sumq.offer(partialSum * 10 + current.left.val);
				}

			}

		}
		return total;
	}
}
