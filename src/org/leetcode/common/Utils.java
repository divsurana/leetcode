/**
 * 
 */
package org.leetcode.common;

/**
 * @author divyeshsurana
 *
 */
public class Utils {
	public static void swap(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}

	public static void swap(boolean[] arr, int from, int to) {
		boolean temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
}
