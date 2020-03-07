/**
 * 
 */
package org.leetcode.dfs.medium.solutions;

import java.util.LinkedList;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _1315_2 {
	// This is a modified bfs approach.
	public int deepestLeavesSum(TreeNode root) {

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
}
