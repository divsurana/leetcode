/**
 * 
 */
package org.leetcode.challenge.july.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _2_BinaryTreeLevelOrderTraversal2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<List<Integer>> stack = new Stack<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			for (int size = queue.size(); size > 0; size--) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			stack.push(level);
		}

		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}

		return result;
	}
}
