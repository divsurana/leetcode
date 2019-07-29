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
public class _102_1 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> traversal = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		if (root != null)
			queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> list = new LinkedList<>();
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				list.add(curr.val);
				if (curr.left != null)
					queue.offer(curr.left);
				if (curr.right != null)
					queue.offer(curr.right);
			}
			traversal.add(list);
		}

		return traversal;
	}
}
