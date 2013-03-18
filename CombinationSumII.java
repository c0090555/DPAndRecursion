package DPandRecursion;

/*
 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:

 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.

 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6] 
 */
import java.util.*;

public class CombinationSumII {
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int n = num.length;
		if (n == 0) {
			return res;
		}
		Arrays.sort(num);// sort input array first
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += num[i];
		}
		if (target < num[0] || target > sum) {

			return res;
		}
		// System.out.println(num[0]);
		ArrayList<Integer> comb = new ArrayList<Integer>();
		Hashtable<ArrayList<Integer>, Boolean> hash = new Hashtable<ArrayList<Integer>, Boolean>();
		combinationSum2Helper(num, 0, target, comb, res, hash);
		return res;

	}

	public void combinationSum2Helper(int[] num, int index, int target,
			ArrayList<Integer> comb, ArrayList<ArrayList<Integer>> res,
			Hashtable<ArrayList<Integer>, Boolean> hash) {
		if (target < 0) {// base case
			return;
		}
		if (target == 0) {
			if (!hash.containsKey(comb)) {
				hash.put(comb, true);
				res.add(comb);
				// System.out.println(comb);
			}
			return;
		}
		if (index == num.length) {
			return;
		}
		ArrayList<Integer> cp = new ArrayList<Integer>(comb);
		combinationSum2Helper(num, index + 1, target, cp, res, hash);// without
		// num[index]

		if (target - num[index] >= 0) {// with num[index]
			cp.add(num[index]);
			combinationSum2Helper(num, index + 1, target - num[index], cp, res,
					hash);

		} else {
			return;
		}
	}

	public static void main(String[] args) {
		CombinationSumII o = new CombinationSumII();
		int[] num = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;

		o.combinationSum2(num, target);
	}
}
