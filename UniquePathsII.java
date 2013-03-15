package DPandRecursion;

/*
 Follow up for "Unique Paths":

 Now consider if some obstacles are added to the grids. How many unique paths would there be?

 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,

 There is one obstacle in the middle of a 3x3 grid as illustrated below.

 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]

 The total number of unique paths is 2.

 Note: m and n will be at most 100.
 Solution: DP
 */
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = obstacleGrid.length;
		int n = m == 0 ? 0 : obstacleGrid[0].length;
		if (m == 0 || n == 0) {
			return 0;
		}

		int[][] sol = new int[m][n];
		sol[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				sol[i][0] = 0;
			} else {
				sol[i][0] = sol[i - 1][0];
			}
		}
		for (int j = 1; j < n; j++) {
			if (obstacleGrid[0][j] == 1) {
				sol[0][j] = 0;
			} else {
				sol[0][j] = sol[0][j - 1];
			}

		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					sol[i][j] = 0;
				} else {
					sol[i][j] = sol[i - 1][j] + sol[i][j - 1];
				}
			}
		}
		return sol[m - 1][n - 1];

	}

	public static void main(String[] args) {
		UniquePathsII o = new UniquePathsII();
		int[][] grid = { { 0, 0 }, { 0, 0 } };
		System.out.println(o.uniquePathsWithObstacles(grid));
	}

}
