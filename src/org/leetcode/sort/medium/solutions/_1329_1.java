/**
 * 
 */
package org.leetcode.sort.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _1329_1 {
	public int[][] diagonalSort(int[][] mat) {

		for (int i = 0; i < mat.length; i++) {
			int counter = mat.length - i;

			while (counter > 0) {
				int k = i;
				int j = 0;
				while (k < mat.length - 1 && j < mat[0].length - 1) {
					if (mat[k][j] > mat[k + 1][j + 1]) {
						int swap = mat[k][j];
						mat[k][j] = mat[k + 1][j + 1];
						mat[k + 1][j + 1] = swap;
					}
					k++;
					j++;
				}
				counter--;
			}
		}

		for (int j = 1; j < mat[0].length; j++) {
			int counter = mat[0].length - j;

			while (counter > 0) {
				int i = 0;
				int k = j;
				while (i < mat.length - 1 && k < mat[0].length - 1) {
					if (mat[i][k] > mat[i + 1][k + 1]) {
						int swap = mat[i][k];
						mat[i][k] = mat[i + 1][k + 1];
						mat[i + 1][k + 1] = swap;
					}
					mat[i][k] = mat[i][k] < mat[i + 1][k + 1] ? mat[i][k] : mat[i + 1][k + 1];
					i++;
					k++;
				}
				counter--;
			}
		}

		return mat;
	}
}
