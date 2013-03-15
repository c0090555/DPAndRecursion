package DPandRecursion;
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. 
Solution: Recursion (use startRow, endRow, startCol, endCol to indicate the moving direction)
 */
import java.util.*;

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> res = new ArrayList<Integer>();
		int m = matrix.length;
		if (m == 0) {
			return res;
		}
		int n = matrix[0].length;
		if (n == 0) {
			return res;
		}
		spiralOrderRecur(matrix, res, 0, m - 1, 0, n - 1);
		return res;

	}

	public void spiralOrderRecur(int[][] matrix, ArrayList<Integer> res,
			int startRow, int endRow, int startCol, int endCol) {
		if (startRow > endRow || startCol > endCol) {// base case
			return;
		}
		if (startRow == endRow && startCol == endCol) {// only one element
			res.add(matrix[startRow][startCol]);
			return;
		}
		if (startRow == endRow) {// only one row
			for (int j = startCol; j <= endCol; j++) {
				res.add(matrix[startRow][j]);
			}
			return;
		}
		if (startCol == endCol) {// only one column
			for (int i = startRow; i <= endRow; i++) {
				res.add(matrix[i][startCol]);
			}
			return;
		}

		// move right
		for (int j = startCol; j <= endCol; j++) {
			res.add(matrix[startRow][j]);
		}
		// move down
		for (int i = startRow + 1; i <= endRow - 1; i++) {
			res.add(matrix[i][endCol]);
		}
		// move left
		for (int j = endCol; j >= startCol; j--) {
			res.add(matrix[endRow][j]);
		}
		// move up
		for (int i = endRow - 1; i >= startRow + 1; i--) {
			res.add(matrix[i][startCol]);
		}
		spiralOrderRecur(matrix, res, startRow + 1, endRow - 1, startCol + 1,
				endCol - 1);
		return;

	}
	public static void main(String[] args){
		SpiralMatrix o = new SpiralMatrix();
		int[][] matrix = {{0}};
		System.out.println(o.spiralOrder(matrix));
	}

}
