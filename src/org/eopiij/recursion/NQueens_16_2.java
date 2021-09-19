/**
 * 
 */
package org.eopiij.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class NQueens_16_2 {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		solveNQueens(n, 0, new int[n], result);
		return result;
	}

	private static void solveNQueens(int n, int row, int[] colPlacement, List<List<String>> result) {
		if (row == n) {
			// All queens are legally placed.
			result.add(generatePlacement(colPlacement));
		} else {
			for (int col = 0; col < n; ++col) {
				colPlacement[row] = col;
				if (isValid(colPlacement, row)) {
					solveNQueens(n, row + 1, colPlacement, result);
				}
			}
		}
	}

	// Test if a newly placed queen will conflict any earlier queens
	// placed before.
	private static boolean isValid(int[] colPlacement, int row) {
		for (int i = 0; i < row; ++i) {
			int diff = Math.abs(colPlacement[i] - colPlacement[row]);
			if (diff == 0 || diff == row - i) {
				return false;
			}
		}
		return true;
	}

	private static List<String> generatePlacement(int[] colPlacement) {
		List<String> sol = new ArrayList<>();
		for (int i : colPlacement) {
			StringBuilder place = new StringBuilder();
			for (int j = 0; j < colPlacement.length; j++) {
				if (j == i) {
					place.append('Q');
				} else {
					place.append('.');
				}
			}
			sol.add(place.toString());
		}
		return sol;
	}
}
