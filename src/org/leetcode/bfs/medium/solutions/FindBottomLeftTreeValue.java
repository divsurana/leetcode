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
public class FindBottomLeftTreeValue {
	public int findBottomLeftValue_v1(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		int leftmost = root.val;
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			leftmost = queue.peek().val;
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

		return leftmost;
	}

	public int findBottomLeftValue_v2(TreeNode root) {
		int value = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			value = queue.peek().val;
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
		return value;
	}
}
