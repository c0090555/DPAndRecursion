package DPAndRecursive;

/*
 Given a set of distinct integers, S, return all possible subsets.

 Note:

 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.

 For example,
 If S = [1,2,3], a solution is:

 [
 [3],
 [1],
 [2],
 [1,2,3],
 [1,3],
 [2,3],
 [1,2],
 []
 ]

 Solution1: Recursion
 Solution2: Bit Manipulation

 */
import java.util.*;

public class Subsets {
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (S.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		Arrays.sort(S);
		return getSubsets(S);
	}

	// Solution 1: Recursion
	public ArrayList<ArrayList<Integer>> subsetsRecur(int[] S, int index) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (index < 0) {// base case []
			ArrayList<Integer> oneSubset = new ArrayList<Integer>();
			result.add(oneSubset);
			return result;
		}

		ArrayList<ArrayList<Integer>> moreSubsets = subsetsRecur(S, index - 1);
		int current = S[index];
		result.addAll(moreSubsets);

		for (ArrayList<Integer> subset : moreSubsets) {
			ArrayList<Integer> newSubset = new ArrayList<Integer>();// Note:
																	// here we
																	// cannot
																	// modify
																	// subset
																	// directly,
																	// since
																	// that will
																	// affect
																	// moreSubsets
			newSubset.addAll(subset);// clone
			newSubset.add(current);// add

			result.add(newSubset);
		}
		return result;

	}
	//Solution2: Bit Manipulation
	public ArrayList<ArrayList<Integer>> getSubsets(int[] S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int n = S.length;
		if (n == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		Arrays.sort(S);
		result.add(new ArrayList<Integer>());
		for (int i = 1; i < (1 << n); i++) {
			ArrayList<Integer> oneSubset = convertNumToArrayList(S, i);
			result.add(oneSubset);
		}
		return result;

	}

	public ArrayList<Integer> convertNumToArrayList(int[] S, int num) {
		int index = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		while (num > 0 && index < S.length) {
			if ((num & 1) > 0) {
				result.add(S[index]);
			}
			num >>= 1;
			index++;
		}
		return result;

	}

	public static void main(String[] args) {
		Subsets o = new Subsets();
		int[] S = { 1, 2 };
		System.out.println(o.subsets(S));
	}

}
