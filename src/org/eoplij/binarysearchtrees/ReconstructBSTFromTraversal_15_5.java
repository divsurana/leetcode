/**
 * 
 */
package org.eoplij.binarysearchtrees;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class ReconstructBSTFromTraversal_15_5 {

	public TreeNode bstFromPreorder_v1(int[] preorder) {
		return reconstructBST(preorder, 0, preorder.length);
	}

	// Worst O(n^2), Best O(n), Avg O(nlogn)
	public TreeNode reconstructBST(int[] preorder, int from, int to) {
		if (from >= to) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[from]);
		int l = from + 1;
		// This leads to worst O(n^2) when tree is left skewed
		while (l < to && preorder[l] < root.val) {
			l++;
		}
		root.left = reconstructBST(preorder, from + 1, l);
		root.right = reconstructBST(preorder, l, to);
		return root;
	}

	private static int rootIdx;

	public TreeNode bstFromPreorder_v2(int[] preorder) {
		rootIdx = 0;
		return reconstructBSTFromPreorder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// eliminate the repetitive check for lower elements by introducing global
	// variable to track root idx and using lower and upper bounds for subtrees
	public TreeNode reconstructBSTFromPreorder(int[] preorder, int low, int high) {
		if (rootIdx == preorder.length || preorder[rootIdx] < low || preorder[rootIdx] > high) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[rootIdx++]);
		root.left = reconstructBSTFromPreorder(preorder, low, root.val);
		root.right = reconstructBSTFromPreorder(preorder, root.val, high);
		return root;
	}

	public TreeNode bstFromPostorder_v1(int[] postorder) {
		rootIdx = postorder.length - 1;
		return reconstructBSTFromPostorder(postorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private TreeNode reconstructBSTFromPostorder(int[] postorder, int low, int high) {
		if (rootIdx < 0 || postorder[rootIdx] < low || postorder[rootIdx] > high) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[rootIdx--]);
		root.right = reconstructBSTFromPostorder(postorder, root.val, high);
		root.left = reconstructBSTFromPostorder(postorder, low, root.val);
		return root;
	}

	public TreeNode bstFromPostorder_v2(int[] postorder) {
		return reconstructBSTPostOrder(postorder, -1, postorder.length - 1);
	}

	// Worst O(n^2), Best O(n), Avg O(nlogn)
	public TreeNode reconstructBSTPostOrder(int[] postorder, int from, int to) {
		if (from >= to) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[to]);
		int l = to - 1;
		// This leads to worst O(n^2) when tree is right skewed
		while (l > from && postorder[l] > root.val) {
			l--;
		}
		root.right = reconstructBSTPostOrder(postorder, l, to - 1);
		root.left = reconstructBSTPostOrder(postorder, from, l);
		return root;
	}

}
