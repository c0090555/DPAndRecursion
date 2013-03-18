package DPandRecursion;

/*
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 

 Solution: DP + Hashtable
 */
import java.util.*;

public class ClimbingStairs {
	public Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();

	public int climbStairs(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (hash.containsKey(n)) {
			return hash.get(n);
		}
		if (n == 1) {
			if (!hash.containsKey(1)) {
				hash.put(1, 1);
			}
			return 1;
		} else if (n == 2) {
			if (!hash.containsKey(2)) {
				hash.put(2, 2);
			}
			return 2;
		} else if (n <= 0) {
			if (!hash.containsKey(n)) {
				hash.put(n, 0);
			}
			return 0;
		} else {
			int sum = climbStairs(n - 1) + climbStairs(n - 2);
			if (!hash.containsKey(n)) {
				hash.put(n, sum);
			}
			return sum;
		}

	}

}
