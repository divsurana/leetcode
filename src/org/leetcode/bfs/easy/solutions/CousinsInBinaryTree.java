/**
 * 
 */
package org.leetcode.bfs.easy.solutions;

import java.util.LinkedList;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class CousinsInBinaryTree {
	public boolean isCousins(TreeNode root, int x, int y) {
		if (root.val == x || root.val == y) {
			return false;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeNode p = null;
			while (size-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					if (node.left.val == x || node.left.val == y) {
						if (p == null) {
							p = node;
						} else {
							return checkSecondParent(p, node);
						}
					} else {
						queue.offer(node.left);
					}
				}
				if (node.right != null) {
					if (node.right.val == x || node.right.val == y) {
						if (p == null) {
							p = node;
						} else {
							return checkSecondParent(p, node);
						}
					} else {
						queue.offer(node.right);
					}
				}
			}
			if (p != null) {
				return false;
			}
		}

		return false;
	}

	/**
	 * @param p
	 * @param node
	 * @return
	 */
	private boolean checkSecondParent(TreeNode p, TreeNode node) {
		if (p != node) {
			return true;
		}
		return false;
	}
}
