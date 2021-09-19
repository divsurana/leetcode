/**
 * 
 */
package org.eoplij.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author divyeshsurana
 *
 */
public class SortAnIncreasingDecreasingArray_11_2 {
	public static List<Integer> sortKIncreasingDecreasingArray(List<Integer> A) {
		// Decomposes A into a set of sorted arrays.
		List<List<Integer>> sortedSubarrays = new ArrayList<>();
		SubarrayType subarrayType = SubarrayType.INCREASING;
		int startIdx = 0;
		for (int i = 1; i <= A.size(); ++i) {
			if (i == A.size() // A is ended. Adds the last subarray
					|| A.get(i - 1) < A.get(i) && subarrayType == SubarrayType.DECREASING
					|| A.get(i - 1) >= A.get(i) && subarrayType == SubarrayType.INCREASING) {
				List<Integer> subList = A.subList(startIdx, i);
				if (subarrayType == SubarrayType.DECREASING) {
					Collections.reverse(subList);
				}
				sortedSubarrays.add(subList);
				startIdx = i;
				subarrayType = subarrayType == SubarrayType.INCREASING ? SubarrayType.DECREASING
						: SubarrayType.INCREASING;
			}
		}
		// Use function to sort k arrays (MergeSortedFiles_11_1.java)
		return MergeSortedArrays.mergeSortedArrays(sortedSubarrays);
	}

	private static enum SubarrayType {
		INCREASING, DECREASING
	}
}
