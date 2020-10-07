/**
 * 
 */
package org.leetcode.challenge.october.solutions;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _6_InsertIntoBST {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		if (root.val > val) {
			root.left = insertIntoBST(root.left, val);
		} else {
			root.right = insertIntoBST(root.right, val);
		}
		return root;
	}
}
