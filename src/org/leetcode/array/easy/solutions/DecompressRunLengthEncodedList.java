/**
 * 
 */
package org.leetcode.array.easy.solutions;

/**
 * @author divyesh_surana
 *
 */
public class DecompressRunLengthEncodedList {
	public int[] decompressRLElist_v1(int[] nums) {
		int size = 0;
		for (int i = 0; i < nums.length; i += 2) {
			size += nums[i];
		}
		int[] decList = new int[size];

		int j = 0;
		for (int i = 0; i < nums.length; i += 2) {
			for (int k = 0; k < nums[i]; k++, j++) {
				decList[j] = nums[i + 1];
			}
		}

		return decList;
	}

	public int[] decompressRLElist_v2(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length - 1; i += 2) {
			count += nums[i];
		}

		int[] result = new int[count];
		int counter = 0;
		for (int i = 0; i < nums.length - 1; i += 2) {
			int freq = nums[i];
			int value = nums[i + 1];
			while (freq > 0) {
				result[counter++] = value;
				freq--;
			}
		}
		return result;
	}
}
