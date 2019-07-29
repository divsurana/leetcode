/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _701_1 {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		if (root.val > val) {
			root.left = root.left == null ? new TreeNode(val) : insertIntoBST(root.left, val);
		} else {
			root.right = root.right == null ? new TreeNode(val) : insertIntoBST(root.right, val);
		}
		return root;
	}
}