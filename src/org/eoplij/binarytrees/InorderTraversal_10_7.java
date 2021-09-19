/**
 * 
 */
package org.eoplij.binarytrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class InorderTraversal_10_7 {
	// Iterative
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> order = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;

		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				order.add(node.val);
				node = node.right;
			}
		}

		return order;
	}

	// Recursive
	public List<Integer> inorderTraversal_v1(TreeNode root) {
		return inorder(root, new ArrayList<Integer>());
	}

	private List<Integer> inorder(TreeNode root, List<Integer> order) {
		if (root == null) {
			return order;
		}
		inorder(root.left, order);
		order.add(root.val);
		return inorder(root.right, order);
	}
}
