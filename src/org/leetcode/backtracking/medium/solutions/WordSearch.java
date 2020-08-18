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

	public boolean exist(char[][] board, String word) {
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
}
