/**
 * 
 */
package org.leetcode.bfs.medium.solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class FindLargestValueInEachTreeRow {
	public List<Integer> largestValues_v1(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> largestValues = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}

		while (!queue.isEmpty()) {
			int size = queue.size();
			int largestValue = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				largestValue = Math.max(largestValue, curr.val);
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
			largestValues.add(largestValue);
		}

		return largestValues;
	}

	public List<Integer> largestValues_v2(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			int max = Integer.MIN_VALUE;
			for (int size = queue.size(); size > 0; size--) {
				TreeNode node = queue.poll();
				max = Math.max(max, node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(max);
		}
		return result;
	}
}
