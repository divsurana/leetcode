/**
 * 
 */
package org.leetcode.tree.easy.solutions;

import org.leetcode.common.Node;

/**
 * @author divyesh_surana
 *
 */
public class _559_1 {
	public int maxDepth(Node root) {
		return root == null ? 0 : helper(root, 0);
	}

	int helper(Node node, int depth) {
		int maxDepth = depth + 1;
		for (Node child : node.children) {
			maxDepth = Math.max(maxDepth, helper(child, depth + 1));
		}
		return maxDepth;
	}
}
