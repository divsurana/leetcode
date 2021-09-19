/**
 * 
 */
package org.eoplij.binarytrees;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class BalancedBinaryTree_10_1 {
	boolean isBalanced = true;

	public boolean isBalanced_v1(TreeNode root) {
		height_v1(root);
		return isBalanced;
	}

	private int height_v1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height_v1(root.left);
		int rightHeight = height_v1(root.right);
		isBalanced = Math.abs(leftHeight - rightHeight) <= 1 && isBalanced;
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public boolean isBalanced_v2(TreeNode root) {
		return height_v2(root) != -1;
	}

	// Use the depth instead of isBalanced boolean where depth becomes -1
	// whenever the balance property is violated, thus enabling early
	// termination.
	private int height_v2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height_v2(root.left);
		if (leftHeight == -1) {
			return -1;
		}
		int rightHeight = height_v2(root.right);
		if (rightHeight == -1) {
			return -1;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
