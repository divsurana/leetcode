/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import java.util.HashSet;
import java.util.Set;

import org.leetcode.common.TreeNode;

/**
 * @author divyesh_surana
 *
 */
public class _236_1 {
	class Pair {
		TreeNode node;
		Set<TreeNode> descendants;

		Pair(TreeNode node) {
			this.node = node;
			this.descendants = new HashSet<>();
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return helper(root, p, q).node;
	}

	public Pair helper(TreeNode root, TreeNode p, TreeNode q) {
		Pair newPair = new Pair(root);
		if (root.val == p.val) {
			newPair.descendants.add(p);
		} else if (root.val == q.val) {
			newPair.descendants.add(q);
		}
		if (root.left != null) {
			Pair firstAncestor = helper(root.left, p, q);
			if (firstAncestor.descendants.contains(p) && firstAncestor.descendants.contains(q))
				return firstAncestor;
			newPair.descendants.addAll(firstAncestor.descendants);
		}
		if (root.right != null) {
			Pair secondAncestor = helper(root.right, p, q);
			if (secondAncestor.descendants.contains(p) && secondAncestor.descendants.contains(q))
				return secondAncestor;
			newPair.descendants.addAll(secondAncestor.descendants);
		}

		return newPair;
	}
}