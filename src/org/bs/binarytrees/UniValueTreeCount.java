/**
 * 
 */
package org.bs.binarytrees;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class UniValueTreeCount {
	int uniValues = 0;

	public int solve(TreeNode root) {
		isUniVal(root);
		return uniValues;
	}

	private boolean isUniVal(TreeNode node) {
		if (node == null) {
			return true;
		}
		boolean isUniVal = (node.left == null || isUniVal(node.left) && node.val == node.left.val)
				& (node.right == null || isUniVal(node.right) && node.val == node.right.val);
		if (isUniVal) {
			uniValues++;
		}
		return isUniVal;
	}
}
