/**
 * 
 */
package org.eoplij.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class TheIntervalCoveringProblem_18_3 {
	public static List<Integer> coveredInterval(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
		List<Integer> result = new ArrayList<>();
		int last = 0;
		for (int[] interval : intervals) {
			if (interval[0] > last) {
				last = interval[1];
				result.add(last);
			}
		}
		return result;
	}
}
