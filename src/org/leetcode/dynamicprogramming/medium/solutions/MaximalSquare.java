/**
 * 
 */
package org.leetcode.dynamicprogramming.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int m = matrix.length, n = matrix[0].length;
		int[][] dp = new int[m + 1][n + 1];
		int dim = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					dim = Math.max(dim, dp[i][j]);
				}
			}
		}

		return dim * dim;
	}
}
