/**
 * 
 */
package org.leetcode.array.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class SpiralMatrixII {
	public int[][] generateMatrix_v1(int n) {
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

	public int[][] generateMatrix_v2(int n) {
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int[][] result = new int[n][n];

		for (int counter = 1, d = 0, i = 0, j = 0; counter <= n * n; i += dir[d][0], j += dir[d][1]) {
			if (i < 0 || i >= n || j < 0 || j >= n || result[i][j] != 0) {
				i -= dir[d][0];
				j -= dir[d][1];
				d = (d + 1) % dir.length;
			} else {
				result[i][j] = counter;
				counter++;
			}
		}

		return result;
	}
}
