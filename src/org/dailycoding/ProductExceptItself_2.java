/**
 * 
 */
package org.dailycoding;

/**
 * @author divyeshsurana
 *
 */
public class ProductExceptItself_2 {
	// Both are similar just a different way of implementing the for loops
	public int[] getProduct_v1(int[] nums) {
		int[] result = new int[nums.length];
		result[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			result[i] = result[i - 1] * nums[i - 1];
		}
		int product = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			product *= nums[i + 1];
			result[i] *= product;
		}

		return result;
	}

	public int[] getProduct_v2(int[] nums) {
		int[] result = new int[nums.length];
		int product = 1;
		for (int i = 0; i < nums.length; i++) {
			result[i] = product;
			product *= nums[i];
		}
		product = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			result[i] *= product;
			product *= nums[i];
		}

		return result;
	}
}
