/**
 * 
 */
package org.leetcode.bfs.medium.solutions;

import java.util.ArrayList;
import java.util.List;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _1302_1 {
	public int deepestLeavesSum(TreeNode root) {
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
			if (list.isEmpty())
				return sum;
			else {
				level = new ArrayList<>();
				level.addAll(list);
				sum = 0;
			}
		}
		return sum;
	}
}
