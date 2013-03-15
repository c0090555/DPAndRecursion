package DPandRecursion;

/*
 Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:

 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 
 Solution: Recursion + Hashtable<ArrayList<Integer>,Boolean>

 */
import java.util.*;

public class SubsetsII {
	public static Hashtable<ArrayList<Integer>, Boolean> hash = new Hashtable<ArrayList<Integer>, Boolean>();

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Hashtable<ArrayList<Integer>, Boolean> hash = new Hashtable<ArrayList<Integer>, Boolean>();
		if (num.length == 0) {
			return new ArrayList<ArrayList<Integer>>();
		}
		ArrayList<ArrayList<Integer>> res = getSubsets(num, 0);
		return res;

	}

	public ArrayList<ArrayList<Integer>> getSubsets(int[] num, int index) {
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();

		if (index == num.length) {// base case
			allSubsets.add(new ArrayList<Integer>());
			return allSubsets;
		}
		int curr = num[index];
		allSubsets = getSubsets(num, index + 1);
		ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> subset : allSubsets) {
			ArrayList<Integer> newSub = new ArrayList<Integer>();
			newSub.addAll(subset);
			newSub.add(0, curr);
			Collections.sort(newSub);
			if (!hash.containsKey(newSub)) {
				moreSubsets.add(newSub);
				hash.put(newSub, true);
			}

		}
		allSubsets.addAll(moreSubsets);

		return allSubsets;

	}

	public static void main(String[] args) {
		SubsetsII o = new SubsetsII();
		int[] num = { 1, 1 };
		ArrayList<ArrayList<Integer>> res = o.subsetsWithDup(num);
		System.out.println(res);
	}

}
