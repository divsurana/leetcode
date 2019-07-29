/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class _222_1 {
	int count = 0;

	public int countNodes(TreeNode root) {
		if (root != null) {
			count++;
			count = countNodes(root.left);
			count = countNodes(root.right);
		}
		return count;
	}
}
