/**
 * 
 */
package org.leetcode.tree.easy.solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.leetcode.common.Node;

/**
 * @author divyesh_surana
 *
 */
public class _429_1 {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> traversal = new LinkedList<>();
		Queue<Node> queue = new LinkedList<>();

		if (root != null)
			queue.offer(root);

		while (!queue.isEmpty()) {
			List<Integer> list = new LinkedList<>();
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Node curr = queue.poll();
				list.add(curr.val);
				for (Node child : curr.children) {
					queue.offer(child);
				}
			}
			traversal.add(list);
		}

		return traversal;
	}
}
