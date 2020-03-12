/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _1325_1 {
	public TreeNode removeLeafNodes(TreeNode root, int target) {
		if (root != null) {
			root.left = removeLeafNodes(root.left, target);
			root.right = removeLeafNodes(root.right, target);
			if (root.val == target && root.left == null && root.right == null) {
				root = null;
			}
		}
		return root;
	}
}
