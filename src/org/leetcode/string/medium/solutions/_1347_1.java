/**
 * 
 */
package org.leetcode.string.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _1347_1 {
	public int minSteps(String s, String t) {
		int minSteps = 0;
		int[] frequency = new int[26];

		for (char c : s.toCharArray()) {
			frequency[c - 97] += 1;
		}
		for (char c : t.toCharArray()) {
			frequency[c - 97] -= 1;
		}

		for (int i : frequency)
			minSteps += i > 0 ? i : 0;

		return minSteps;
	}
}
