/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import org.leetcode.bst.medium.solutions.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _814_1 {
	public TreeNode pruneTree(TreeNode root) {
		if (root != null) {
			root.left = pruneTree(root.left);
			root.right = pruneTree(root.right);
			if (root.left == null && root.right == null) {
				if (root.val == 0)
					return null;
			}
		}
		return root;
	}
}