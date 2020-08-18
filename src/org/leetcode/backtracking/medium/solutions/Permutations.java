/**
 * 
 */
package org.leetcode.backtracking.medium.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author divyesh_surana
 *
 */
public class Permutations {
	public List<List<Integer>> permute_v1(int[] nums) {
		List<Integer> numsList = IntStream.of(nums) // returns IntStream
				.boxed().collect(Collectors.toList());

		return helper(numsList);
	}

	private List<List<Integer>> helper(List<Integer> nums) {
		List<List<Integer>> result = new LinkedList<>();

		if (nums.isEmpty()) {
			return result;
		}

		for (int i = 0; i < nums.size(); i++) {
			int number = nums.get(i);

			List<List<Integer>> perms = helper(
					Stream.concat(nums.subList(0, i).stream(), nums.subList(i + 1, nums.size()).stream())
							.collect(Collectors.toList()));

			for (List<Integer> list : perms) {
				result.add(Stream.concat(Arrays.asList(Integer.valueOf(number)).stream(), list.stream())
						.collect(Collectors.toList()));
			}

			if (result.isEmpty()) {
				result.add(Arrays.asList(Integer.valueOf(number)));
			}
		}

		return result;

	}

	public List<List<Integer>> permute_v2(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> combinations = new ArrayList<>();
			int[] array1 = Arrays.copyOfRange(nums, 0, i);
			int[] array2 = Arrays.copyOfRange(nums, i + 1, nums.length);
			int aLen = array1.length;
			int bLen = array2.length;
			int[] result = new int[aLen + bLen];
			System.arraycopy(array1, 0, result, 0, aLen);
			System.arraycopy(array2, 0, result, aLen, bLen);

			if (result.length == 0) {
				combinations.add(new LinkedList<Integer>());
			} else {
				combinations = permute_v2(result);
			}

			for (List<Integer> combination : combinations) {
				combination.add(nums[i]);
			}
			list.addAll(combinations);
		}
		return list;
	}
}
