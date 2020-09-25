/**
 * 
 */
package org.leetcode.bfs.medium.solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class MaxLevelSumofaBinaryTree {
	// iterative solution using queue
	public int maxLevelSum_v1(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int max = Integer.MIN_VALUE;
		int maxLevel = 1;

		for (int level = 1; !queue.isEmpty(); ++level) {
			int sum = 0;
			for (int i = queue.size(); i > 0; --i) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}

			max = Math.max(max, sum);
			maxLevel = sum == max ? level : maxLevel;
		}

		return maxLevel;
	}

	// iterative solution using queue (same as above)
	public int maxLevelSum_v2(TreeNode root) {
		int max = Integer.MIN_VALUE;
		int maxLevel = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		for (int level = 1; !queue.isEmpty(); level++) {
			int sum = 0;
			for (int i = queue.size(); i > 0; i--) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			if (max < sum) {
				max = sum;
				maxLevel = level;
			}
		}

		return maxLevel;
	}

	// recursive solution using map
	public int maxLevelSum_v3(TreeNode root) {
		Map<Integer, Integer> sums = new HashMap<>();
		helper(sums, root, 1);
		int max = Integer.MIN_VALUE, maxLevel = 0;
		for (Integer level : sums.keySet()) {
			int sum = sums.get(level);
			if (max < sum) {
				max = sum;
				maxLevel = level;
			}
		}
		return maxLevel;
	}

	private void helper(Map<Integer, Integer> sums, TreeNode node, int level) {
		if (node == null) {
			return;
		}
		int sum = sums.getOrDefault(level, 0);
		sum += node.val;
		sums.put(level, sum);
		helper(sums, node.left, level + 1);
		helper(sums, node.right, level + 1);
	}

	// recursive solution using array (using the fact that max levels is 10^4)
	public int maxLevelSum_v4(TreeNode root) {
		int[] sums = new int[(int) Math.pow(10, 4) + 1];
		helper(sums, root, 1);
		int maxLevel = 1;
		for (int level = 1; level < sums.length; level++) {
			if (sums[maxLevel] < sums[level]) {
				maxLevel = level;
			}
		}
		return maxLevel;
	}

	private void helper(int[] sums, TreeNode node, int level) {
		if (node == null) {
			return;
		}
		sums[level] += node.val;
		helper(sums, node.left, level + 1);
		helper(sums, node.right, level + 1);
	}

}
