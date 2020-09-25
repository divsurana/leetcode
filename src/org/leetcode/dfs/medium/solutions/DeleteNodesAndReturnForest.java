/**
 * 
 */
package org.leetcode.dfs.medium.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class DeleteNodesAndReturnForest {

	// bfs approach (iterative)
	public List<TreeNode> delNodes_v1(TreeNode root, int[] to_delete) {
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
			if (array[index] == value) {
				return true;
			} else if (array[index] > value) {
				r = index;
				index = (l + r) / 2;
			} else if (array[index] < value) {
				l = index;
				index = (l + r) / 2;
			}
		}

		return false;
	}

	// dfs approach (recursive)
	public List<TreeNode> delNodes_v2(TreeNode root, int[] to_delete) {
		Set<Integer> delete = new HashSet<>();
		for (int node : to_delete) {
			delete.add(node);
		}
		List<TreeNode> trees = new ArrayList<>();
		root = delete(trees, root, delete);
		if (root != null) {
			trees.add(root);
		}
		return trees;
	}

	private TreeNode delete(List<TreeNode> trees, TreeNode node, Set<Integer> delete) {
		if (node != null) {
			node.left = delete(trees, node.left, delete);
			node.right = delete(trees, node.right, delete);
			if (delete.contains(node.val)) {
				if (node.left != null) {
					trees.add(node.left);
				}
				if (node.right != null) {
					trees.add(node.right);
				}
				node = null;
			}
		}
		return node;
	}
}
