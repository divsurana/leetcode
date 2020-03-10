/**
 * 
 */
package org.leetcode.greedy.medium.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author divyesh_surana
 *
 */
public class _763_1 {
	public List<Integer> partitionLabels(String S) {
		if (S == null || S.length() == 0)
			return null;

		List<Integer> partitions = new ArrayList<>();
		int[] max = new int[26];

		for (int i = 0; i < S.length(); i++) {
			max[S.charAt(i) - 'a'] = i;
		}

		int start = 0, last = 0;
		for (int i = 0; i < S.length(); i++) {
			last = Math.max(last, max[S.charAt(i) - 'a']);
			if (last == i) {
				partitions.add(last - start + 1);
				start = last + 1;
			}
		}

		return partitions;
	}
}
