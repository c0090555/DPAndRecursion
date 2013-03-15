package DPandRecursion;

/*
 Write a program to solve a Sudoku puzzle by filling the empty cells.

 Empty cells are indicated by the character '.'.

 You may assume that there will be only one unique solution. 
 Solution: DFS

 */
import java.util.*;

class Coordinate {
	public int row;
	public int col;

	Coordinate(int r, int c) {
		row = r;
		col = c;
	}
}

public class Sudoku {
	public void solveSudoku(char[][] board) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int m = board.length;
		int n = m != 0 ? board[0].length : 0;
		if (m != 9 || n != 9) {
			return;
		}
		solveSudokuHelper(board, 0, 0);

	}

	public boolean solveSudokuHelper(char[][] board, int row, int col) {
		Coordinate next = getNextSpot(board, row, col);
		if (next==null) {//done, since we assume there is only one valid solution
			return true;
		}
		ArrayList<Integer> possible = getPossibleList(board, next.row, next.col);

		if (possible.size() == 0)
			return false;
		for (int i = 0; i < possible.size(); i++) {
			board[next.row][next.col] = (char) (possible.get(i) + '0');// place
																		// a
																		// possible
																		// value
			if (solveSudokuHelper(board, next.row, next.col)) {
				return true;
			}
			board[next.row][next.col] = '.';// clean up
		}
		return false;
	}

	public Coordinate getNextSpot(char[][] board, int r, int c) {
		while (r < 9 && c < 9) {// Note: we search for the next spot starting
								// form the point(r,c)
			if (board[r][c] == '.') {
				return new Coordinate(r, c);
			}
			c++;
			r = c == 9 ? r + 1 : r;
			c = c == 9 ? 0 : c;
		}

		return null;
	}

	public ArrayList<Integer> getPossibleList(char[][] board, int r, int c) {
		boolean[] occupy = new boolean[9];
		for (int i = 0; i < 9; i++) {
			if (board[r][i] != '.') {// check row
				occupy[board[r][i] - '1'] = true;
			}
			if (board[i][c] != '.') {// check column
				occupy[board[i][c] - '1'] = true;
			}
			if (board[r / 3 * 3 + i / 3][c / 3 * 3 + i % 3] != '.') {// check
																		// its
																		// own
																		// 3*3
																		// small
																		// square
				occupy[board[r / 3 * 3 + i / 3][c / 3 * 3 + i % 3] - '1'] = true;
			}
		}
		ArrayList<Integer> poss = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			if (!occupy[i]) {
				poss.add(i + 1);
			}
		}
		return poss;

	}

	public static void main(String[] args) {
		Sudoku o = new Sudoku();
		char[][] b = { { '.', '.', '9', '7', '4', '8', '.', '.', '.' },
				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '.', '2', '.', '1', '.', '9', '.', '.', '.' },
				{ '.', '.', '7', '.', '.', '.', '2', '4', '.' },
				{ '.', '6', '4', '.', '1', '.', '5', '9', '.' },
				{ '.', '9', '8', '.', '.', '.', '3', '.', '.' },
				{ '.', '.', '.', '8', '.', '3', '.', '2', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '6' },
				{ '.', '.', '.', '2', '7', '5', '9', '.', '.' } };
		o.solveSudoku(b);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
	}
}
