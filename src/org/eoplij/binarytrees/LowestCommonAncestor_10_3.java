/**
 * 
 */
package org.eoplij.binarytrees;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.leetcode.common.TreeNode;

/**
 * @author divyeshsurana
 *
 */
public class LowestCommonAncestor_10_3 {
	// Recursive
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == root || q == root) {
			return root;
		}

		TreeNode leftCommon = lowestCommonAncestor(root.left, p, q);
		TreeNode rightCommon = lowestCommonAncestor(root.right, p, q);
		return leftCommon != null && rightCommon != null ? root : leftCommon == null ? rightCommon : leftCommon;
	}

	// Iterative
	public TreeNode lowestCommonAncestor_v2(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> parent = new HashMap<>();
		Deque<TreeNode> stack = new ArrayDeque<>();
		parent.put(root, null);
		stack.push(root);

		while (!parent.containsKey(p) || !parent.containsKey(q)) {
			TreeNode node = stack.pop();
			if (node.left != null) {
				parent.put(node.left, node);
				stack.push(node.left);
			}
			if (node.right != null) {
				parent.put(node.right, node);
				stack.push(node.right);
			}
		}
		Set<TreeNode> ancestors = new HashSet<>();
		while (p != null) {
			ancestors.add(p);
			p = parent.get(p);
		}
		while (!ancestors.contains(q)) {
			q = parent.get(q);
		}
		return q;
	}

	// Solution from the book. Not the best but worth looking into.
	private static class Status {
		public int numTargetNodes;
		public TreeNode ancestor;

		public Status(int numTargetNodes, TreeNode node) {
			this.numTargetNodes = numTargetNodes;
			this.ancestor = node;
		}
	}

	public static TreeNode LCA(TreeNode tree, TreeNode node0, TreeNode node1) {
		return LCAHelper(tree, node0, node1).ancestor;
	}

	// Returns an object consisting of an int and a node. The int field is
	// ®, 1, or 2 depending on how many of {node® , nodel} are present in
	// the tree. If both are present in the tree, when ancestor is
	// assigned to a non-null value, it is the LCA.
	private static Status LCAHelper(TreeNode tree, TreeNode node0, TreeNode node1) {
		if (tree == null) {
			return new Status(0, null);
		}
		Status leftResult = LCAHelper(tree.left, node0, node1);
		if (leftResult.numTargetNodes == 2) {
			// Found both nodes in the left subtree.
			return leftResult;
		}
		Status rightResult = LCAHelper(tree.right, node0, node1);
		if (rightResult.numTargetNodes == 2) {
			// Found both nodes in the right subtree.
			return rightResult;
		}
		int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes + (tree == node0 ? 1 : 0)
				+ (tree == node1 ? 1 : 0);
		return new Status(numTargetNodes, numTargetNodes == 2 ? tree : null);
	}
}
