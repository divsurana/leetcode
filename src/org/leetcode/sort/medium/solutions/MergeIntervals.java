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
	public int[][] merge_v1(int[][] intervals) {
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

	public int[][] merge_v2(int[][] intervals) {
		int[] starts = new int[intervals.length];
		int[] ends = new int[intervals.length];

		for (int i = 0; i < intervals.length; i++) {
			int[] interval = intervals[i];
			starts[i] = interval[0];
			ends[i] = interval[1];
		}

		Arrays.sort(starts);
		Arrays.sort(ends);

		List<int[]> result = new ArrayList<>();
		for (int start = 0, end = 0; end < intervals.length; end++) {
			if (end == intervals.length - 1 || starts[end + 1] > ends[end]) {
				result.add(new int[] { starts[start], ends[end] });
				start = end + 1;
			}
		}

		return result.toArray(new int[result.size()][]);
	}
}
