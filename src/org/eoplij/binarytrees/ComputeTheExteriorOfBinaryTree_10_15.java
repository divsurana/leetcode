/**
 * 
 */
package org.eoplij.binarytrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class ComputeTheExteriorOfBinaryTree_10_15 {
	public static List<TreeNode> computeExterior(TreeNode root) {
		List<TreeNode> left = new ArrayList<>();
		LinkedList<TreeNode> right = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			// Left side
			TreeNode node = queue.poll();
			System.out.println("Left: " + node.val);
			left.add(node);
			int n = queue.size();
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
			// Middle
			while (n-- > 1) {
				node = queue.poll();
				System.out.println("Middle: " + node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			// Right side
			if (n == 0) {
				node = queue.poll();
				System.out.println("Right: " + node.val);
				right.push(node);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}

		List<TreeNode> bottom = leavesList(root);
		bottom = bottom.subList(1, bottom.size() - 1);

		left.addAll(bottom);
		left.addAll(right);

		return left;
	}

	private static List<TreeNode> leavesList(TreeNode root) {
		List<TreeNode> list = new LinkedList<>();
		traverse(root, list);
		return list;
	}

	private static void traverse(TreeNode root, List<TreeNode> list) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				list.add(root);
			} else {
				traverse(root.left, list);
				traverse(root.right, list);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = ConstructBinaryTreeFromPreorderWithMarkers_10_13.generateTree();
		String output = Arrays.toString(computeExterior(root).toArray());
		System.out.println(output);
		if (output.equals("[1, 2, 3, 5, 9, 8, 7, 6]")) {
			System.out.println("Test Successful");
		} else {
			System.out.println("Test Unsuccessful");
		}
	}
}
