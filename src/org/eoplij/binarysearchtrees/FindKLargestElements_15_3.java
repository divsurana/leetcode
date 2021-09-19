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
public class FindKLargestElements_15_3 {
	public List<TreeNode> findKLargestElements_v1(TreeNode root, int k) {
		List<TreeNode> kLargest = new ArrayList<>();
		findKLargestElements_v1(root, k, kLargest);
		return kLargest;
	}

	private int findKLargestElements_v1(TreeNode root, int k, List<TreeNode> kLargest) {
		if (k <= 0 || root == null) {
			return k;
		}
		k = findKLargestElements_v1(root.right, k, kLargest);
		if (k > 0) {
			kLargest.add(root);
			k--;
			k = findKLargestElements_v1(root.left, k, kLargest);
		}
		return k;
	}

	// Another way of doing it
	public List<TreeNode> findKLargestElements_v2(TreeNode root, int k) {
		return findKLargestElements_v2(root, k, new ArrayList<>());
	}

	private List<TreeNode> findKLargestElements_v2(TreeNode root, int k, List<TreeNode> kLargest) {
		if (kLargest.size() == k || root == null) {
			return kLargest;
		}
		findKLargestElements_v2(root.right, k, kLargest);
		if (kLargest.size() < k) {
			kLargest.add(root);
			findKLargestElements_v2(root.left, k, kLargest);
		}
		return kLargest;
	}
}
