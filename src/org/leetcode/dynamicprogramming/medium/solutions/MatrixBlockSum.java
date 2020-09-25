/**
 * 
 */
package org.leetcode.dynamicprogramming.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class MatrixBlockSum {
	public int[][] matrixBlockSum(int[][] mat, int K) {
		int[][] output = new int[mat.length][mat[0].length];

		for (int i = 0; i < output.length; i++) {
			for (int j = 0; j < output[0].length; j++) {

				int rowLower = Math.max(0, i - K);
				int rowHigher = Math.min(mat.length - 1, i + K);

				int colLower = Math.max(0, j - K);
				int colHigher = Math.min(mat[0].length - 1, j + K);

				for (int r = rowLower; r <= rowHigher; r++) {
					for (int c = colLower; c <= colHigher; c++) {
						output[i][j] += mat[r][c];
					}
				}
			}
		}

		return output;
	}

	public int[][] matrixBlockSum_v2(int[][] mat, int K) {
		int[][] newMat = new int[mat.length][mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			newMat[i] = new int[mat[i].length];
			for (int j = 0; j < mat[i].length; j++) {
				for (int l = i - K; l <= i + K; l++) {
					if (l >= 0 && l < mat.length) {
						for (int m = j - K; m <= j + K; m++) {
							if (m >= 0 && m < mat[l].length) {
								newMat[i][j] += mat[l][m];
							}
						}
					}
				}
			}
		}
		return newMat;
	}

	public int[][] matrixBlockSum_v3(int[][] mat, int K) {
		int[][] newMat = new int[mat.length][mat[0].length];

		// Populate first element
		for (int i = 0; i < mat.length && i <= K; i++) {
			for (int j = 0; j < mat[i].length && j <= K; j++) {
				newMat[0][0] += mat[i][j];
			}
		}

		// Populate first column
		for (int i = 1, j = 0; i < mat.length && j < mat[i].length; i++) {
			newMat[i][j] = newMat[i - 1][j];
			if (i - K - 1 >= 0) {
				for (int m = j - K; m <= j + K; m++) {
					if (m >= 0 && m < mat[i].length) {
						newMat[i][j] -= mat[i - K - 1][m];
					}
				}
			}
			if (i + K < mat.length) {
				for (int m = j - K; m <= j + K; m++) {
					if (m >= 0 && m < mat[i].length) {
						newMat[i][j] += mat[i + K][m];
					}
				}

			}
		}

		// Populate other elements one row at a time
		for (int i = 0; i < mat.length; i++) {
			for (int j = 1; j < mat[i].length; j++) {
				newMat[i][j] = newMat[i][j - 1];
				if (j - K - 1 >= 0) {
					for (int l = i - K; l <= i + K; l++) {
						if (l >= 0 && l < mat.length) {
							newMat[i][j] -= mat[l][j - K - 1];
						}
					}
				}
				if (j + K < mat[i].length) {
					for (int l = i - K; l <= i + K; l++) {
						if (l >= 0 && l < mat.length) {
							newMat[i][j] += mat[l][j + K];
						}
					}
				}
			}
		}

		return newMat;
	}
}
