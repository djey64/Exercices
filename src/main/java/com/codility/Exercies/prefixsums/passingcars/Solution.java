package com.codility.Exercies.prefixsums.passingcars;

public class Solution {

	public int solution(int[] A) {
		int result = 0;
		int[] ps = prefixSum(A);
		
		for(int i = 0; i < A.length; i++) {
			if(A[i] == 0) {
				result += ps[ps.length - 1] - ps[i];
				if(result > 1000000000) return -1;
			}
		}
		return result;
	}
	
	public int[] prefixSum(int []A) {
		int[] result = new int[A.length];
		for(int i = 0; i < A.length; i++) {
			if(i == 0) {
				result[i] += A[i]; 
			} else {
				result[i] += A[i] + result[i - 1]; 
			}
		}
		return result;
	}

}
