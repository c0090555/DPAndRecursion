package DPandRecursion;

/*
 The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ... 

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.


 Given an integer n, generate the nth sequence. 

 Note: The sequence of integers will be represented as a string. 
 Solution: Recursion: but it cannot pass the big OJ
 we could use solution 2: iterate based on previous result

 */
import java.util.*;

public class CountAndSay {
	public String countAndSay(int n) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Hashtable<String, String> hash = new Hashtable<String, String>();
		hash.put("11", "21");
		hash.put("12", "1112");
		hash.put("21", "1211");
		return countAndSay2(n);

	}

	public String countAndSayHelper(int n, int index, String st,
			Hashtable<String, String> hash) {
		if (n <= 0) {
			return "";
		}
		if (n == 1) {
			return "1";
		}
		if (n == 2) {
			return "11";
		}
		if (index == n) {
			return st;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < st.length(); i += 2) {
			sb.append(hash.get(st.substring(i, i + 2)));
		}
		return countAndSayHelper(n, index + 1, sb.toString(), hash);

	}

	public String countAndSay2(int n) {// process 2 digits by 2 digits
		if (n == 0) {
			return "";
		}
		if (n == 1) {
			return "1";
		}
		if (n == 2) {
			return "11";
		}
		String current = "11";
		String next = "";

		for (int i = 3; i <= n; i++) {
			for (int j = 0; j < current.length() - 1; j += 2) {
				if (current.charAt(j) == current.charAt(j + 1)) {
					next += "21";
				} else {
					next = next + "1" + String.valueOf(current.charAt(j)) + "1"
							+ String.valueOf(current.charAt(j + 1));
				}

			}
			current = next;
			next = "";

		}
		return current;
	}

	public static void main(String[] args) {
		CountAndSay o = new CountAndSay();
		int n = 5;
		// o.countAndSay(n);
		System.out.println(o.countAndSay(n));
		n = 30;
		System.out.println(o.countAndSay(n));

	}
}
