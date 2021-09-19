/**
 * 
 */
package org.eoplij.arrays;

/**
 * @author divyeshsurana
 *
 */
// Leetcode 36. Valid Sudoku -
// https://leetcode.com/problems/valid-sudoku/
public class TheSudokuCheckerProblem_6_16 {
	public boolean isValidSudoku(char[][] board) {
		// Checking every row
		for (int i = 0; i < board.length; i++) {
			if (hasDuplicate(board, i, i + 1, 0, board.length)) {
				return false;
			}
		}

		// Checking every column
		for (int j = 0; j < board.length; j++) {
			if (hasDuplicate(board, 0, board.length, j, j + 1)) {
				return false;
			}
		}

		// Checking every 3x3 region
		int regionSize = 3;
		for (int i = 0; i < regionSize; i++) {
			for (int j = 0; j < regionSize; j++) {
				if (hasDuplicate(board, i * regionSize, (i + 1) * regionSize, j * regionSize, (j + 1) * regionSize)) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean hasDuplicate(char[][] board, int startRow, int endRow, int startCol, int endCol) {
		boolean[] tracker = new boolean[9];

		for (int i = startRow; i < endRow; i++) {
			for (int j = startCol; j < endCol; j++) {
				if (board[i][j] != '.') {
					// Subtracting '1' so that every number character would
					// generate the actual number, '5' - '1' = 4
					if (tracker[board[i][j] - '1']) {
						return true;
					}
					tracker[board[i][j] - '1'] = true;
				}
			}
		}

		return false;
	}
}
