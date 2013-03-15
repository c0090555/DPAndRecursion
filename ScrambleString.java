package DPandRecursion;


/*
 Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 Below is one possible representation of s1 = "great": 

 Assume string is scrambled at position i, then we need to compare relevant halves of these two string
 */
public class ScrambleString {
	public boolean isScramble(String s1, String s2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s1.length() != s2.length()) {
			return false;
		}

		if (s1.length() == 0) {
			return true;
		}

		if (s1.length() <= 2) {
			return haveSameContent(s1, s2);
		}

		int len = s1.length();
		for (int i = 1; i < len; i++) {
			if (haveSameContent(s1.substring(0, i), s2.substring(len - i, len))
					&& haveSameContent(s1.substring(i, len),
							s2.substring(0, len - i))) {
				boolean left = isScramble(s1.substring(0, i),
						s2.substring(len - i, len));
				boolean right = isScramble(s1.substring(i, len),
						s2.substring(0, len - i));
				if (left && right) {
					return true;
				}

			}
			if (haveSameContent(s1.substring(0, i), s2.substring(0, i))
					&& haveSameContent(s1.substring(i, len),
							s2.substring(i, len))) {
				boolean left = isScramble(s1.substring(0, i),
						s2.substring(0, i));
				boolean right = isScramble(s1.substring(i, len),
						s2.substring(i, len));
				if (left && right) {
					return true;
				}
			}

		}
		return false;

	}

	public boolean haveSameContent(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.length() == s2.length() && s1.length() == 0) {
			return true;
		}
		int[] count = new int[26];// assume string only contains letters from
									// 'a' to 'z'
		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i) - 'a']++;
		}
		for (int j = 0; j < s2.length(); j++) {
			count[s2.charAt(j) - 'a']--;
			if (count[s2.charAt(j) - 'a'] < 0) {
				return false;
			}
		}
		return true;

	}

}
