/**
 * 
 */
package org.leetcode.array.easy.solutions;

import java.util.Arrays;

/**
 * @author divyesh_surana
 *
 */
public class SquaresOfASortedArray {
	public int[] sortedSquares(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A[i] *= A[i];
		}
		Arrays.sort(A);
		return A;
	}
}
