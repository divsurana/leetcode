/**
 * 
 */
package org.eoplij.graphs;

/**
 * @author divyeshsurana
 *
 */
public class ComputeEnclosedRegions_19_3 {
	final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0) {
			return;
		}
		if (board.length < 3 || board[0].length < 3) {
			return;
		}
		int m = board.length;
		int n = board[0].length;

		// go through the first column and the last column
		for (int i = 0; i < m; i++) {
			dfs(board, i, 0);
			dfs(board, i, n - 1);
		}

		// go through the first row and the last row
		for (int j = 1; j < n - 1; j++) {
			dfs(board, 0, j);
			dfs(board, m - 1, j);
		}

		// make all the remaining 'O' to 'X'
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// Flip enclosed points
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				// Revert border points
				if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}
	}

	// make every 'O' that we meet to '*'
	// It is safe because we always start from the border
	private void dfs(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return;
		}
		if (board[i][j] == 'X' || board[i][j] == '*') {
			return;
		}
		board[i][j] = '*';
		for (int[] d : DIRS) {
			dfs(board, i + d[0], j + d[1]);
		}
	}
}
