package DPAndRecursive;
/*
 Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

Solution: DP - use a boolean[][] visit and four boolean flags(left,right,up,down)
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (board.length == 0 || board[0].length == 0 || word.length() == 0) {
			return false;
		}
		boolean[][] visit = new boolean[board.length][board[0].length];// used
																		// to
																		// indicate
																		// visit
																		// status
		boolean result = false;
		int r = board.length;
		int c = board[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] == word.charAt(0)) {// find the correct starting
					visit = new boolean[board.length][board[0].length]; // position
					result = result || existDP(board, word, visit, i, j, 0);
				}
			}
		}
		return result;

	}

	public boolean existDP(char[][] board, String word, boolean[][] visit,
			int row, int col, int step) {
		if (step == word.length() - 1) {// base case
			return word.charAt(step) == board[row][col];
		}
		if (word.charAt(step) != board[row][col]) {
			return false;
		}

		// use left, right, up, down to indicate the available moving directions
		boolean left = col == 0 ? false : true;
		boolean right = col == board[0].length - 1 ? false : true;
		boolean up = row == 0 ? false : true;
		boolean down = row == board.length - 1 ? false : true;

		boolean result = false;
		visit[row][col] = true;// visit this point

		if (left && !visit[row][col - 1]) {
			result |= existDP(board, word, visit, row, col - 1, step + 1);
		}
		if (right && !visit[row][col + 1]) {
			result |= existDP(board, word, visit, row, col + 1, step + 1);
		}
		if (up && !visit[row - 1][col]) {
			result |= existDP(board, word, visit, row - 1, col, step + 1);
		}
		if (down && !visit[row + 1][col]) {
			result |= existDP(board, word, visit, row + 1, col, step + 1);
		}
		if (step <= word.length() - 1 && result == false) {
			return false;
		}
		return result;

	}

	public static void main(String[] args) {
		WordSearch o = new WordSearch();
		char[][] board = { { 'a' } };
		String word = "ab";
		System.out.println(o.exist(board, word));
	}
}
