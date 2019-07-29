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
public class _199_3 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> view = new LinkedList<>();
		Deque<TreeNode> queue = new LinkedList<>();

		if (root != null)
			queue.offer(root);

		while (!queue.isEmpty()) {
			view.add(queue.getLast().val);
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				if (curr.left != null)
					queue.offer(curr.left);
				if (curr.right != null)
					queue.offer(curr.right);
			}
		}
		return view;
	}
}
