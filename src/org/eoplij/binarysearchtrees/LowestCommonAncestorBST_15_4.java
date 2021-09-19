/**
 * 
 */
package org.eoplij.binarysearchtrees;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class LowestCommonAncestorBST_15_4 {
	// recursive
	public TreeNode lowestCommonAncestor_v1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root.val == p.val || root.val == q.val) {
			return root;
		}
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor_v1(root.left, p, q);
		}
		if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor_v1(root.right, p, q);
		}
		return root;
	}

	// iterative
	public TreeNode lowestCommonAncestor_v2(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null && root.val != p.val && root.val != q.val) {
			if (root.val > p.val && root.val > q.val) {
				root = root.left;
			} else if (root.val < p.val && root.val < q.val) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
	}

	// iterative - from book when p < q
	public TreeNode lowestCommonAncestor_v3(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val > q.val) {
			return lowestCommonAncestor_v3(root, q, p);
		}
		while (root.val < p.val || root.val > q.val) {
			while (root.val < p.val) {
				root = root.right;
			}
			while (root.val > q.val) {
				root = root.left;
			}
		}
		return root;
	}
}
