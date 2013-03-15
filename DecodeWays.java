package DPandRecursion;

/*
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26

 Given an encoded message containing digits, determine the total number of ways to decode it.

 For example,
 Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

 The number of ways decoding "12" is 2. 

 DP
 */

public class DecodeWays {
	public int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}

		int N = s.length();
		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			if (s.charAt(i - 2) == '0') {
				if (s.charAt(i - 1) == '0') {
					return 0;
				} else {
					dp[i] = dp[i - 1];
				}
			}

			else if (s.charAt(i - 2) == '1') {
				if (s.charAt(i - 1) == '0') {
					dp[i] = dp[i - 2];
				} else {
					dp[i] = dp[i - 1] + dp[i - 2];
				}
			}

			else if (s.charAt(i - 2) == '2') {
				if (s.charAt(i - 1) == '0') {
					dp[i] = dp[i - 2];
				} else {
					if (s.charAt(i - 1) - '0' > 6) {
						dp[i] = dp[i - 1];
					} else {
						dp[i] = dp[i - 1] + dp[i - 2];
					}

				}
			} else {
				if (s.charAt(i - 1) == '0') {
					return 0;
				} else {
					dp[i] = dp[i - 1];
				}
			}
		}
		return dp[N];
	}

	public static void main(String[] args) {
		DecodeWays o = new DecodeWays();
		String s = "227";
		int n = o.numDecodings(s);
		System.out.println(n);
	}

}
