/**
 * 
 */
package org.leetcode.dfs.medium.solutions;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _979_1 {
	public int distributeCoins(TreeNode root) {
		int res = 0;
		if (root.left != null) {
			res += distributeCoins(root.left);
			root.val += root.left.val - 1;
			res += Math.abs(root.left.val - 1);
		}
		if (root.right != null) {
			res += distributeCoins(root.right);
			root.val += root.right.val - 1;
			res += Math.abs(root.right.val - 1);
		}
		return res;
	}
}
