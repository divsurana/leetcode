/**
 * 
 */
package org.leetcode.none.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class _807_1 {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int[] top = new int[grid[0].length];
		int[] right = new int[grid.length];

		for (int i = 0; i < grid.length; i++) {
			int max = 0;
			for (int j = 0; j < grid[i].length; j++) {
				max = Math.max(max, grid[i][j]);
			}
			right[i] = max;
		}

		for (int j = 0; j < grid[0].length; j++) {
			int max = 0;
			for (int i = 0; i < grid.length; i++) {
				max = Math.max(max, grid[i][j]);
			}
			top[j] = max;
		}
		int total = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int newHt = Math.min(right[i], top[j]);
				total += newHt - grid[i][j];
			}
		}

		return total;
	}
}
