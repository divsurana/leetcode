/**
 * 
 */
package org.eopiij.arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 54. Spiral Matrix -
// https://leetcode.com/problems/spiral-matrix/
public class SpiralOrderingOfA2DArray_6_17 {
	// This also solves the 3rd variant for m x n matrix
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new LinkedList<>();
		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int d = 0, i = 0, j = 0, m = matrix.length, n = matrix[0].length;
		int count = m * n;

		while (count > 0) {
			result.add(matrix[i][j]);

			// Updating the matrix entry to 0 so that we can track elements that
			// we have already passed
			matrix[i][j] = 0;
			i += directions[d][0];
			j += directions[d][1];

			// Update the direction since we have reached the limit or an
			// already passed element
			if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] == 0) {
				i -= directions[d][0];
				j -= directions[d][1];
				d = (d + 1) % 4;
				i += directions[d][0];
				j += directions[d][1];
			}
			count--;
		}

		return result;
	}

	// Variant
	public int[][] generateSpiralMatrix(List<Integer> order) {
		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int d = 0, i = 0, j = 0, m = (int) Math.sqrt(order.size());
		int[][] matrix = new int[m][m];

		for (int element : order) {
			if (i < 0 || j < 0 || i >= m || j >= m || matrix[i][j] != 0) {
				i -= directions[d][0];
				j -= directions[d][1];
				d = (d + 1) % 4;
				i += directions[d][0];
				j += directions[d][1];
			}
			matrix[i][j] = element;
			i += directions[d][0];
			j += directions[d][1];
		}

		return matrix;
	}
}
