package DPandRecursion;

/*
 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 For example,
 Given:
 s1 = "aabcc",
 s2 = "dbbca",

 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false. 


 typical dp
 
 if dp[i-1][j]&&s1[i-1]=s3[i-1+j] || dp[i][j-1]&&s2[j-1]==s3[i+1-j] then dp[i][j]=true
 else dp[i][j]=false
 */

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int slen1 = s1.length();
		int slen2 = s2.length();
		int slen3 = s3.length();
		
		//pay attention to these edge conditions
		if (slen3 != slen1 + slen2) {
			return false;
		}
		if (slen1 == 0 && slen2 == 0) {
			return true;
		}
		
		boolean[][] dp = new boolean[slen1 + 1][slen2 + 1];
		dp[0][0] = true;
		for (int i = 1; i <= slen1; i++) {
			if (dp[i - 1][0] == true && s1.charAt(i - 1) == s3.charAt(i - 1)) {
				dp[i][0] = true;
			} else {
				dp[i][0] = false;
			}
		}
		for (int j = 1; j <= slen2; j++) {
			if (dp[0][j - 1] == true && s2.charAt(j - 1) == s3.charAt(j - 1)) {
				dp[0][j] = true;
			} else {
				dp[0][j] = false;
			}
		}

		for (int i = 1; i <= slen1; i++) {
			for (int j = 1; j <= slen2; j++) {
				if ((dp[i - 1][j] == true && s1.charAt(i - 1) == s3.charAt(i
						- 1 + j))
						|| (dp[i][j - 1] == true && s2.charAt(j - 1) == s3
								.charAt(i + j - 1))) {
					dp[i][j] = true;
				} else {
					dp[i][j] = false;
				}

			}
		}

		for (int i = 0; i <= slen1; i++) {
			for (int j = 0; j <= slen2; j++) {
				System.out.print(" " + dp[i][j]);
			}
			System.out.println();
		}
		return dp[slen1][slen2];

	}

	public static void main(String[] args) {
		InterleavingString o = new InterleavingString();
		String s1 = "a";
		String s2 = "b";
		String s3 = "ab";
		System.out.println(o.isInterleave(s1, s2, s3));
	}

}
