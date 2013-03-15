package DPAndRecursive;

/*
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 More practice:

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 Solution:
 Merge consecutive positive numbers and negative numbers

 Solution:
 1. use max_ending_here and max_so_far
 2. divide and conquer, calculate max value with and without A[mid], then return the maximum value
 */
import java.util.*;

public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int l = A.length;
		if (l == 0) {
			return 0;
		}
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
		for (int i = 0; i < l; i++) {
			max_ending_here += A[i];
			max_ending_here = Math.max(max_ending_here, A[i]);
			max_so_far = Math.max(max_ending_here, max_so_far);
		}
		return max_so_far;
	}

	// Solution2: Divide and Conquer
	public int maxSubArray2(int[] A, int l, int h) {
		if (l > h) {
			return Integer.MIN_VALUE;
		}
		if (l == h) {
			return A[l];
		}
		int mid = l + (h - l) / 2;
		int max_left_here = 0;// calculate max from right to left starting at
								// mid
		int lmax = A[mid];
		for (int i = mid; i >= l; i--) {
			max_left_here += A[i];
			lmax = Math.max(lmax, max_left_here);
		}

		int max_right_here = 0;// calculate max from left to right starting at
								// mid
		int rmax = A[mid];
		for (int i = mid; i <= h; i++) {
			max_right_here += A[i];
			rmax = Math.max(rmax, max_right_here);
		}

		int res = Math.max(maxSubArray2(A, l, mid - 1),
				maxSubArray2(A, mid + 1, h));// get the maximum value without
												// A[mid]
		return Math.max(res, lmax + rmax - A[mid]);

	}

}
