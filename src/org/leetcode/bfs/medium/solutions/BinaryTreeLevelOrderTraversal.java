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
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder_v1(TreeNode root) {
		List<List<Integer>> traversal = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		if (root != null) {
			queue.offer(root);
		}

		while (!queue.isEmpty()) {
			List<Integer> list = new LinkedList<>();
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				list.add(curr.val);
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
			traversal.add(list);
		}

		return traversal;
	}

	public List<List<Integer>> levelOrder_v2(TreeNode root) {
		List<List<Integer>> levels = new ArrayList<>();
		if (root == null) {
			return levels;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> nodes = new ArrayList<>();
			for (int size = queue.size(); size > 0; size--) {
				TreeNode node = queue.poll();
				nodes.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			levels.add(nodes);
		}

		return levels;
	}
}
