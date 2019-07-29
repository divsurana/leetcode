/**
 * 
 */
package org.leetcode.bfs.medium.solutions;

import java.util.LinkedList;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _513_1 {
	public int findBottomLeftValue(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		int leftmost = root.val;
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			leftmost = queue.peek().val;
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				if (curr.left != null)
					queue.offer(curr.left);
				if (curr.right != null)
					queue.offer(curr.right);
			}
		}

		return leftmost;
	}
}
