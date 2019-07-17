/**
 * 
 */
package org.leetcode.dfs.medium.solutions;

import org.leetcode.bst.medium.solutions.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _1123_1 {
	class Pair {
		TreeNode node;
		int d;

		Pair(TreeNode node, int d) {
			this.node = node;
			this.d = d;
		}
	}

	public TreeNode lcaDeepestLeaves(TreeNode root) {
		return helper(root, 0).node;
	}

	private Pair helper(TreeNode root, int d) {
		if (root == null)
			return new Pair(null, d);
		Pair l = helper(root.left, d + 1);
		Pair r = helper(root.right, d + 1);
		if (l.d == r.d)
			return new Pair(root, l.d);
		return l.d > r.d ? l : r;
	}
}