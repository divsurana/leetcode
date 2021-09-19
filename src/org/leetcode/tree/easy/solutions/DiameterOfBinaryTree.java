/**
 * 
 */
package org.leetcode.tree.easy.solutions;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class DiameterOfBinaryTree {
	int maxDiameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		height(root);
		return maxDiameter - 1;
	}

	private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int l = height(root.left);
		int r = height(root.right);
		int height = Math.max(l, r) + 1;
		maxDiameter = Math.max(maxDiameter, l + r + 1);
		return height;
	}
}
