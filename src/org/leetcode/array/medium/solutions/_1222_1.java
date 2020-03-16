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
public class _1222_1 {
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
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
}
