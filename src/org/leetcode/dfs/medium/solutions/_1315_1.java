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
public class _1315_1 {
	public int sumEvenGrandparent(TreeNode root) {
		int sum = 0;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {

			TreeNode node = stack.pop();

			if (node.val % 2 == 0) {

				if (node.left != null) {
					stack.push(node.left);

					if (node.left.left != null)
						sum += node.left.left.val;
					if (node.left.right != null)
						sum += node.left.right.val;
				}
				if (node.right != null) {
					stack.push(node.right);

					if (node.right.left != null)
						sum += node.right.left.val;
					if (node.right.right != null)
						sum += node.right.right.val;
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
}
