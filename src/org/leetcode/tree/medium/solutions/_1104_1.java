/**
 * 
 */
package org.leetcode.tree.medium.solutions;

import java.util.LinkedList;
import java.util.List;

/**
 * @author divyesh_surana
 *
 */
public class _1104_1 {
	public List<Integer> pathInZigZagTree(int label) {
		LinkedList<Integer> list = new LinkedList<>();
		list.push(label);

		for (int level = (int) (Math.log(label) / Math.log(2)); label > 1; --level) {

			// parent = highest value in the level + lowest value in the level - label / 2
			// parent = ((2^(d+1) - 1) + 2^d - label) / 2
			label = (int) ((Math.pow(2, level + 1) - 1) + Math.pow(2, level) - label) / 2;
			list.push(label);
		}

		return list;
	}
}
