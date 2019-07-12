package com.codility.Exercies.prefixsums.minaveragetwoslice;

public class Solution {

	public int solution(int[] A) {
		// Prefix sum
		int[] ps = prefixSum(A);
		// Find minimum in matrix and return starting index
		int minimum = findMinAvgSliceIndex(ps);
		
		return minimum;
	}

	/**
	 * find min avg slice starting index
	 * @param ps
	 * @return
	 */
	public int findMinAvgSliceIndex(int[] ps) {
		double min = Integer.MAX_VALUE;
		int minIndex = ps.length - 1;
		for(int i = 1; i < ps.length; i++) {
			double lastValue = Double.MIN_VALUE;
			StringBuilder sb = new StringBuilder();
			for(int j = i + 1; j < ps.length; j++) {
				// Avg between i and j
				double avg = (double) (ps[j] - ps[i - 1]) / (double) (j - i + 1);
				sb.append(avg + ", ");
				if(min > avg) {
					min = avg;
					minIndex = i;
				}
			}
			System.out.println(sb);
		}
		return minIndex - 1;
	}
	
	public int[] prefixSum(int [] A) {
		int[] result = new int[A.length + 1];
		for(int i = 0; i < result.length; i++) {
			if(i == 0) {
				result[i] = 0; 
			} else {
				result[i] += A[i - 1] + result[i - 1]; 
			}
		}
		return result;
	}	
}
