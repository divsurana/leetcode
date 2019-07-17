/**
 * 
 */
package org.leetcode.tree.easy.solutions;

import org.leetcode.bst.medium.solutions.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _235_2 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (true) {
			if (root.val > p.val && root.val > q.val)
				root = root.left;
			else if (root.val < p.val && root.val < q.val)
				root = root.right;
			else
				break;
		}
		return root;
	}
}
