/**
 * 
 */
package org.leetcode.dfs.medium.solutions;

import java.util.Stack;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class SumOfNodesWithEvenValuedGrandparent {

	// bfs approach (iterative)
	public int sumEvenGrandparent_v1(TreeNode root) {
		int sum = 0;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {

			TreeNode node = stack.pop();

			if (node.val % 2 == 0) {

				if (node.left != null) {
					stack.push(node.left);

					if (node.left.left != null) {
						sum += node.left.left.val;
					}
					if (node.left.right != null) {
						sum += node.left.right.val;
					}
				}
				if (node.right != null) {
					stack.push(node.right);

					if (node.right.left != null) {
						sum += node.right.left.val;
					}
					if (node.right.right != null) {
						sum += node.right.right.val;
					}
				}
			} else {
				if (node.left != null) {
					stack.push(node.left);
				}
				if (node.right != null) {
					stack.push(node.right);
				}
			}

		}

		return sum;
	}

	// dfs approach (recursive)
	public int sumEvenGrandparent_v2(TreeNode root) {
		return getSum(root, false, false);
	}

	public int getSum(TreeNode node, boolean isEvenParent, boolean isEvenGrandparent) {
		if (node == null) {
			return 0;
		}
		int sum = 0;
		sum += getSum(node.left, node.val % 2 == 0, isEvenParent);
		sum += getSum(node.right, node.val % 2 == 0, isEvenParent);
		if (isEvenGrandparent) {
			sum += node.val;
		}
		return sum;
	}
}
