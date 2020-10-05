/**
 * 
 */
package org.leetcode.challenge.october.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author divyesh_surana
 *
 */
public class _2_CombinationSum {
	List<List<Integer>> combinations = new ArrayList<>();

	public List<List<Integer>> combinationSum_v1(int[] candidates, int target) {
		Arrays.sort(candidates);
		combination(candidates, 0, new ArrayList<>(), 0, target);
		return combinations;
	}

	private void combination(int[] candidates, int currCandidate, List<Integer> combination, int current, int target) {
		if (current == target)
			combinations.add(new ArrayList<>(combination));
		for (int candidate : candidates) {
			if (candidate < currCandidate)
				continue;
			if (current + candidate > target)
				break;
			combination.add(candidate);
			combination(candidates, candidate, combination, current + candidate, target);
			combination.remove(Integer.valueOf(candidate));
		}
	}

	// Just changed to passing the index of the candidate instead of the candidate
	// itself to reduce number of loops
	public List<List<Integer>> combinationSum_v2(int[] candidates, int target) {
		Arrays.sort(candidates);
		combination(candidates, 0, new ArrayList<>(), target);
		return combinations;
	}

	private void combination(int[] candidates, int currIdx, List<Integer> combination, int target) {
		if (target == 0)
			combinations.add(new ArrayList<>(combination));
		for (int i = currIdx; i < candidates.length; i++) {
			int candidate = candidates[i];
			if (target - candidate < 0)
				break;
			combination.add(candidate);
			combination(candidates, i, combination, target - candidate);
			combination.remove(Integer.valueOf(candidate));
		}
	}

	// Using linkedlist push pop for faster addition and removal
	public List<List<Integer>> combinationSum_v3(int[] candidates, int target) {
		Arrays.sort(candidates);
		combination(candidates, 0, new LinkedList<>(), target);
		return combinations;
	}

	private void combination(int[] candidates, int currIdx, LinkedList<Integer> combination, int target) {
		if (target == 0)
			combinations.add(new ArrayList<>(combination));
		for (int i = currIdx; i < candidates.length; i++) {
			int candidate = candidates[i];
			if (target - candidate < 0)
				break;
			combination.push(candidate);
			combination(candidates, i, combination, target - candidate);
			combination.pop();
		}
	}

	// Without using global variable
	public List<List<Integer>> combinationSum_v4(int[] candidates, int target) {
		Arrays.sort(candidates);
		return combination(candidates, 0, new LinkedList<>(), target, new ArrayList<>());
	}

	private List<List<Integer>> combination(int[] candidates, int currIdx, LinkedList<Integer> combination, int target,
			List<List<Integer>> combinations) {
		if (target == 0)
			combinations.add(new ArrayList<>(combination));
		for (int i = currIdx; i < candidates.length; i++) {
			int candidate = candidates[i];
			if (target - candidate < 0)
				break;
			combination.push(candidate);
			combination(candidates, i, combination, target - candidate, combinations);
			combination.pop();
		}
		return combinations;
	}
}
