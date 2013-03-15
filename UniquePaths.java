package DPandRecursion;
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there? C(m-1+n-1)^(m-1)


Above is a 3 x 7 grid. How many possible unique paths are there? 

Note: m and n will be at most 100.

Solution: easy, but we should pay attention to data overflow
 */
public class UniquePaths {
	  public int uniquePaths(int m, int n) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		  if(m==0||n==0){
	        	 return 0;
		     }
		     if(m==1){
		    	 return 1;
		     }
		     if(n==1){
		    	 return 1;
		     }
		    int count = (m<=n)?m:n;
		     
	        long dividend = 1;
	        long i=1;
	        while(i<=(count-1)){
	        	
	        	dividend*=(m+n-2-i+1);
	            i++;
	        }
//	        System.out.println("dividend "+dividend);
	        long divisor = 1;
	        for(int j=1;j<=count-1;j++){
	        	divisor*=j;
	        }
//	        System.out.print("divisor "+divisor);
	        return (int)(dividend/divisor);
	    
	    }
	  public static void main(String[]args){
		  UniquePaths o = new UniquePaths();
		  int m=100;
		  int n=3;
		  System.out.println(o.uniquePaths(m, n));
	  }

}
