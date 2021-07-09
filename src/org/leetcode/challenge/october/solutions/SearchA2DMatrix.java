/**
 * 
 */
package org.leetcode.challenge.october.solutions;

/**
 * @author divyeshsurana
 *
 */
public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		boolean found = false;
		int startRow = 0;

		for (; startRow < matrix.length; startRow++) {
			if (matrix[startRow][0] > target) {
				startRow = matrix.length;
			} else if (matrix[startRow][matrix[startRow].length - 1] >= target) {
				break;
			}
		}

		if (startRow < matrix.length) {
			int start = 0, end = matrix[startRow].length - 1;
			while (!found && start <= end) {
				int idx = (start + end) / 2;
				if (matrix[startRow][idx] < target) {
					start = idx + 1;
				} else if (matrix[startRow][idx] > target) {
					end = idx - 1;
				} else {
					found = true;
				}
			}
		}

		return found;
	}
}
