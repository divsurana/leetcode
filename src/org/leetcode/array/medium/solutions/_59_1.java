/**
 * 
 */
package org.leetcode.array.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _59_1 {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int[] dir = directions[0];

		for (int i = 0, j = 0, k = 0, counter = 1; counter <= n * n; i += dir[0], j += dir[1], counter++) {
			if (i < 0 || i >= n || j < 0 || j >= n || matrix[i][j] != 0) {
				i -= dir[0];
				j -= dir[1];
				--counter;
				k = ++k % directions.length;
				dir = directions[k];
			} else {
				matrix[i][j] = counter;
			}
		}

		return matrix;
	}
}
