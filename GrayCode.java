package DPandRecursion;
/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 */

import java.util.*;

public class GrayCode {
	public ArrayList<Integer> grayCode(int n)
    {	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(n<0){
    		return null;
    	}
    	
		if(n==0){
			result.add(0);
			return result;
    	}
		ArrayList<Integer> preRes = grayCode(n-1);
		ArrayList<Integer> newRes = new ArrayList<Integer>();
		newRes.addAll(preRes);
		int i= 1<<(n-1);
		Collections.reverse(preRes);
		for(int preNum:preRes){
			int newNum = preNum|i;
			newRes.add(newNum);
		}
		return newRes;
		
    }
		
		
        
		
    
	public static void main(String[] args){
		GrayCode o = new GrayCode();
		int n=3;
		ArrayList<Integer> res = o.grayCode(n);
		System.out.println(res);
	}
}
