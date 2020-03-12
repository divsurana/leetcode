/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import java.util.Stack;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _1261_1 {
	TreeNode root;

	// FindElements constructor
	public _1261_1(TreeNode root) {
		if (root != null) {
			Stack<TreeNode> stack = new Stack<>();
			this.root = root;
			this.root.val = 0;
			stack.push(this.root);
			TreeNode node;

			while (!stack.isEmpty()) {
				node = stack.pop();
				if (node.left != null) {
					node.left.val = 2 * node.val + 1;
					stack.push(node.left);
				}
				if (node.right != null) {
					node.right.val = 2 * node.val + 2;
					stack.push(node.right);
				}
			}
		}
	}

	public boolean find(int target) {
		if (this.root != null) {
			Stack<TreeNode> stack = new Stack<>();
			stack.push(this.root);
			TreeNode node;

			while (!stack.isEmpty()) {
				node = stack.pop();
				if (node.val == target)
					return true;
				if (node.left != null)
					stack.push(node.left);
				if (node.right != null)
					stack.push(node.right);
			}
		}

		return false;
	}
}
