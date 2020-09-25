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
public class PartitionLabels {
	public List<Integer> partitionLabels_v1(String S) {
		if (S == null || S.length() == 0) {
			return null;
		}

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

	public List<Integer> partitionLabels_v2(String S) {
		List<Integer> partitions = new ArrayList<>();
		int[] last = new int[26];

		for (int i = 0; i < S.length(); i++) {
			last[S.charAt(i) - 'a'] = i;
		}

		for (int start = 0, end = 0, counter = 0; start < S.length(); start++) {
			end = Math.max(end, last[S.charAt(start) - 'a']);
			if (start == end) {
				partitions.add(start - counter + 1);
				counter = start + 1;
			}
		}

		return partitions;
	}
}
