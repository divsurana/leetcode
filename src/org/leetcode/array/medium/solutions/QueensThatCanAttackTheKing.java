/**
 * 
 */
package org.leetcode.array.medium.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author divyesh_surana
 *
 */
public class QueensThatCanAttackTheKing {
	public List<List<Integer>> queensAttacktheKing_v1(int[][] queens, int[] king) {
		List<List<Integer>> result = new ArrayList<>();

		List<List<Integer>> queensList = new ArrayList<>();
		for (int[] ints : queens) {
			List<Integer> list = new ArrayList<>();
			for (int i : ints) {
				list.add(i);
			}
			queensList.add(list);
		}

		// Check top-left
		for (int i = king[0], j = king[1]; i >= 0 && j >= 0; i--, j--) {
			if (queensList.contains(Arrays.asList(i, j))) {
				queensList.remove(Arrays.asList(i, j));
				result.add(Arrays.asList(i, j));
				break;
			}
		}

		// Check top
		for (int i = king[0], j = king[1]; i >= 0; i--) {
			if (queensList.contains(Arrays.asList(i, j))) {
				queensList.remove(Arrays.asList(i, j));
				result.add(Arrays.asList(i, j));
				break;
			}
		}

		// Check top-right
		for (int i = king[0], j = king[1]; i >= 0 && j < 8; i--, j++) {
			if (queensList.contains(Arrays.asList(i, j))) {
				queensList.remove(Arrays.asList(i, j));
				result.add(Arrays.asList(i, j));
				break;
			}
		}

		// Check right
		for (int i = king[0], j = king[1]; j < 8; j++) {
			if (queensList.contains(Arrays.asList(i, j))) {
				queensList.remove(Arrays.asList(i, j));
				result.add(Arrays.asList(i, j));
				break;
			}
		}

		// Check bottom-right
		for (int i = king[0], j = king[1]; i < 8 && j < 8; i++, j++) {
			if (queensList.contains(Arrays.asList(i, j))) {
				queensList.remove(Arrays.asList(i, j));
				result.add(Arrays.asList(i, j));
				break;
			}
		}

		// Check bottom
		for (int i = king[0], j = king[1]; i < 8; i++) {
			if (queensList.contains(Arrays.asList(i, j))) {
				queensList.remove(Arrays.asList(i, j));
				result.add(Arrays.asList(i, j));
				break;
			}
		}

		// Check bottom-left
		for (int i = king[0], j = king[1]; i < 8 && j >= 0; i++, j--) {
			if (queensList.contains(Arrays.asList(i, j))) {
				queensList.remove(Arrays.asList(i, j));
				result.add(Arrays.asList(i, j));
				break;
			}
		}

		// Check left
		for (int i = king[0], j = king[1]; j >= 0; j--) {
			if (queensList.contains(Arrays.asList(i, j))) {
				queensList.remove(Arrays.asList(i, j));
				result.add(Arrays.asList(i, j));
				break;
			}
		}

		return result;
	}

	// Using direction array
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[][] seen = new boolean[8][8];
		for (int[] queen : queens) {
			seen[queen[0]][queen[1]] = true;
		}
		int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

		for (int[] dir : directions) {
			for (int i = king[0], j = king[1]; i >= 0 && j >= 0 && i < 8 && j < 8; i += dir[0], j += dir[1]) {
				if (seen[i][j]) {
					result.add(Arrays.asList(i, j));
					break;
				}
			}
		}

		return result;
	}

	public List<List<Integer>> queensAttacktheKing_v3(int[][] queens, int[] king) {
		List<List<Integer>> result = new ArrayList<>();
		int row = king[0];
		int col = king[1];
		boolean[][] chessBoard = new boolean[8][8];
		boolean[] found = new boolean[8];

		for (int[] queen : queens) {
			chessBoard[queen[0]][queen[1]] = true;
		}

		for (int i = col - 1, j = col + 1, k = row - 1, l = row + 1; i >= 0 || j < 8 || k >= 0
				|| l < 8; i--, j++, k--, l++) {
			// west
			if (!found[0] && i >= 0 && chessBoard[row][i]) {
				result.add(Arrays.asList(row, i));
				found[0] = true;
			}
			// east
			if (!found[1] && j < 8 && chessBoard[row][j]) {
				result.add(Arrays.asList(row, j));
				found[1] = true;
			}
			// north
			if (!found[2] && k >= 0 && chessBoard[k][col]) {
				result.add(Arrays.asList(k, col));
				found[2] = true;
			}
			// south
			if (!found[3] && l < 8 && chessBoard[l][col]) {
				result.add(Arrays.asList(l, col));
				found[3] = true;
			}

			// northwest
			if (!found[4] && i >= 0 && k >= 0 && chessBoard[k][i]) {
				result.add(Arrays.asList(k, i));
				found[4] = true;
			}
			// southwest
			if (!found[5] && i >= 0 && l < 8 && chessBoard[l][i]) {
				result.add(Arrays.asList(l, i));
				found[5] = true;
			}
			// northeast
			if (!found[6] && j < 8 && k >= 0 && chessBoard[k][j]) {
				result.add(Arrays.asList(k, j));
				found[6] = true;
			}
			// southeast
			if (!found[7] && j < 8 && l < 8 && chessBoard[l][j]) {
				result.add(Arrays.asList(l, j));
				found[7] = true;
			}
		}

		return result;
	}
}