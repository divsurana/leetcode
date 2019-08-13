/**
 * 
 */
package org.leetcode.dfs.medium.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _1110_1 {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		Arrays.sort(to_delete);
		List<TreeNode> remainingNodes = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (!contains(to_delete, root.val)) {
			remainingNodes.add(root);
		}
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();

			if (contains(to_delete, node.val)) {
				if (node.left != null) {
					if (!contains(to_delete, node.left.val)) {
						remainingNodes.add(node.left);
					}
					queue.offer(node.left);
				}
				if (node.right != null) {
					if (!contains(to_delete, node.right.val)) {
						remainingNodes.add(node.right);
					}
					queue.offer(node.right);
				}
				node = null;
			} else {
				if (node.left != null) {
					queue.offer(node.left);
					if (contains(to_delete, node.left.val)) {
						node.left = null;
					}
				}
				if (node.right != null) {
					queue.offer(node.right);
					if (contains(to_delete, node.right.val)) {
						node.right = null;
					}
				}
			}
		}

		return remainingNodes;

	}

	private boolean contains(int[] array, int value) {
		int l = -1, r = array.length;
		int index = (l + r) / 2;

		while (l + 1 < r) {
			if (array[index] == value)
				return true;
			else if (array[index] > value) {
				r = index;
				index = (l + r) / 2;
			} else if (array[index] < value) {
				l = index;
				index = (l + r) / 2;
			}
		}

		return false;
	}
}
