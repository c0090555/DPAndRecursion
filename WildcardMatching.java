package DPandRecursion;
/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

Solution:Recursion
Since Java doesn't have pointers in String, we use char array to simulate the pointer operations.
To speed up, merge consecutive '*'
	
 */
public class WildcardMatching {
	public boolean isMatch(String s, String p) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int slen = s.length();
		int plen = p.length();
		if (plen >= 2) {
			String t = "";
			for (int k = 0; k < plen - 1; k++) {
				if (p.charAt(k) == '*' && p.charAt(k + 1) == '*') {
					continue;
				}
				t += p.substring(k, k + 1);
			}
			if (p.charAt(plen - 1) == '*' && p.charAt(plen - 2) != '*') {
				t += "*";
			} else {
				t += p.substring(plen - 1, plen);
			}
			p = t;
			plen = t.length();
		}
		char[] sarr = new char[slen + 1];
		char[] parr = new char[plen + 1];
		for (int i = 0; i < slen; i++) {
			sarr[i] = s.charAt(i);
		}
		for (int j = 0; j < plen; j++) {
			parr[j] = p.charAt(j);
		}
		sarr[slen] = '\0';
		parr[plen] = '\0';
		return isMatchRecur(sarr, 0, parr, 0);

	}

	public boolean isMatchRecur(char[] sarr, int si, char[] parr, int pi) {
		if (sarr[si] == '\0') {
			if (parr[pi] == '\0') {
				return true;
			}
			if (parr[pi] == '*') {
				return isMatchRecur(sarr, si, parr, pi + 1);
			}
			return false;
		}
		if (parr[pi] == '\0') {
			return false;
		}

		if (parr[pi] == sarr[si] || parr[pi] == '?') {
			return isMatchRecur(sarr, si + 1, parr, pi + 1);
		}
		if (parr[pi] == '*') {
			return isMatchRecur(sarr, si + 1, parr, pi)
					|| isMatchRecur(sarr, si, parr, pi + 1);
		}
		return false;

	}

	public static void main(String[] args) {
		WildcardMatching o = new WildcardMatching();
		String s = "abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb";
		String p = "***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**";
		System.out.println(o.isMatch(s, p));

	}
}
