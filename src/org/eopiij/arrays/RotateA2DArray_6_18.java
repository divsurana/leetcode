/**
 * 
 */
package org.eopiij.arrays;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 48. Rotate Image -
// https://leetcode.com/problems/rotate-image/
public class RotateA2DArray_6_18 {
	public void rotate(int[][] matrix) {
		int length = matrix.length - 1;
		// Start with the outer layer top left element and continue inwards the
		// same way
		for (int i = 0; i < matrix.length / 2; ++i) {
			for (int j = i; j < length - i; ++j) {
				// Remember that i -> j and j -> matrix.length - i. From here
				// substitute the values each time to derive the 4 elements and
				// use them for every rotation.
				// Perform a 4-way exchange.
				int temp1 = matrix[length - j][i]; // Fourth element
				int temp2 = matrix[length - i][length - j]; // Third element
				int temp3 = matrix[j][length - i]; // Second element
				int temp4 = matrix[i][j]; // First element
				matrix[i][j] = temp1;
				matrix[length - j][i] = temp2;
				matrix[length - i][length - j] = temp3;
				matrix[j][length - i] = temp4;
			}
		}
	}

	// Variant
	public void reflectHorizontally(int[][] matrix) {
		int length = matrix.length - 1;
		for (int i = 0; i < matrix.length / 2; ++i) {
			for (int j = 0; j < matrix.length; ++j) {
				swap(matrix, i, j, length - i, j);
			}
		}
	}

	// Variant
	public void reflectVertically(int[][] matrix) {
		int length = matrix.length - 1;
		for (int i = 0; i < matrix.length / 2; ++i) {
			for (int j = 0; j < matrix.length; ++j) {
				swap(matrix, i, j, i, length - j);
			}
		}
	}

	// Variant
	public void reflectDiagonalTopLeft(int[][] matrix) {
		for (int i = 0; i < matrix.length - 1; ++i) {
			for (int j = i + 1; j < matrix.length; ++j) {
				swap(matrix, i, j, j, i);
			}
		}
	}

	// Variant
	public void reflectDiagonalTopRight(int[][] matrix) {
		int length = matrix.length - 1;
		for (int i = 0; i < length; ++i) {
			for (int j = 0; j < length - i; ++j) {
				swap(matrix, i, j, length - j, length - i);
			}
		}
	}

	public void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
		int temp = matrix[i1][j1];
		matrix[i1][j1] = matrix[i2][j2];
		matrix[i2][j2] = temp;
	}
}
