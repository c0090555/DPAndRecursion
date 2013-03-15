package DPandRecursion;

/*
 * Edit Distance

 Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character

 Solution: DP 
 dp[i][j]: mininum distance from s1,s2,...si to t1,t2,...tj

 dp[i][j]=dp[i-1][j-1], if si=tj (insert si)
         =min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+1), if si!=tj
 dp[i-1][j]+1: delete si
 dp[i][j-1]+1: delete tj
 dp[i-1][j-1]+1: replace si with tj 		


 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int len1 = word1.length();
		int len2 = word2.length();
		if (len1 == 0) {
			return len2;
		}
		if (len2 == 0) {
			return len1;
		}
		int[][] dp = new int[len1 + 1][len2 + 1];
		// initialization of dp
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j] + 1,
							Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
				}
			}

		}
		return dp[len1][len2];
	}

	public static void main(String[] args) {
		EditDistance o = new EditDistance();
		String word1 = "horse";
		String word2 = "rose";
		System.out.println(o.minDistance(word1, word2));
	}

}
