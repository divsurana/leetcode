/**
 * 
 */
package org.eoplij.queues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class LevelOrderTraversal_9_7 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> levels = new ArrayList<>();
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				List<Integer> level = new ArrayList<>();
				while (size-- > 0) {
					TreeNode node = queue.poll();
					level.add(node.val);
					if (node.left != null) {
						queue.offer(node.left);
					}
					if (node.right != null) {
						queue.offer(node.right);
					}
				}
				levels.add(level);
			}
		}
		return levels;
	}

	// Variant - Zigzag Level Order
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root != null) {
			boolean isRight = true;
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			while (!stack.isEmpty()) {
				Stack<TreeNode> levelStack = new Stack<>();
				List<Integer> level = new ArrayList<>();
				while (!stack.isEmpty()) {
					TreeNode node = stack.pop();
					level.add(node.val);
					if (isRight) {
						if (node.left != null) {
							levelStack.push(node.left);
						}
						if (node.right != null) {
							levelStack.push(node.right);
						}
					} else {
						if (node.right != null) {
							levelStack.push(node.right);
						}
						if (node.left != null) {
							levelStack.push(node.left);
						}
					}

				}
				result.add(level);
				stack = levelStack;
				isRight = !isRight;
			}
		}

		return result;
	}

	// Variant - Level Order from Bottom
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		Deque<List<Integer>> levels = new LinkedList<>();
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				List<Integer> level = new ArrayList<>();
				while (size-- > 0) {
					TreeNode node = queue.poll();
					level.add(node.val);
					if (node.left != null) {
						queue.offer(node.left);
					}
					if (node.right != null) {
						queue.offer(node.right);
					}
				}
				levels.push(level);
			}
		}
		return (List) levels;
	}

	// Variant - Give avg of each level
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> avg = new ArrayList<>();
		if (root != null) {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				double sum = 0;
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					sum += node.val;
					if (node.left != null) {
						queue.offer(node.left);
					}
					if (node.right != null) {
						queue.offer(node.right);
					}
				}
				avg.add(sum / size);
			}
		}
		return avg;
	}
}
