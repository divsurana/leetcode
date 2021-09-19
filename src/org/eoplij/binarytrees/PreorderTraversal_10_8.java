/**
 * 
 */
package org.eoplij.binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class PreorderTraversal_10_8 {
	// Iterative
	public List<Integer> preorderTraversal_v2(TreeNode root) {
		List<Integer> order = new ArrayList<>();
		if (root == null) {
			return order;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			order.add(node.val);
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
		return order;
	}

	// Iterative
	public List<Integer> preorderTraversal_v3(TreeNode root) {
		List<Integer> preorder = new LinkedList<>();
		Stack<TreeNode> rights = new Stack<>();
		while (root != null) {
			preorder.add(root.val);
			if (root.right != null) {
				rights.push(root.right);
			}
			root = root.left;
			if (root == null && !rights.isEmpty()) {
				root = rights.pop();
			}
		}
		return preorder;

	}

	// Recursive
	public List<Integer> preorderTraversal_v1(TreeNode root) {
		return preorder(root, new ArrayList<Integer>());
	}

	private List<Integer> preorder(TreeNode root, List<Integer> order) {
		if (root == null) {
			return order;
		}
		order.add(root.val);
		preorder(root.left, order);
		return preorder(root.right, order);
	}
}
