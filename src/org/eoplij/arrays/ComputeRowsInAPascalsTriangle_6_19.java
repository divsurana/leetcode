/**
 * 
 */
package org.eoplij.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
// Leetcode Problem 118. Pascal's Triangle -
// https://leetcode.com/problems/pascals-triangle/
public class ComputeRowsInAPascalsTriangle_6_19 {
	public List<List<Integer>> generate_v1(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> prev = new ArrayList<>();
		prev.add(1);
		result.add(prev);
		for (int i = 2; i <= numRows; i++) {
			List<Integer> row = new ArrayList<>();
			row.add(1);
			for (int j = 1; j < i - 1; j++) {
				row.add(prev.get(j - 1) + prev.get(j));
			}
			row.add(1);
			result.add(row);
			prev = row;
		}
		return result;
	}

	public List<List<Integer>> generate_v2(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(Arrays.asList(1));
		for (int i = 1; i < numRows; i++) {
			List<Integer> row = new ArrayList<>();
			row.add(1);
			for (int j = 1; j < i; j++) {
				row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
			}
			row.add(1);
			result.add(row);
		}
		return result;
	}

	// Variant - Based on the principle that, the ith element in nth row of a
	// Pascal's triangle is nCi and therefore every subsequent entry just needs
	// to be multiplied by n - i / i
	public List<Integer> getRow(int rowIndex) {
		List<Integer> row = new ArrayList<>(Collections.nCopies(rowIndex + 1, 1));
		for (int i = 1; i <= rowIndex / 2; i++) {
			// Using long to prevent overflow
			long prev = row.get(i - 1);
			int total = (int) (prev * (rowIndex + 1 - i) / i);
			if (i != rowIndex - i) {
				row.set(rowIndex - i, total);
			}
			row.set(i, total);
		}
		return row;
	}
}
