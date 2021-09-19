/**
 * 
 */
package org.eoplij.binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class RootToLeafPathSum_10_6 {
	// Recursive
	public boolean hasPathSum_v1(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
		// Leaf
		if (root.left == null && root.right == null) {
			return root.val == targetSum;
		}
		// Non-leaf
		return hasPathSum_v1(root.left, targetSum - root.val) || hasPathSum_v1(root.right, targetSum - root.val);
	}

	class Node {
		TreeNode tnNode;
		int sum;

		Node(TreeNode node, int sum) {
			this.tnNode = node;
			this.sum = sum;
		}
	}

	// Iterative
	public boolean hasPathSum_v2(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(new Node(root, root.val));
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			if (node.tnNode.left == null && node.tnNode.right == null && node.sum == sum) {
				return true;
			}
			if (node.tnNode.right != null) {
				stack.push(new Node(node.tnNode.right, node.sum + node.tnNode.right.val));
			}
			if (node.tnNode.left != null) {
				stack.push(new Node(node.tnNode.left, node.sum + node.tnNode.left.val));
			}
		}
		return false;
	}

	// Variant - return the paths
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> paths = new ArrayList<>();
		LinkedList<Integer> path = new LinkedList<>();
		helper(root, path, paths, targetSum);
		return paths;
	}

	public void helper(TreeNode root, LinkedList<Integer> path, List<List<Integer>> paths, int targetSum) {
		if (root == null) {
			return;
		}
		path.add(root.val);
		if (root.left == null && root.right == null && root.val == targetSum) {
			paths.add(new ArrayList<>(path));
		}
		helper(root.left, path, paths, targetSum - root.val);
		helper(root.right, path, paths, targetSum - root.val);
		path.removeLast();
	}
}
