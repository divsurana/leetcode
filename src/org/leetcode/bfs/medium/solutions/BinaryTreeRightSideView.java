/**
 * 
 */
package org.leetcode.bfs.medium.solutions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class BinaryTreeRightSideView {
	// These 2 are the bfs approaches. The dfs approaches are in the dfs
	// package.
	public List<Integer> rightSideView_v3(TreeNode root) {
		List<Integer> view = new LinkedList<>();
		Deque<TreeNode> queue = new LinkedList<>();

		if (root != null) {
			queue.offer(root);
		}

		while (!queue.isEmpty()) {
			view.add(queue.getLast().val);
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
		}
		return view;
	}

	public List<Integer> rightSideView_v4(TreeNode root) {
		List<Integer> view = new LinkedList<>();
		Deque<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			view.add(queue.getLast().val);
			for (int size = queue.size(); size > 0; size--) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return view;
	}
}
