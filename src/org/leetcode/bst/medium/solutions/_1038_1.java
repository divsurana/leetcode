/**
 * 
 */
package org.leetcode.bst.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class _1038_1 {
	public TreeNode bstToGst(TreeNode root) {
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
}
