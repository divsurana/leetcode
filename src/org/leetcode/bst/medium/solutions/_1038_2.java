/**
 * 
 */
package org.leetcode.bst.medium.solutions;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class _1038_2 {
	int val = 0;

	public TreeNode bstToGst(TreeNode root) {
		if (root == null) {
			return root;
		}
		root.right = bstToGst(root.right);
		root.val += val;
		val = root.val;
		root.left = bstToGst(root.left);
		return root;
	}
}
