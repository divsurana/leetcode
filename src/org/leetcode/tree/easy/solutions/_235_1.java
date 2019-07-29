/**
 * 
 */
package org.leetcode.tree.easy.solutions;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _235_1 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val > p.val && root.val > q.val)
			return lowestCommonAncestor(root.left, p, q);
		if (root.val < p.val && root.val < q.val)
			return lowestCommonAncestor(root.right, p, q);
		return root;
	}
}
