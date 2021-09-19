/**
 * 
 */
package org.dailycoding;

import java.util.HashSet;
import java.util.Set;

/**
 * @author divyeshsurana
 *
 */
public class TwoSum_1 {
	public boolean ifTwoSum(int[] nums, int sum) {
		Set<Integer> complements = new HashSet<>();

		for (int num : nums) {
			if (complements.contains(num)) {
				return true;
			}
			complements.add(sum - num);
		}

		return false;
	}
}
