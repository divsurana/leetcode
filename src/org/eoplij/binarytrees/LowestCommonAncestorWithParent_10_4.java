/**
 * 
 */
package org.eoplij.binarytrees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class LowestCommonAncestorWithParent_10_4 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode lowestCommonAncestor_v1(TreeNode p, TreeNode q) {
		Set<TreeNode> ancestors = new HashSet<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(p);
		queue.offer(q);
		TreeNode ancestor = null;

		while (ancestor == null && !queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (ancestors.contains(node)) {
				ancestor = node;
			} else {
				ancestors.add(node);
				if (node.parent != null) {
					queue.offer(node.parent);
				}
			}
		}

		return ancestor;
	}

	public TreeNode lowestCommonAncestor_v2(TreeNode p, TreeNode q) {
		int depthP = getDepth(p), depthQ = getDepth(q);

		// Makes p as the deeper node in order to simplify the code.
		if (depthQ > depthP) {
			swap(p, q);
		}

		// Ascends from the deeper node.
		int depthDiff = Math.abs(depthP - depthQ);
		while (depthDiff-- > 0) {
			p = p.parent;
		}

		// Now ascends both nodes until we reach the LCA.
		while (p != q) {
			p = p.parent;
			q = q.parent;
		}

		return p;
	}

	private int getDepth(TreeNode p) {
		TreeNode node = p;
		int depth = 0;
		while (node.parent != null) {
			node = node.parent;
			depth++;
		}
		return depth;
	}

	private void swap(TreeNode p, TreeNode q) {
		TreeNode temp = p;
		p = q;
		q = temp;
	}

}
