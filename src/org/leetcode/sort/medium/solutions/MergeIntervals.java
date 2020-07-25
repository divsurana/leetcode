/**
 * 
 */
package org.leetcode.sort.medium.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		if (intervals.length == 0) {
			return new int[0][];
		}
		List<int[]> merge = new ArrayList<>();
		int n = intervals.length;
		int[] lowArr = new int[n];
		int[] highArr = new int[n];

		for (int i = 0; i < n; i++) {
			lowArr[i] = intervals[i][0];
			highArr[i] = intervals[i][1];
		}

		Arrays.sort(lowArr);
		Arrays.sort(highArr);

		for (int start = 0, end = 0; end < n; end++) {
			if (end == n - 1 || lowArr[end + 1] > highArr[end]) {
				merge.add(new int[] { lowArr[start], highArr[end] });
				start = end + 1;
			}
		}

		return merge.toArray(new int[merge.size()][]);
	}
}
