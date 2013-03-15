package DPAndRecursive;
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false. 
Solution: DP - use a variable range to indicate current range, update the range dynamically
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int l = A.length;
		if (l == 0 || l == 1) {
			return true;
		}
		int range = 0;
		int i = 0;
		while (i <= range) {
			range = Math.max(A[i] + i, range);
			if (range >= l - 1) {
				return true;
			}
			i++;
		}
		return false;

	}
}
