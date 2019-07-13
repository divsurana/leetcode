/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import java.util.Arrays;

import org.leetcode.bst.medium.solutions.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _654_1 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode root = null;
		if (nums.length > 0) {
			int maxIndex = 0;
			for (int i = 1; i < nums.length; i++) {
				maxIndex = nums[maxIndex] < nums[i] ? i : maxIndex;
			}
			root = new TreeNode(nums[maxIndex]);
			root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
			root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));
		}
		return root;
	}
}