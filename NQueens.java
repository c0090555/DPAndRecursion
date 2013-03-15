package DPandRecursion;

/*
 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]

 Solution: DFS + DP 
 Note: 1. when we reach a level, first we make a copy of original solution array, then modify the copy and put the 
 copy to next level, in order to avoid the affect of other results
 2. after replacement a Queen, don't forget to clean it up
 */
import java.util.*;

public class NQueens {
	public ArrayList<String[]> solveNQueens(int n) {
    	// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String[]> res = new ArrayList<String[]>();
		if (n == 0 || n == 2||n==3) {
			return res;
		}
        if(n==1){
            String[] st = new String[1];
            st[0]="Q";
            res.add(st);
            return res;
        }
		String[] sol = new String[n];
		solveNQueensHelper(res, sol, 0, n);
		return res;
	}

	public void solveNQueensHelper(ArrayList<String[]> res, String[] sol,
			int r, int n) {
		if (r == n) {// base case;			
			res.add(sol);
			return;
		}
		StringBuffer line = new StringBuffer();
		for (int j = 0; j < n; j++) {
			line.append(".");
		}
		String[] cp = (String[]) sol.clone();// use a clone of the original sol

		for (int j = 0; j < n; j++) {
			if (feasible(cp, r, j, n)) {
//				 System.out.print(r+" ");
				line.setCharAt(j, 'Q');
//				 System.out.println(line);
				cp[r] = (line.toString());
				solveNQueensHelper(res, cp, r + 1, n);
				line.setCharAt(j, '.');//clean up
			}

		}
		return;

	}

	public boolean feasible(String[] sol, int r, int c, int n) {
		if (r < 0 || r >= n || c < 0 || c >= n) {
			return false;
		}
		if (r == 0) {
			return true;
		}
		for (int i = 0; i < r; i++) {
			if (sol[i].charAt(c) == 'Q') {// same column collision
				return false;
			}
			int diff = Math.abs(r - i);
			if (c - diff >= 0 && sol[i].charAt(c - diff) == 'Q') {// left
																	// diamond
																	// line
				return false;
			}
			if (c + diff < sol[0].length() && sol[i].charAt(c + diff) == 'Q') {// right
																				// diamond
																				// line
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		NQueens o = new NQueens();
		int n = 8;
		ArrayList<String[]> res = o.solveNQueens(n);
		System.out.println(res.size());
		for (int i = 0; i < res.size(); i++) {
			String[] line = res.get(i);
			for (int j = 0; j < line.length; j++) {
//				System.out.println(line[j]);
			}
			// System.out.println();
		}
	}
}
