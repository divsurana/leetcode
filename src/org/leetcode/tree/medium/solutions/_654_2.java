/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import java.util.Deque;
import java.util.LinkedList;

import org.leetcode.bst.medium.solutions.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _654_2 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		Deque<TreeNode> stack = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			TreeNode curr = new TreeNode(nums[i]);
			while (!stack.isEmpty() && stack.peek().val < nums[i]) {
				curr.left = stack.pop();
			}
			if (!stack.isEmpty()) {
				stack.peek().right = curr;
			}
			stack.push(curr);
		}

		return stack.getLast();
	}
}