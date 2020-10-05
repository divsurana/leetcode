/**
 * 
 */
package org.leetcode.challenge.october.solutions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author divyesh_surana
 *
 */
public class _4_RemoveCoveredIntervals {
	// Sort by smallest interval to largest and then check whether eahc interval is
	// a part of the bigger intervals after itx
	public int removeCoveredIntervals_v1(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparing(o -> o[1] - o[0]));
		int result = intervals.length;

		for (int i = 0; i < intervals.length - 1; i++) {
			int[] interval = intervals[i];
			for (int j = i + 1; j < intervals.length; j++) {
				if (interval[0] >= intervals[j][0] && interval[1] <= intervals[j][1]) {
					result--;
					break;
				}
			}
		}

		return result;
	}

	// Checking intervals in reverse order is faster
	public int removeCoveredIntervals_v2(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparing(o -> o[1] - o[0]));
		int result = intervals.length;

		for (int i = 0; i < intervals.length - 1; i++) {
			int[] interval = intervals[i];
			for (int j = intervals.length - 1; j > i; j--) {
				if (interval[0] >= intervals[j][0] && interval[1] <= intervals[j][1]) {
					result--;
					break;
				}
			}
		}

		return result;
	}
}
