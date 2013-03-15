package DPandRecursion;


/*
 Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area. 
 naive method: O(m^2*n^2)
 speed up: O(m^2*n)

 Pre:
 0000
 1110
 1100
 0110

 After
 0000
 3210
 2100
 0210


 *
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = matrix.length;
		
		int n = m==0?0:matrix[0].length;
		if (m == 0 || n == 0) {
			return 0;
		}

		int[][] newMatrix = new int[m][n];
		for (int i = 0; i < m; i++) {// pre-compute
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					newMatrix[i][j] = j < n - 1 ? newMatrix[i][j + 1] + 1 : 1;
				} else {
					newMatrix[i][j] = 0;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, maxArea(newMatrix, i, j));
			}
		}
		return max;

	}

	public int maxArea(int[][] newMatrix, int x, int y) {
		int m = newMatrix.length;
		int n = newMatrix[0].length;
		if (x < 0 || x >= m || y < 0 || y >= n) {
			return -1;
		}
		int lx = x;// left x
		int ly = y;// left y
		int rx = x;// right x
		int ry = ly + newMatrix[lx][ly] - 1;// right y
		int area = (rx - lx + 1) * (ry - ly + 1);
		while (rx < m - 1 && newMatrix[rx][ly] >= 1) {// go down and stop to the
														// second last line or
														// reach a '0'
			area = Math.max(area, (rx - lx + 1) * (ry - ly + 1));
			rx++;// update rx
			ry = Math.min(ry, ly + newMatrix[rx][ly] - 1);// update ry

		}
		if (newMatrix[rx][ly] >= 1) {
			area = Math.max(area, (rx - lx + 1) * (ry - ly + 1));// update for
																	// the last
																	// line
		}
		return area;
	}
	public static void main(String[] args) {
		MaximalRectangle o = new MaximalRectangle();
//		char[][] x = { { '1', '0', '0' }, { '1', '1', '1' } };
		char[][] x ={};
		System.out.println(o.maximalRectangle(x));
	}
}
