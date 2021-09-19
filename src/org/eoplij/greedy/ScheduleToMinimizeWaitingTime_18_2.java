/**
 * 
 */
package org.eoplij.greedy;

import java.util.Arrays;

/**
 * @author divyeshsurana
 *
 */
public class ScheduleToMinimizeWaitingTime_18_2 {

	public static int minimumWaitTime(int[] taskDurations) {
		Arrays.sort(taskDurations);
		int min = 0;

		for (int i = 0; i < taskDurations.length - 1; i++) {
			min += min + taskDurations[i];
		}
		return min;
	}
}
