package DPAndRecursive;

/*
 Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
 */
import java.util.*;

public class RestoreIPAddresses {
	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		if (s.length() < 4 || s.length() > 16) {
			return result;
		}
		for (int i = 1; i <= s.length(); i++) {
			if (!isValid(s, 0, i)) {
				break;
			}

			for (int j = i + 1; j <= s.length(); j++) {
				if (!isValid(s, i, j)) {
					break;
				}

				for (int k = j + 1; k <= s.length(); k++) {

					if ((!isValid(s, j, k)) || (!isValid(s, k, s.length()))) {
						continue;
					}
					result.add(s.substring(0, i) + "." + s.substring(i, j)
							+ "." + s.substring(j, k) + "." + s.substring(k));

				}

			}
		}
		return result;

	}

	public boolean isValid(String st, int start, int end) {
		if (start >= end || start < 0 || end > st.length() || st.length() < 4
				|| st.length() > 12) {
			return false;
		}
		if (end - start > 3 || (end - start >= 2 && st.charAt(start) == '0')) {
			return false;
		}
		int num = Integer.parseInt(st.substring(start, end));
		if (num < 0 || num > 255) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		RestoreIPAddresses o = new RestoreIPAddresses();
		ArrayList<String> res = new ArrayList<String>();
		String s = new String("25525511135");
		res = o.restoreIpAddresses(s);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
