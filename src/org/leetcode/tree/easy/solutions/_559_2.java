/**
 * 
 */
package org.leetcode.tree.easy.solutions;

import java.util.LinkedList;
import java.util.Queue;

import org.leetcode.common.Node;

/**
 * @author divyesh_surana
 *
 */
public class _559_2 {
	public int maxDepth(Node root) {
		int maxDepth = 0;
		Queue<Node> queue = new LinkedList<>();
		if (root != null)
			queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node curr = queue.poll();
				for (Node child : curr.children) {
					queue.offer(child);
				}
			}
			maxDepth++;
		}
		return maxDepth;
	}
}
