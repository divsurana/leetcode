/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class GameOfLife {
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
}
