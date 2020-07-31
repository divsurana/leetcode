/**
 * 
 */
package org.leetcode.twopointers.medium.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class FruitIntoBaskets {
	public int totalFruit_v1(int[] tree) {
		if (tree.length == 0) {
			return 0;
		}
		int max = 1;
		int count = 1;
		int l = 0;
		int r = 1;
		Set<Integer> set = new HashSet<>();
		int capacity = 2;

		set.add(tree[l]);

		while (l < tree.length && r < tree.length) {
			if (set.contains(tree[r])) {
			} else if (set.size() < capacity) {
				l = r;
				set.add(tree[r]);
			} else {
				set.clear();
				set.add(tree[l]);
				count = 1;
				r = l + 1;
				continue;
			}
			r++;
			count++;
			max = Math.max(max, count);
		}
		return max;
	}

	public int totalFruit_v2(int[] tree) {
		int max = 0;
		int currMax = 0;
		int lastCounter = 0;
		int secondLastCounter = -1;

		for (int i = 0; i < tree.length; i++) {
			int fruit = tree[i];

			if (fruit == tree[lastCounter]) {
			} else if (secondLastCounter < 0 || fruit == tree[secondLastCounter]) {
				secondLastCounter = lastCounter;
			} else {
				currMax = lastCounter - secondLastCounter;
				secondLastCounter = lastCounter;
			}
			lastCounter = i;
			currMax++;
			max = Math.max(max, currMax);
		}

		return max;
	}
}
