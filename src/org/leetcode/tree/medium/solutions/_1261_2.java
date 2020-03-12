/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _1261_2 {
	TreeNode root;
	Set<Integer> values = new HashSet<>();

	public _1261_2(TreeNode root) {
		if (root != null) {
			Stack<TreeNode> stack = new Stack<>();
			this.root = root;
			this.root.val = 0;
			stack.push(this.root);
			TreeNode node;

			while (!stack.isEmpty()) {
				node = stack.pop();
				this.values.add(node.val);
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
		return this.values.contains(target);
	}
}
