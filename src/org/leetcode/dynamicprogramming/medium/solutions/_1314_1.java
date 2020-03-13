/**
 * 
 */
package org.leetcode.dynamicprogramming.medium.solutions;

/**
 * @author divyesh_surana
 *
 */
public class _1314_1 {
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
}
