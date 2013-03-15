package DPAndRecursive;

/*
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 For example,
 If n = 4 and k = 2, a solution is:

 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]

 Solution: Recursion 1.choose n 2.not choose n

 */
import java.util.*;

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (k == 0 || n < k) {
			return new ArrayList<ArrayList<Integer>>();
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> comb = new ArrayList<Integer>();

		if (k == 1) {// base case
			for (int i = 1; i <= n; i++) {
				comb = new ArrayList<Integer>();
				comb.add(i);
				result.add(comb);
			}
			return result;
		} else if (k == n) {// another base case
			for (int i = 1; i <= n; i++) {
				comb.add(i);
			}
			result.add(comb);
			return result;
		} else {
			ArrayList<ArrayList<Integer>> r1 = combine(n - 1, k - 1);// choose n
			ArrayList<ArrayList<Integer>> r2 = combine(n - 1, k);// not choose n

			// add n back to r1
			for (int j = 0; j < r1.size(); j++) {
				r1.get(j).add(n);
			}

			r1.addAll(r2);
			return r1;

		}

	}
}
