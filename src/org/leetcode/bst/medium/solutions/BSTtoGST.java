/**
 * 
 */
package org.leetcode.bst.medium.solutions;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class BSTtoGST {
	public TreeNode bstToGst_v1(TreeNode root) {
		helper(root, 0);
		return root;
	}

	public int helper(TreeNode node, int value) {
		if (node.right != null) {
			node.val += helper(node.right, value);
		} else {
			node.val += value;
		}
		value = node.val;
		if (node.left != null) {
			value = helper(node.left, value);
		}
		return value;
	}

	// using global variable and no helper method
	int val = 0;

	public TreeNode bstToGst_v2(TreeNode root) {
		if (root == null) {
			return root;
		}
		root.right = bstToGst_v2(root.right);
		root.val += val;
		val = root.val;
		root.left = bstToGst_v2(root.left);
		return root;
	}

	// More concise version of the v1 solution
	public TreeNode bstToGst_v3(TreeNode root) {
		convert(root, 0);
		return root;
	}

	public int convert(TreeNode node, int sum) {
		if (node == null) {
			return sum;
		}
		node.val += convert(node.right, sum);
		return convert(node.left, node.val);
	}
}
