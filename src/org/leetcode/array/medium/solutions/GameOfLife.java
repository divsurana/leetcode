/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class GameOfLife {
	public void gameOfLife_v1(int[][] board) {
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

	public void gameOfLife_v2(int[][] board) {
		int[][] directions = { { -1, -1 }, { -1, 0 }, { 0, -1 }, { -1, 1 }, { 1, -1 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
		int[][] output = new int[board.length][];

		for (int i = 0; i < board.length; i++) {
			output[i] = new int[board[i].length];
			for (int j = 0; j < board[i].length; j++) {
				int liveNeighbors = 0;
				for (int[] dir : directions) {
					int r = i + dir[0];
					int c = j + dir[1];

					if (r >= 0 && r < board.length && c >= 0 && c < board[i].length) {
						if (board[r][c] == 1) {
							liveNeighbors++;
						}
					}
				}

				if (board[i][j] == 0) {
					if (liveNeighbors == 3) {
						output[i][j] = 1;
					}
				} else {
					if (liveNeighbors == 2 || liveNeighbors == 3) {
						output[i][j] = 1;
					}
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = output[i][j];
			}
		}
	}

	public void gameOfLife_v3(int[][] board) {
		int[][] directions = { { -1, -1 }, { -1, 0 }, { 0, -1 }, { -1, 1 }, { 1, -1 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
		List<int[]> changes = new ArrayList<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int liveNeighbors = 0;
				for (int[] dir : directions) {
					int r = i + dir[0];
					int c = j + dir[1];

					if (r >= 0 && r < board.length && c >= 0 && c < board[i].length) {
						if (board[r][c] == 1) {
							liveNeighbors++;
						}
					}
				}

				if (board[i][j] == 0) {
					if (liveNeighbors == 3) {
						changes.add(new int[] { i, j });
					}
				} else {
					if (liveNeighbors < 2 || liveNeighbors > 3) {
						changes.add(new int[] { i, j });
					}
				}
			}
		}

		for (int[] change : changes) {
			int i = change[0], j = change[1];
			int val = board[i][j];
			board[i][j] = val == 0 ? 1 : 0;
		}
	}

	// In place solution with constant memory
	public void gameOfLife_v4(int[][] board) {
		int[][] directions = { { -1, -1 }, { -1, 0 }, { 0, -1 }, { -1, 1 }, { 1, -1 }, { 1, 0 }, { 0, 1 }, { 1, 1 } };
		int ALIVE_TO_DEAD = 2;
		int DEAD_TO_ALIVE = 3;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int liveNeighbors = 0;
				for (int[] dir : directions) {
					int r = i + dir[0];
					int c = j + dir[1];
					if (r >= 0 && r < board.length && c >= 0 && c < board[r].length) {
						if (board[r][c] == 1 || board[r][c] == ALIVE_TO_DEAD) {
							liveNeighbors++;
						}
					}
				}
				if (board[i][j] == 1) {
					if (liveNeighbors < 2 || liveNeighbors > 3) {
						board[i][j] = ALIVE_TO_DEAD;
					}
				} else {
					if (liveNeighbors == 3) {
						board[i][j] = DEAD_TO_ALIVE;
					}
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = board[i][j] % 2; // 0, 1 will remain the same and
												// 2, 3 will become 0 and 1
												// respectively as expected
			}
		}
	}
}
