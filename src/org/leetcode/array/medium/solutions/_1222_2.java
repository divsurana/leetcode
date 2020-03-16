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
public class _1222_2 {

	// Using direction array
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[][] seen = new boolean[8][8];
		for (int[] queen : queens)
			seen[queen[0]][queen[1]] = true;
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
}
