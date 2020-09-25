/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author divyesh_surana
 *
 */
public class TaskScheduler {

	public int leastInterval_v1(char[] tasks, int n) {
		int max = 0;
		int numMax = 0;
		Map<Character, Integer> taskFrequency = new HashMap<>();

		for (char task : tasks) {
			taskFrequency.put(task, taskFrequency.getOrDefault(task, 0) + 1);
			int frequency = taskFrequency.get(task);
			if (frequency > max) {
				max = frequency;
				numMax = 1;
			} else if (frequency == max) {
				numMax++;
			}
		}

		// Calculate whether the number of idle spots in between will be enough
		// for the number of remaining tasks
		int remainingTasks = Math.max(tasks.length - max * numMax, (n - numMax + 1) * (max - 1));

		return max * numMax + remainingTasks;
	}

	// Using constant memory and primitive type array to make it faster
	public int leastInterval_v2(char[] tasks, int n) {
		int max = 0;
		int numMax = 0;
		char[] taskFrequency = new char[26];

		for (char task : tasks) {
			taskFrequency[task - 'A']++;
			int frequency = taskFrequency[task - 'A'];
			if (frequency > max) {
				max = frequency;
				numMax = 1;
			} else if (frequency == max) {
				numMax++;
			}
		}

		// Calculate whether the number of idle spots in between will be enough
		// for the number of remaining tasks
		int remainingTasks = Math.max(tasks.length - max * numMax, (n - numMax + 1) * (max - 1));

		return max * numMax + remainingTasks;
	}
}
