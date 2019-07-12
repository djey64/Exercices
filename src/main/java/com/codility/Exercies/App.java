package com.codility.Exercies;

import com.codility.Exercies.prefixsums.minaveragetwoslice.Solution;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Solution solution = new Solution();
//    	int[] A = {4,2,2,5,1,5,8, -210};
    	int[] A = {1,2,3,1,1,1,1};
    	System.out.println(solution.solution(A));
    }
}
