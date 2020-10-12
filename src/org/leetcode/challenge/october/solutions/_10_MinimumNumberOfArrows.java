/**
 * 
 */
package org.leetcode.challenge.october.solutions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author divyeshsurana
 *
 */
public class _10_MinimumNumberOfArrows {
	// Sort using lowerLimit and update each record higherLimit if the arrow is
	// shared
	public int findMinArrowShots_v1(int[][] points) {
		if (points.length == 0) {
			return 0;
		}
		Arrays.sort(points, Comparator.comparing(o -> o[0]));
		int arrows = 1;

		for (int i = 1; i < points.length; i++) {
			int[] point1 = points[i - 1];
			int[] point2 = points[i];

			if (point1[1] < point2[0]) {
				arrows++;
			} else {
				point2[1] = Math.min(point1[1], point2[1]);
			}
		}

		return arrows;
	}

	// Sort using higherLimit and update the last arrow position whenever new
	// arrow is needed
	public int findMinArrowShots_v2(int[][] points) {
		if (points.length == 0) {
			return 0;
		}
		Arrays.sort(points, Comparator.comparing(o -> o[1]));
		int arrows = 1;
		int end = points[0][1];

		for (int i = 1; i < points.length; i++) {
			if (end < points[i][0]) {
				arrows++;
				end = points[i][1];
			}
		}

		return arrows;
	}
}
