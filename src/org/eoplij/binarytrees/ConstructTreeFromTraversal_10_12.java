/**
 * 
 */
package org.eoplij.binarytrees;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class ConstructTreeFromTraversal_10_12 {
	public TreeNode buildTree_v1(int[] preorder, int[] inorder) {
		return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
	}

	private TreeNode build(int[] preorder, int sp, int ep, int[] inorder, int si, int ei) {
		if (sp == ep || si == ei) {
			return null;
		}
		int n = ep - sp;
		TreeNode root = new TreeNode(preorder[sp]);
		// Go further to populate children only if the traversal has more than 1
		// element
		if (n > 1) {
			// find the number of nodes in the left subtree
			int k = 0;
			while (inorder[si + k] != preorder[sp]) {
				k++;
			}

			// left subtree for preorder [sp + 1, sp + k] and inorder [si, si +
			// k - 1]
			root.left = build(preorder, sp + 1, sp + k + 1, inorder, si, si + k);
			// right subtree for preorder [sp + k + 1, ep - 1] and inorder [si +
			// k + 1. ei - 1]
			root.right = build(preorder, sp + k + 1, ep, inorder, si + k + 1, ei);
		}
		return root;
	}

	// Using a map to store inorder element indices to avoid iterating through
	// the array repetitively
	public TreeNode buildTree_v2(int[] preorder, int[] inorder) {
		Map<Integer, Integer> nodeToInorderIdx = new HashMap<>();
		for (int i = 0; i < inorder.length; ++i) {
			nodeToInorderIdx.put(inorder[i], i);
		}
		return build(preorder, 0, preorder.length, inorder, 0, inorder.length, nodeToInorderIdx);
	}

	private TreeNode build(int[] preorder, int sp, int ep, int[] inorder, int si, int ei,
			Map<Integer, Integer> nodeToInorderIdx) {
		if (sp == ep) {
			return null;
		}
		int n = ep - sp;
		TreeNode root = new TreeNode(preorder[sp]);
		// Go further to populate children only if the traversal has more than 1
		// element
		if (n > 1) {
			// find the number of nodes in the left subtree
			int k = nodeToInorderIdx.get(preorder[sp]) - si;

			// left subtree for preorder [sp + 1, sp + k] and inorder [si, si +
			// k - 1]
			root.left = build(preorder, sp + 1, sp + k + 1, inorder, si, si + k, nodeToInorderIdx);
			// right subtree for preorder [sp + k + 1, ep - 1] and inorder [si +
			// k + 1. ei - 1]
			root.right = build(preorder, sp + k + 1, ep, inorder, si + k + 1, ei, nodeToInorderIdx);
		}
		return root;
	}

	// Variant - Build a tree using inorder and postorder
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> nodeToInorderIdx = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			nodeToInorderIdx.put(inorder[i], i);
		}
		return helper(inorder, 0, inorder.length, postorder, 0, postorder.length, nodeToInorderIdx);
	}

	private TreeNode helper(int[] inorder, int si, int ei, int[] postorder, int sp, int ep,
			Map<Integer, Integer> nodeToInorderIdx) {
		if (si == ei) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[ep - 1]);
		int k = nodeToInorderIdx.get(root.val) - si;

		root.left = helper(inorder, si, si + k, postorder, sp, sp + k, nodeToInorderIdx);
		root.right = helper(inorder, si + k + 1, ei, postorder, sp + k, ep - 1, nodeToInorderIdx);

		return root;
	}

	// Variant to build a max tree
	public TreeNode constructMaximumBinaryTree_v1(int[] nums) {
		return build(nums, 0, nums.length);
	}

	private TreeNode build(int[] nums, int start, int end) {
		if (start == end) {
			return null;
		}
		int m = start;

		for (int i = start; i < end; i++) {
			m = nums[i] > nums[m] ? i : m;
		}

		TreeNode root = new TreeNode(nums[m]);
		root.left = build(nums, start, m);
		root.right = build(nums, m + 1, end);

		return root;
	}

	// Worst case O(n) time complexity
	public TreeNode constructMaximumBinaryTree_v2(int[] nums) {
		Deque<TreeNode> stack = new LinkedList<>();
		for (int num : nums) {
			TreeNode curr = new TreeNode(num);
			while (!stack.isEmpty() && stack.peek().val < num) {
				curr.left = stack.pop();
			}
			if (!stack.isEmpty()) {
				stack.peek().right = curr;
			}
			stack.push(curr);
		}

		return stack.pollLast();
	}
}
