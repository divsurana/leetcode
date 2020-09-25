/**
 * 
 */
package org.leetcode.bfs.medium.solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author divyesh_surana
 *
 */
public class Minesweeper {
	// iterative approach (BFS)
	public char[][] updateBoard_v1(char[][] board, int[] click) {

		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
			return board;
		} else {
			int[][] directions = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 }, { 0, -1 }, { 0, 1 }, { -1, 0 },
					{ 1, 0 } };
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(click);
			while (!queue.isEmpty()) {
				int[] pos = queue.poll();
				int r = pos[0];
				int c = pos[1];
				if (board[r][c] == 'E') {
					int mines = 0;
					Queue<int[]> blankCells = new LinkedList<>();

					for (int[] dir : directions) {
						int newR = r + dir[0];
						int newC = c + dir[1];

						if (newR >= 0 && newC >= 0 && newR < board.length && newC < board[newR].length) {
							if (board[newR][newC] == 'M') {
								mines++;
							} else if (board[newR][newC] == 'E') {
								blankCells.add(new int[] { newR, newC });
							}
						}

					}
					if (mines == 0) {
						board[r][c] = 'B';
						queue.addAll(blankCells);
					} else {
						board[r][c] = Character.forDigit(mines, 10);
					}
				}
			}
		}

		return board;
	}

	// recursive approach (DFS)
	public char[][] updateBoard_v2(char[][] board, int[] click) {
		if (board[click[0]][click[1]] == 'M') {
			board[click[0]][click[1]] = 'X';
		} else if (board[click[0]][click[1]] == 'E') {
			int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, -1 }, { -1, 1 }, { 1, 1 },
					{ -1, -1 } };
			int mines = 0;
			List<int[]> clicks = new ArrayList<>();
			for (int[] dir : directions) {
				int r = click[0] + dir[0];
				int c = click[1] + dir[1];
				if (r >= 0 && r < board.length && c >= 0 && c < board[r].length) {
					if (board[r][c] == 'M') {
						mines++;
					} else if (board[r][c] == 'E') {
						clicks.add(new int[] { r, c });
					}
				}
			}
			if (mines == 0) {
				board[click[0]][click[1]] = 'B';
				for (int[] surrounding : clicks) {
					updateBoard_v2(board, surrounding);
				}
			} else {
				board[click[0]][click[1]] = Character.forDigit(mines, 10);
			}
		}
		return board;
	}
}
