/**
 * 
 */
package org.leetcode.bfs.medium.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class DeepestLeavesSum {
	public int deepestLeavesSum_v1(TreeNode root) {
		// The approach uses a modified version of bfs.
		int sum = 0;
		List<TreeNode> level = new ArrayList<>();
		level.add(root);

		while (!level.isEmpty()) {
			List<TreeNode> list = new ArrayList<>();
			for (TreeNode node : level) {
				sum += node.val;
				if (node.left != null) {
					list.add(node.left);
				}
				if (node.right != null) {
					list.add(node.right);
				}
			}
			if (list.isEmpty()) {
				return sum;
			} else {
				level = new ArrayList<>();
				level.addAll(list);
				sum = 0;
			}
		}
		return sum;
	}

	// This is a modified bfs approach.
	public int deepestLeavesSum_v2(TreeNode root) {

		int sum = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			if (!queue.isEmpty()) {
				sum = 0;
			}
		}

		return sum;
	}

	// Used solution from BinaryTreeLevelOrderTraversal and tweaked it for this
	// problem
	public int deepestLeavesSum_v3(TreeNode root) {
		int sum = 0;

		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			sum = 0;
			for (int size = queue.size(); size > 0; size--) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}

		return sum;
	}

}
