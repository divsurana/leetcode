/**
 * 
 */
package org.leetcode.backtracking.medium.solutions;

/**
 * @author divyeshsurana
 *
 */
public class WordSearch {
	int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public boolean exist_v1(char[][] board, String word) {
		boolean result = false;
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length && !result; i++) {
			for (int j = 0; j < board[i].length && !result; j++) {
				result = helper(board, word, 0, i, j, visited);
			}
		}
		return result;
	}

	private boolean helper(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
		if (index == word.length()) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(index)
				|| visited[i][j]) {
			return false;
		}
		boolean result = false;
		visited[i][j] = true;
		for (int[] direction : directions) {
			result = helper(board, word, index + 1, i + direction[0], j + direction[1], visited);
			if (result) {
				break;
			}
		}
		visited[i][j] = false;
		return result;
	}

	public boolean exist_v2(char[][] board, String word) {
		boolean found = false;
		boolean[][] used = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length && !found; i++) {
			for (int j = 0; j < board[i].length && !found; j++) {
				found = check(board, used, i, j, 0, word);
			}
		}
		return found;
	}

	private boolean check(char[][] board, boolean[][] used, int i, int j, int index, String word) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || used[i][j]
				|| board[i][j] != word.charAt(index)) {
			return false;
		}
		if (index == word.length() - 1) {
			return true;
		}
		used[i][j] = true;
		for (int[] dir : directions) {
			boolean found = check(board, used, i + dir[0], j + dir[1], index + 1, word);
			if (found) {
				return true;
			}
		}
		used[i][j] = false;
		return false;
	}

	public boolean exist_v3(char[][] board, String word) {
		boolean found = false;
		for (int i = 0; i < board.length && !found; i++) {
			for (int j = 0; j < board[i].length && !found; j++) {
				found = check(board, i, j, 0, word);
			}
		}
		return found;
	}

	// way to solve it by not using a boolean array to track visited letters but
	// by xoring the letters by 256
	private boolean check(char[][] board, int i, int j, int index, String word) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] > 256
				|| board[i][j] != word.charAt(index)) {
			return false;
		}
		if (index == word.length() - 1) {
			return true;
		}
		board[i][j] ^= 256;
		for (int[] dir : directions) {
			boolean found = check(board, i + dir[0], j + dir[1], index + 1, word);
			if (found) {
				return true;
			}
		}
		board[i][j] ^= 256;
		return false;
	}
}
