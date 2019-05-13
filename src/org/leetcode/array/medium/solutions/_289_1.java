/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.Arrays;

/**
 * @author divyesh_surana
 *
 */
public class _289_1 {
	public void gameOfLife(int[][] board) {
		int[][] newBoard = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				newBoard[i][j] = board[i][j];
				int alive = 0;

				if (i > 0 && j > 0) {
					if (board[i - 1][j - 1] != 0) {
						alive++;
					}
				}
				if (i > 0 && j < board[i].length - 1) {
					if (board[i - 1][j + 1] != 0) {
						alive++;
					}
				}
				if (i < board.length - 1 && j > 0) {
					if (board[i + 1][j - 1] != 0) {
						alive++;
					}
				}
				if (i < board.length - 1 && j < board[i].length - 1) {
					if (board[i + 1][j + 1] != 0) {
						alive++;
					}
				}
				if (i > 0) {
					if (board[i - 1][j] != 0) {
						alive++;
					}
				}
				if (i < board.length - 1) {
					if (board[i + 1][j] != 0) {
						alive++;
					}
				}
				if (j > 0) {
					if (board[i][j - 1] != 0) {
						alive++;
					}
				}
				if (j < board[i].length - 1) {

					if (board[i][j + 1] != 0) {
						alive++;
					}
				}

				if (board[i][j] == 1 && (alive < 2 || alive > 3)) {
					newBoard[i][j] = 0;
				} else if (board[i][j] == 0 && alive == 3) {
					newBoard[i][j] = 1;
				}

			}
		}

		for (int i = 0; i < board.length; i++) {
			board[i] = Arrays.copyOf(newBoard[i], newBoard[i].length);
		}

	}
}
