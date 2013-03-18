package DPandRecursion;

/*
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.

 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3] 
 Solution: DFS + DP
 Note: we need to make a copy of combination ArrayList on each level
 */
import java.util.*;

public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int n = candidates.length;
		if (n == 0) {
			return res;
		}
		Arrays.sort(candidates);// sort candidates set first
		if (target < candidates[0]) {
			return res;
		}
		ArrayList<Integer> comb = new ArrayList<Integer>();
		combinationSumHelper(candidates, 0, target, comb, res);
		return res;

	}

	public void combinationSumHelper(int[] candidates, int index, int target,
			ArrayList<Integer> comb, ArrayList<ArrayList<Integer>> res) {
		if (target < 0)// base case
			return;
		if (target == 0) {// base case
			ArrayList<Integer> cp = new ArrayList<Integer>(comb);
//			System.out.println("res " + cp);
			res.add(cp);
			return;
		}
		if (index == candidates.length) // base case
			return;
		
		ArrayList<Integer> cp = new ArrayList<Integer>(comb);//for each level, we need a copy of comb
		for (int i = 1; target - i * candidates[index] >= 0; i++) {// with
			cp.add(candidates[index]);
			combinationSumHelper(candidates, index + 1, target - i
					* candidates[index], cp, res);
		}
		combinationSumHelper(candidates, index + 1, target, comb, res);// without
																		// candidates[index]
	}

	public static void main(String[] args) {
		CombinationSum o = new CombinationSum();
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		o.combinationSum(candidates, target);
	}

}
