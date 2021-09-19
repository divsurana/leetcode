/**
 * 
 */
package org.eoplij.binarysearchtrees;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class FindNextGreatest_15_2 {

	// Search element first and then look for the greatest in the right subtree
	public TreeNode searchNextGreatest_v1(TreeNode root, int val) {
		return searchLowest(searchBST_v1(root, val).right);
	}

	private TreeNode searchLowest(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode lowest = searchLowest(root.left);
		return lowest == null ? root : lowest;
	}

	// recursive
	public TreeNode searchBST_v1(TreeNode root, int val) {
		return root == null || val == root.val ? root : searchBST_v1(val < root.val ? root.left : root.right, val);
	}

	// iterative
	public TreeNode searchBST_v2(TreeNode root, int val) {
		while (root != null && root.val != val) {
			root = root.val > val ? root.left : root.right;
		}
		return root;
	}

	// So much better and cleaner. Keep a track of next highest element until
	// the deepest element is reached.
	public TreeNode searchNextGreatest_v2(TreeNode root, int val) {
		TreeNode node = root, greatest = null;
		while (node != null) {
			if (node.val > val) {
				greatest = node;
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return greatest;
	}

	// Variant - return node with key that appears first in inorder traversal
	public TreeNode searchBSTInOrder(TreeNode root, int val) {
		return root == null ? null
				: val <= root.val ? searchBSTInOrder(root.left, val)
						: val == root.val ? root : searchBSTInOrder(root.right, val);
	}
}
