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
public class _515_1 {
	public List<Integer> largestValues(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> largestValues = new LinkedList<>();
		if (root != null)
			queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			int largestValue = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				largestValue = Math.max(largestValue, curr.val);
				if (curr.left != null)
					queue.offer(curr.left);
				if (curr.right != null)
					queue.offer(curr.right);
			}
			largestValues.add(largestValue);
		}

		return largestValues;
	}
}
