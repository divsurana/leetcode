/**
 * 
 */
package org.leetcode.backtracking.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _1079_1 {
	public int numTilePossibilities(String tiles) {
		int[] counter = new int[26];
		for (char c : tiles.toCharArray())
			counter[c - 'A'] += 1;
		return dfs(counter);
	}

	private int dfs(int[] counter) {
		int sum = 0;
		for (int i = 0; i < counter.length; i++) {
			if (counter[i] > 0) {
				sum++;
				counter[i] -= 1;
				sum += dfs(counter);
				counter[i] += 1;
			}
		}

		return sum;
	}
}
