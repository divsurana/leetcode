/**
 * 
 */
package org.eoplij.binarysearchtrees;

import java.util.ArrayList;
import java.util.List;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class ValidateBinarySearchTree_15_1 {
	public boolean isValidBST_v1(TreeNode root) {
		List<Integer> sorted = inorder(root, new ArrayList<>());
		for (int i = 1; i < sorted.size(); i++) {
			if (sorted.get(i) < sorted.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	private List<Integer> inorder(TreeNode root, List<Integer> order) {
		if (root == null) {
			return order;
		}
		inorder(root.left, order);
		order.add(root.val);
		inorder(root.right, order);
		return order;
	}

	// The question allows for duplicates
	public boolean isValidBST_v2(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, Integer low, Integer high) {
		if (root == null) {
			return true;
		}
		return low <= root.val && root.val <= high && isValidBST(root.left, low, root.val)
				&& isValidBST(root.right, root.val, high);
	}

	// If the tree does not allow duplicates
	public boolean isValidBST_v3(TreeNode root) {
		return isValidBST_(root, null, null);
	}

	private boolean isValidBST_(TreeNode root, Integer low, Integer high) {
		if (root == null) {
			return true;
		}
		return (low == null || low < root.val) && (high == null || root.val < high)
				&& isValidBST_(root.left, low, root.val) && isValidBST_(root.right, root.val, high);
	}
}
