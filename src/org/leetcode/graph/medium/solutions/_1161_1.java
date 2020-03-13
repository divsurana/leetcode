/**
 * 
 */
package org.leetcode.graph.medium.solutions;

import java.util.LinkedList;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _1161_1 {
	public int maxLevelSum(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int max = Integer.MIN_VALUE;
		int maxLevel = 1;

		for (int level = 1; !queue.isEmpty(); ++level) {
			int sum = 0;
			for (int i = queue.size(); i > 0; --i) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}

			max = Math.max(max, sum);
			maxLevel = sum == max ? level : maxLevel;
		}

		return maxLevel;
	}

}
