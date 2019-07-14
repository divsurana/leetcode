/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import org.leetcode.bst.medium.solutions.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _701_2 {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		TreeNode curr = root;
		while (true) {
			if (curr.val > val) {
				if (curr.left == null) {
					curr.left = new TreeNode(val);
					break;
				} else {
					curr = curr.left;
				}
			} else {
				if (curr.right == null) {
					curr.right = new TreeNode(val);
					break;
				} else {
					curr = curr.right;
				}
			}
		}

		return root;
	}
}