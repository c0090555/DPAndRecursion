package DPandRecursion;

/*
 Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 For example,
 Given n = 3,
 You should return the following matrix:

 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
Solution: very similar with SpiralMatrix problem, pay attention to "return" statement
 */
public class SpiralMatrixII {
	public static int counter = 0;

	public int[][] generateMatrix(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (n == 0) {
			return new int[0][0];
		}
		counter = 0;
		int[][] matrix = new int[n][n];
		generateMatrixRecur(matrix, 0, n - 1, 0, n - 1);
		return matrix;
	}

	public void generateMatrixRecur(int[][] matrix, int startRow, int endRow,
			int startCol, int endCol) {
		if (startRow > endRow || startCol > endCol) {// base case
			return;
		}
		if (startRow == endRow && startCol == endCol) {// only one element
			counter++;
			matrix[startRow][startCol] = counter;
			return;
		}
		if (startRow == endRow) {// only one row
			for (int j = startCol; j <= endCol; j++) {
				counter++;
				matrix[startRow][j] = counter;
			}
			return;
		}
		if (startCol == endCol) {// only one column
			for (int i = startRow; i < endRow; i++) {
				counter++;
				matrix[i][startCol] = counter;
			}
			return;
		}

		// move left
		for (int j = startCol; j <= endCol; j++) {
			counter++;
			matrix[startRow][j] = counter;
		}
		// move down
		for (int i = startRow + 1; i <= endRow - 1; i++) {
			counter++;
			matrix[i][endCol] = counter;
		}
		// move left
		for (int j = endCol; j >= startCol; j--) {
			counter++;
			matrix[endRow][j] = counter;
		}
		// move up
		for (int i = endRow - 1; i >= startRow + 1; i--) {
			counter++;
			matrix[i][startCol] = counter;
		}
		generateMatrixRecur(matrix, startRow + 1, endRow - 1, startCol + 1,
				endCol - 1);
	}

	public static void main(String[] args) {
		SpiralMatrixII o = new SpiralMatrixII();
		int n = 3;
		int[][] res = o.generateMatrix(n);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}
